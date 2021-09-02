# NotasBackEndJavaHexagonal
Projeto criado para teste de uso de arquitetura hexagonal.</br>
Usando testes integrados e relatório de cobertura de testes.</br> 
Banco MongoDB com objetos dentro de objetos.
</br></br>
-Requisitos:</br>
*Java11;</br>
*MongoDB;</br>
</br>

-Metodos disponiveis até o momento: </br>
 Lista tudo sem paginação. </br>
-[GET] http://localhost:8080/notas/todas_em_lista </br>
</br></br>
-[POST] http://localhost:8080/notas/nova_nota </br>
Json de Exemplo: </br>

{
"tipoLancamento":"123654897953", </br>
"cnjpNossoCliente":"123654897953", </br>
"cnjpCliente":"123654897953", </br>
"cnpjemissor":"123654897953", </br>
"valorTotal":"999", </br>
"valorTotalProdutos":"999", </br>
"valorFaturar":"999", </br>
"lancamentos":[ </br>
{ </br>
"idlancamento":"1", </br>
"quantidade":"999", </br>
"valorUnitario":"999", </br>
"nomeItem":"999", </br>
"cfop":"999", </br>
"totalLancamento":"999" </br>
}, </br>
{ </br>
"idlancamento":"2", </br>
"quantidade":"999", </br>
"valorUnitario":"999", </br>
"nomeItem":"999", </br>
"cfop":"999", </br>
"totalLancamento":"999" </br>
} </br>
] </br>
} </br>