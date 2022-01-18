package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelFormDTO;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.Endereco;
import com.compass.finalproject.entity.OrgaoResponsavel;

import com.compass.finalproject.entity.StatusDenuncia;
import com.compass.finalproject.repository.DenunciaRepository;

import com.compass.finalproject.exceptions.ExceptionResponse;

import com.compass.finalproject.repository.EnderecoRepository;
import com.compass.finalproject.repository.OrgaoReponsavelRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrgaoResponsavelServiceImpl implements OrgaoResponsavelService{

    @Autowired
    OrgaoReponsavelRepository orgaoReponsavelRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    DenunciaRepository denunciaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<OrgaoResponsavelDTO> save(OrgaoResponsavelFormDTO body) {
        try {
            // Salva o Endereco no bando de dados
            Endereco endereco = this.enderecoRepository
                    .save(modelMapper.map(body.getEndereco(), Endereco.class));

            // Converte e atribui ID do endereço ao orgão que será criado
            OrgaoResponsavel orgaoResponsavel = modelMapper.map(body, OrgaoResponsavel.class);
            orgaoResponsavel.setEndereco(endereco);

            // Salva Orgão responsável no banco
            this.orgaoReponsavelRepository.save(orgaoResponsavel);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        
        } catch (Exception e){
            throw new ExceptionResponse(400);
        }
    }

    @Override
    public ResponseEntity<List<DenunciaDTO>> listDenuncias(int id) {
        try {
            Optional<OrgaoResponsavel> orgaoResponsavel = this.orgaoReponsavelRepository.findById(id);
            if (orgaoResponsavel.isPresent()) {
                Optional<List<Denuncias>> denunciasList =
                        this.denunciaRepository.findByOrgaoResponsavelIdEquals(orgaoResponsavel.get().getId());
                if (denunciasList.get().size() > 0){
                    List<DenunciaDTO> denunciaDTO = new ArrayList<>();
                    denunciasList.get().forEach( de -> {
                        System.out.println(de.getOrgaoResponsavel());
                        denunciaDTO.add(modelMapper.map(de, DenunciaDTO.class));
                    });
                    return ResponseEntity.ok(denunciaDTO);
                }
                return ResponseEntity.notFound().build(); // Nenhuma denuncia atribuida ao órgão
            }
            return ResponseEntity.notFound().build();  // Orgão responsável não encontrado
        } catch (Exception e){
            throw new ExceptionResponse(400);
        }
    }

    @Override
    public ResponseEntity<OrgaoResponsavelDTO> uptadeOrgaoResponsavel(int id, OrgaoResponsavelFormDTO body) {
        try {
            Optional<OrgaoResponsavel> orgaoResponsavel = this.orgaoReponsavelRepository.findById(id);
            if (orgaoResponsavel.isPresent()){
                Optional<Endereco> endereco = this.enderecoRepository.findById(
                        orgaoResponsavel.get().getEndereco().getId());

                // Alterando dados do endereço
                endereco.get().setNumero(body.getEndereco().getNumero());
                endereco.get().setLogradouro(body.getEndereco().getLogradouro());
                endereco.get().setEstado(body.getEndereco().getEstado());
                endereco.get().setComplemento(body.getEndereco().getComplemento());
                endereco.get().setBairro(body.getEndereco().getBairro());
                endereco.get().setCidade(body.getEndereco().getCidade());
                endereco.get().setCep(body.getEndereco().getCep());

                // Alterando dados do orgão responsável
                orgaoResponsavel.get().setEmail(body.getEmail());
                orgaoResponsavel.get().setSenha(body.getSenha());
                orgaoResponsavel.get().setTelefone(body.getTelefone());
                orgaoResponsavel.get().setNome(body.getNome());

                return ResponseEntity.ok(modelMapper.map(orgaoResponsavel.get(), OrgaoResponsavelDTO.class));
            }
            return ResponseEntity.notFound().build();   // Órgão responsável não encontrado
        } catch (Exception e) {
            throw new ExceptionResponse(400);
        }
    }

    @Override
    public ResponseEntity<?> alteraStatusDenuncia(int id) {
        OrgaoResponsavel orgaoResponsavel = this.orgaoReponsavelRepository.getById(2);  // Alterar linha para usuário logado
        Optional<Denuncias> denuncia = this.denunciaRepository.findById(id);
        if (denuncia.isPresent()){
            // Verifica de a denuncia já foi atribuida à algum orgão responsável
            // e orgão responsável logado foi atribuido a denúncia,
            // Então pode alterar o status
            if(denuncia.get().getOrgaoResponsavel() != null){
                if(denuncia.get().getOrgaoResponsavel().getId() == orgaoResponsavel.getId()) {
                    if(denuncia.get().getStatus().equals(StatusDenuncia.Aberto)){
                        denuncia.get().setStatus(StatusDenuncia.Em_tratativa);
                        denuncia.get().setDataTratativa(LocalDateTime.now());
                        return ResponseEntity.ok().build();
                    }
                    if(denuncia.get().getStatus().equals(StatusDenuncia.Em_tratativa)){
                        denuncia.get().setStatus(StatusDenuncia.Tratado);
                        denuncia.get().setDataConclusao(LocalDateTime.now());
                        return ResponseEntity.ok().build();
                    }
                    if(denuncia.get().getStatus().equals(StatusDenuncia.Tratado)){
                        return ResponseEntity.badRequest().build(); // Denúncia já tratata
                    }
                }
                return ResponseEntity.badRequest().build(); // Denúncia já atribuida a outro orgão
            }
            // Ainda não há orgão responsável tratando a denúncia
            // Então a denuncia atual é atribuida ao orgão logado
            else {
                denuncia.get().setOrgaoResponsavel(orgaoResponsavel);
                denuncia.get().setStatus(StatusDenuncia.Em_tratativa);
                denuncia.get().setDataTratativa(LocalDateTime.now());
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }


    

}
