package com.teste_notas_hexagonal.JavaNotasTestes.Adapters.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import com.teste_notas_hexagonal.JavaNotasTestes.framework.adapters.in.rest.NotasRest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestFindbyid {
    private String idValido = "613107884540935102969600"; // antes de testar certifique que existe o id
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void Caso01() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "MTIzNjU0Nzg5");

        mockMvc.perform(get("/notas/findbyid?id="+idValido).
                contentType("application/json").
                headers(headers)).
                andExpect(status().isOk());
    }

    @Test
    public void Caso02() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "MTIzNjU0Nzg5");

        mockMvc.perform(get("/notas/findbyid?id=").
                contentType("application/json").
                headers(headers)).
                andExpect(status().is(412));
    }

}
