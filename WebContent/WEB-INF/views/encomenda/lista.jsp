<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js">
	</script>
</head>

<body>
  
  	<a href="logout">Sair do sistema</a>
  	<a href="listaOrcamentos">Voltar à lista de orçamentos</a><br />
  	<a href="menu">Voltar ao menu principal</a><br />

  <br /> <br />        

	<!-- LISTA SIMPLIFICADA	 -->
  <table id="tabelaEncomendas">
  <tr>
  	<th>Status</th>
  	<th>Cliente</th>
    <th>Personagem</th>
    <th>Preço</th>
    <th>Rastreio</th>
  </tr>
  <c:forEach items="${encomendas}" var="e">
	<tr id="encomenda_${e.id}">	
		<td>${e.status}</td>
		<td>${e.orcamento.cliente.nome}</td>
      	<td>${e.orcamento.personagem}</td>
      	<td>${e.preco}</td>
      	<td>${e.rastreio_br}</td>
      
      <td><a href="detalharEncomenda?id=${e.id}">Detalhes (NÃO IMPL)</a>
      <td><a href="mostraEncomenda?id=${e.id}">Alterar (NÃO IMPL)</a></td>
      <td><a href="removeEncomenda?id=${e.id}">Remover</a></td>
    </tr>
  </c:forEach>
  </table>

</body>
</html>