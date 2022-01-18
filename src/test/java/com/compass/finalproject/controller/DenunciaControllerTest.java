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
public class DenunciaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void deveriaDevolver400CasoAlgumDadoEstejaIncorretoNoPost() throws Exception{
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgLSBEZW51bmNpYSBtYXVzIHRyYXRvcyBhbmltYWlzIiwic3ViIjoiNCIsImlhdCI6MTY0MjUyMTQ0MywiZXhwIjoxNjQyNTI1MDQzfQ.nXWxXNSTDGDF4of1XLvzOYaEmJavwA-FxXOcAegz6Zk";
        String json = "{\"mnsagem\": \"Maus tratos a cachorro no meu prédio\", \"denunciante\": \"1\", \"animal\": {\"tipo\": \"Cachorro\",\"raca\": \"Yorkshire\",\"cor\": \"amarelo\"},\"enderecoDenuncia\": {\"logradouro\": \"Rua das dálias\",\"estado\": \"MG\",\"complemento\": \"Casa\",\"bairro\": \"Portuhyes\",\"cidade\": \"BH\",\"numero\": \"32\",\"cep\": \"22398475\"}}";
        RequestBuilder request = MockMvcRequestBuilders
            .post("/denuncia")
            .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token))
            .content(json)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void deveriaDevolver400CasoAlgumDadoEstejaIncorretoNoUptade() throws Exception{
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgLSBEZW51bmNpYSBtYXVzIHRyYXRvcyBhbmltYWlzIiwic3ViIjoiNCIsImlhdCI6MTY0MjUyMTQ0MywiZXhwIjoxNjQyNTI1MDQzfQ.nXWxXNSTDGDF4of1XLvzOYaEmJavwA-FxXOcAegz6Zk";
        long id = 1;
        String json = "{\"mensagem\": \"Maus tratos a cachorro no meu prédio\", \"anmal\": {\"tipo\": \"Cachorro\",\"raca\": \"Yorkshire\",\"cor\": \"amarelo\"},\"enderecoDenuncia\": {\"logradouro\": \"Rua das dálias\",\"estado\": \"MG\",\"complemento\": \"Casa\",\"bairro\": \"Portuhyes\",\"cidade\": \"BH\",\"numero\": \"32\",\"cep\": \"22398475\"}}";
        RequestBuilder request = MockMvcRequestBuilders
            .put("/denuncia/" + id)
            .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token))
            .content(json)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
