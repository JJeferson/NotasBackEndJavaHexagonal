# NotasBackEndJavaHexagonal
Projeto criado para teste de uso de arquitetura hexagonal.</br>
Usando testes integrados e relatório de cobertura de testes.</br> 
Banco MongoDB com objetos dentro de objetos.
</br></br>
-Requisitos:</br>
*Java11;</br>
*MongoDB;</br>
*Maven instalado e configurado;
</br></br>
-Swagger: http://localhost:8080/swagger-ui.html
</br>
<img src="swagger_img.png"> </br>

</br>

Testes: 100% de cobertura alcançada
Atenção: Para os testes rodar precisa do mongoDB instalado.</br>
Os testes vão testar isso.
<img src="cobertura.png"> </br>


</br></br>
</br>
*Para rodar o relatório de cobertura acesse via dos como administrador da maquina </br>
a pasta do projeto. </br>
Então rode o comando mvn test e aguarde. </br>
Vai baixar dependencias e executar os testes e gerar o relatório.
</br>
Ele vai estar na pasta dentro de \target\site\jacoco\index.html

-Metodos disponiveis até o momento: </br>
 Lista tudo sem paginação. </br>
-[GET] http://localhost:8080/notas/todas_em_lista 
 
exemplo de curl: </br>
curl --location --request GET 'http://localhost:8080/notas/todas_em_lista' \
--header 'Authorization: MTIzNjU0Nzg5'
</br>

-[POST] http://localhost:8080/notas/nova_nota </br>
curl de Exemplo: </br> </br>
curl --location --request POST 'http://localhost:8080/notas/nova_nota' \
--header 'Authorization: MTIzNjU0Nzg5' \
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
</br></br>
-[GET] ListaPorNossoCNPJ/CNPJEMissor </br>
curl de Exemplo:  

curl --location --request GET 'http://localhost:8080/notas/lista_notas_nosso_cliente?cnpj=123' \
--header 'Authorization: MTIzNjU0Nzg5'
</br></br>
-[GET] Find por id </br>
curl de Exemplo:   </br>
curl --location --request GET 'http://localhost:8080/notas/findbyid?id=613107884540935102969600' \
--header 'Authorization: MTIzNjU0Nzg5'