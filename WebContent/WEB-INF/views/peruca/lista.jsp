<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js">
	</script>
</head>

<body>
  
  	<a href="logout">Sair do sistema</a><br />
  	<a href="novaPeruca">Cadastrar nova peruca</a><br />
  	<a href="menu">Voltar ao menu principal</a><br />

  <br /> <br />      
  <h2> Filtrar por cor</h2>
  
	  <c:forEach items="${cores}" var="c">
	  		<a href="filtraPorCor?cor=${c}"><img src="<c:url value="/resources/imagens/perucas/cores/${c}.png"/>"/></a>
	  </c:forEach>
  		<br />
  		<a href="listaPerucas">Mostrar todas as perucas</a>
  <h2> Resultado</h2>
  <table id="tabelaPerucas">
  <c:forEach items="${perucas}" var="p">
    <tr id="peruca_${p.id}">
    	<tr>
    		<td rowspan="5"><a href="${p.link}"><img src="<c:url value="/resources/imagens/perucas/${p.id}.jpg"/>" height="150"/></a></td>
      		<th>Pre�o</th>
      		<td>${p.preco}</td>
      		<td><a href="mostraPeruca?id=${p.id}">Alterar</a></td>
      		<td>
      	</tr>
      	<tr>
      		<th>Tamanho</th>
      		<td>${p.tamanho}</td>
      		<td><a href="removePeruca?id=${p.id}">Remover</a></td>
      	</tr>
      	<tr>
      		<th>Peso</th>
      		<c:if test="${p.peso == 0}">
      			<td>-</td>
      		</c:if>
      		<c:if test="${p.peso > 0}">
      			<td>${p.peso}</td>
      		</c:if>
      	</tr>
      	<tr>
      		<th>Cor</th>
      		<td>${p.cor}</td>
      	</tr>
      	<tr>
      		<th>Local</th>
      		<td>${p.local}:${p.vendedor}</td>
      	</tr>
      <!-- 
      <td><a href="mostraPeruca?id=${p.id}">Alterar</a></td>
      <td><a href="removePeruca?id=${p.id}">Remover</a></td>
      <td><a href="novoEstoque?id=${p.id}">Adicionar ao estoque</a></td> -->
  </c:forEach>
  </table>
  
  <!--
  <table id="tabelaPerucas">
  <tr>
  	<th>Imagem</th>
    <th>Pre�o</th>
    <th>Tamanho</th>
    <th>Peso</th>
    <th>Cor</th>
    <th>Local</th>
    <th>Vendedor</th>
    <th>Link</th>
  </tr>
  <c:forEach items="${perucas}" var="p">
    <tr id="peruca_${p.id}">
    	<th><img src="<c:url value="/resources/imagens/perucas/${p.id}.jpg"/>" height="150"/></th>
      	<td>${p.preco}</td>
      	<td>${p.tamanho}</td>
      	<c:if test="${p.peso == 0}">
      		<td>-</td>
      	</c:if>
      	<c:if test="${p.peso > 0}">
      		<td>${p.peso}</td>
      	</c:if>
      	<td>${p.cor}</td>
      	<td>${p.local}</td>
      	<td>${p.vendedor}</td>
      	<td><a href="${p.link}">Acessar p�gina</a></td>
      
      <td><a href="mostraPeruca?id=${p.id}">Alterar</a></td>
      <td><a href="removePeruca?id=${p.id}">Remover</a></td>
      <td><a href="novoEstoque?id=${p.id}">Adicionar ao estoque</a></td>
    </tr>
  </c:forEach>
  </table>
   -->  
  
  
  
</body>
</html>