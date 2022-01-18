package com.compass.finalproject.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrgaoResponsavelControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void deveriaDevolver400CasoAlgumDadoEstejaIncorretoNoPost() throws Exception{
        String json = "{\"emai\": \"asdasd@teste.com\",\"endereco\":{\"logradouro\": \"Rua das velhas\",\"estado\": \"MG\",\"complemento\": \"Apto 323\",\"bairro\": \"Caiçaras\",\"cidade\": \"BH\",\"numero\": \"asd2\",\"cep\": \"31323232\"},\"nome\": \"Michael\",\"senha\":\"daasdds\",\"telefone\": \"123123123\"}";
        RequestBuilder request = MockMvcRequestBuilders
            .post("/orgaoresponsavel")
            .content(json)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    //É preciso atualizar o token pois ele expira em 1 hora

    @Test
    public void deveriaDevolver400CasoAlgumDadoEstejaIncorretoNoUptade() throws Exception{
        long id = 1;
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgLSBEZW51bmNpYSBtYXVzIHRyYXRvcyBhbmltYWlzIiwic3ViIjoiNCIsImlhdCI6MTY0MjUyMTQ0MywiZXhwIjoxNjQyNTI1MDQzfQ.nXWxXNSTDGDF4of1XLvzOYaEmJavwA-FxXOcAegz6Zk";

        String json = "{\"email\": \"teste@teste.com\",\"endereco\":{\"logradouro\": \"Rua das velhas\",\"estado\": \"MG\",\"complemento\": \"Apto 323\",\"bairro\": \"Caiçaras\",\"cidade\": \"BH\",\"numero\": \"asdasdad\",\"cep\": \"31323232\"},\"nome\": \"Michael\",\"senha\":\"daasdds\",\"telefone\": \"123123123\"}";
        RequestBuilder request = MockMvcRequestBuilders
            .put("/orgaoresponsavel/" + id)
            .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token))
            .content(json)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
