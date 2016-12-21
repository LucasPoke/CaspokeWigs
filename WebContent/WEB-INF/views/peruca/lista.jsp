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

  <table id="tabelaPerucas">
  <tr>
    <th>Id</th>
    <th>Preço</th>
    <th>Tamanho</th>
    <th>Peso</th>
    <th>Cor</th>
    <th>Local</th>
    <th>Vendedor</th>
    <th>Link</th>
  </tr>
  <c:forEach items="${perucas}" var="p">
    <tr id="peruca_${p.id}">
      <td>${p.id}</td>
      <c:if test="${empty p.tamanho}">
      	<td>-</td>
      </c:if>
      <c:if test="${not empty p.tamanho}">
      	<td>${p.preco}</td>
      </c:if>
      <td>${p.tamanho}</td>
      <td>${p.peso}</td>
      <td>${p.cor}</td>
      <td>${p.local}</td>
      <td>${p.vendedor}</td>
      <td><a href="${p.link}">Acessar página</a></td>
      
      <td><a href="mostraPeruca?id=${p.id}">Alterar</a></td>
      <td><a href="removePeruca?id=${p.id}">Remover</a></td>
      <td><a href="novoEstoque?id=${p.id}">Adicionar ao estoque</a></td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>