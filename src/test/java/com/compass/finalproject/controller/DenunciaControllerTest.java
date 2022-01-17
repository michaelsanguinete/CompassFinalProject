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
@ActiveProfiles("test")
public class DenunciaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void deveriaDevolver400CasoAlgumDadoEstejaIncorretoNoPost() throws Exception{
        String json = "{\"mensagem\": \"Maus tratos a cachorro no meu prédio\", \"denunciante\": \"1\", \"animal\": {\"tipo\": \"Cachorr\",\"raca\": \"Yorkshire\",\"cor\": \"amarelo\"},\"enderecoDenuncia\": {\"logradouro\": \"Rua das dálias\",\"estado\": \"MG\",\"complemento\": \"Casa\",\"bairro\": \"Portuhyes\",\"cidade\": \"BH\",\"numero\": \"32\",\"cep\": \"22398475\"}}";
        RequestBuilder request = MockMvcRequestBuilders
            .post("/denuncia")
            .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", ""))
            .content(json)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void deveriaDevolver400CasoAlgumDadoEstejaIncorretoNoUptade() throws Exception{
        long id = 1;
        String json = "{\"mensagem\": \"Maus tratos a cachorro no meu prédio\", \"animal\": {\"tipo\": \"Cachorr\",\"raca\": \"Yorkshire\",\"cor\": \"amarelo\"},\"enderecoDenuncia\": {\"logradouro\": \"Rua das dálias\",\"estado\": \"MG\",\"complemento\": \"Casa\",\"bairro\": \"Portuhyes\",\"cidade\": \"BH\",\"numero\": \"32\",\"cep\": \"22398475\"}}";
        RequestBuilder request = MockMvcRequestBuilders
            .put("/denuncia/" + id)
            .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", ""))
            .content(json)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
