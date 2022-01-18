package com.compass.finalproject.service;

import com.compass.finalproject.entity.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup(){
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void deveriaCriarUmUsuario() throws Exception{
        String json = "{\"email\": \"teste@email.com\",\"enderecoUsuario\":{\"logradouro\": \"Rua direita\",\"estado\": " +
                "\"MG\",\"complemento\": \"casa\",\"bairro\": \"Jardim\",\"cidade\": \"BH\",\"numero\": \"50\",\"cep\": " +
                "\"3160000\"},\"nome\": \"Fulano\",\"senha\":\"fdas5453\",\"telefone\": \"36450321\"}";
        RequestBuilder request = MockMvcRequestBuilders
                .post("/usuario")
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void deveriaAtualizarUmUsuario() throws Exception{
        String json = "{\"email\": \"teste@email.com\",\"enderecoUsuario\":{\"logradouro\": \"Rua direita\",\"estado\": " +
                "\"MG\",\"complemento\": \"casa\",\"bairro\": \"Jardim\",\"cidade\": \"BH\",\"numero\": \"50\",\"cep\": " +
                "\"3160000\"},\"nome\": \"Fulano\",\"senha\":\"fdas5453\",\"telefone\": \"36450321\"}";
        long id = 1;
        RequestBuilder request = MockMvcRequestBuilders
                .put("/usuario/" + id)
                .content(json)
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", ""))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void deveBuscarListaCompletaDeDenunciasAtribuidasAoUsuarioDeId1() throws Exception{
        long id = 1;
        String json = "{\"email\": \"teste@email.com\",\"enderecoUsuario\":{\"logradouro\": \"Rua direita\",\"estado\": " +
                "\"MG\",\"complemento\": \"casa\",\"bairro\": \"Jardim\",\"cidade\": \"BH\",\"numero\": \"50\",\"cep\": " +
                "\"3160000\"},\"nome\": \"Fulano\",\"senha\":\"fdas5453\",\"telefone\": \"36450321\"}";
        RequestBuilder request = MockMvcRequestBuilders
                .get("/usuario/"+id+"/denuncias")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", ""));
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
