package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelFormDTO;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.Endereco;
import com.compass.finalproject.entity.OrgaoResponsavel;
import com.compass.finalproject.repository.EnderecoRepository;
import com.compass.finalproject.repository.OrgaoReponsavelRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrgaoResponsavelServiceImpl implements OrgaoResponsavelService{

    @Autowired
    OrgaoReponsavelRepository orgaoReponsavelRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

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
            e.printStackTrace(); // Método temporário
            return ResponseEntity.internalServerError().build(); // Método temporário
        }
    }

    @Override
    public ResponseEntity<DenunciaDTO> listDenuncias(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<OrgaoResponsavelDTO> uptadeOrgaoResponsavel(int id, OrgaoResponsavelFormDTO body) {
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
        return ResponseEntity.notFound().build();
    }
    
}
