package com.teste_notas_hexagonal.JavaNotasTestes.Adapters.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestListaNotasNossoCliente {

    private String  cnpjValido = "123"; // antes de testar certifique que existe o cnpj
    private String  cnpjErrado = "1123"; // antes de testar certifique que não  o existe
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void Caso01() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "MTIzNjU0Nzg5");

        mockMvc.perform(get("/notas/lista_notas_nosso_cliente?cnpj="+cnpjValido).
                contentType("application/json").
                headers(headers)).
                andExpect(status().isOk());
    }

    @Test
    public void Caso02() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "MTIzNjU0Nzg5");

        mockMvc.perform(get("/notas/lista_notas_nosso_cliente?cnpj=").
                contentType("application/json").
                headers(headers)).
                andExpect(status().is(412));
    }

    @Test
    public void Caso03() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "MTIzNjU0Nzg5");

        mockMvc.perform(get("/notas/lista_notas_nosso_cliente?cnpj="+cnpjErrado).
                contentType("application/json").
                headers(headers)).
                andExpect(status().is(404));
    }


}
