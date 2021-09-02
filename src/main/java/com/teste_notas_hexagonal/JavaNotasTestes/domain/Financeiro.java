package com.teste_notas_hexagonal.JavaNotasTestes.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Financeiro {

    private String  idlancamento;
    private String  duplicata;
    private String  letra;
    private Integer valor;
    private Boolean pago;
}
