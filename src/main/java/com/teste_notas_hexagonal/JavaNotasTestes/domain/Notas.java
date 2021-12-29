package com.teste_notas_hexagonal.JavaNotasTestes.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value="Tipo de Lançamento",example="Pedido ou Nota")
    private String tipoLancamento;
    @ApiModelProperty(value="CNPJ do nosso cliente",example="000-000-00/0001-00")
    private String cnjpNossoCliente;
    @ApiModelProperty(value="Tipo do cliente do emissor")
    private String cnjpCliente;
    @ApiModelProperty(value="Tipo do emissor")
    private String cnpjemissor;
    @ApiModelProperty(value="Valor total")
    private String valorTotal;
    private String valorTotalProdutos;
    private String valorFaturar;
    private List<Lancamento> lancamentos;
    private List<Financeiro> financeiros;
}
