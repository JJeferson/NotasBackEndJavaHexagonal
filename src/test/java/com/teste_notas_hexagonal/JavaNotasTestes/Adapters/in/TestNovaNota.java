package com.teste_notas_hexagonal.JavaNotasTestes.Adapters.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste_notas_hexagonal.JavaNotasTestes.domain.Notas;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestNovaNota {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void Caso01() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "MTIzNjU0Nzg5");

        Notas obj = preparaObjeto();
        mockMvc.perform(post("/notas/nova_nota").
                contentType("application/json").
                content(objectMapper.writeValueAsString(obj)).
                headers(headers)).
                andExpect(status().isOk());
    }

    private Notas preparaObjeto(){
        Notas registro1 = new Notas();
        registro1.setCnjpCliente("1111111111111");
        registro1.setCnpjemissor("1111111111111");
        registro1.setCnjpNossoCliente("111111111111111");
        registro1.setTipoLancamento("Nota");
        return registro1;
    }
}
