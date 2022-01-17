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
public class OrgaoResponsavelControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void deveriaDevolver400CasoAlgumDadoEstejaIncorretoNoPost() throws Exception{
        String json = "{\"email\": \"teste@teste.com\",\"endereco\":{\"logradouro\": \"Rua das velhas\",\"estado\": \"MG\",\"complemento\": \"Apto 323\",\"bairro\": \"Caiçaras\",\"cidade\": \"BH\",\"numero\": \"asd2\",\"cep\": \"31323232\"},\"nome\": \"Michael\",\"senha\":\"daasdds\",\"telefone\": \"123123123\"}";
        RequestBuilder request = MockMvcRequestBuilders
                .post("/orgaoresponsavel")
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", ""))
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    public void deveriaDevolver400CasoAlgumDadoEstejaIncorretoNoUptade() throws Exception{
        long id = 1;
        String json = "{\"email\": \"teste@teste.com\",\"endereco\":{\"logradouro\": \"Rua das velhas\",\"estado\": \"MG\",\"complemento\": \"Apto 323\",\"bairro\": \"Caiçaras\",\"cidade\": \"BH\",\"numero\": \"asdasdad\",\"cep\": \"31323232\"},\"nome\": \"Michael\",\"senha\":\"daasdds\",\"telefone\": \"123123123\"}";
        RequestBuilder request = MockMvcRequestBuilders
                .put("/orgaoresponsavel/" + id)
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", ""))
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
