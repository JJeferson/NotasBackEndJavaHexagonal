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
curl de Exemplo: </br> </br>
curl --location --request POST 'http://localhost:8080/notas/nova_nota' \
--header 'Content-Type: application/json' \
--data-raw '{
"tipoLancamento":"123",
"cnjpNossoCliente":"123",
"cnjpCliente":"123654897953",
"cnpjemissor":"123654897953",
"valorTotal":"999",
"valorTotalProdutos":"999",
"valorFaturar":"999",
"lancamentos":[
{
"idlancamento":"1",
"quantidade":"999",
"valorUnitario":"999",
"nomeItem":"999",
"cfop":"999",
"totalLancamento":"999"
},
{
"idlancamento":"2",
"quantidade":"999",
"valorUnitario":"999",
"nomeItem":"999",
"cfop":"999",
"totalLancamento":"999"
}
]
}'
</br></br></br>
-[GET] ListaPorNossoCNPJ/CNPJEMissor </br>
curl de Exemplo:  
curl --location --request GET 'http://localhost:8080/notas//lista_notas_nosso_cliente?cnpj=123'