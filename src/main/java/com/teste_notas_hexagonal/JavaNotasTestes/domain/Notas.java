package com.teste_notas_hexagonal.JavaNotasTestes.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Document(collection="Notas")
public class Notas {
    @Id
    @JsonProperty("id")
    private String id;
    private String tipoLancamento;
    private String cnjpNossoCliente;
    private String cnjpCliente;
    private String cnpjemissor;
    private String valorTotal;
    private String valorTotalProdutos;
    private String valorFaturar;
    private List<Lancamento> lancamentos;
    private List<Financeiro> financeiros;
}
