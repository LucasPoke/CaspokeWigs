<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js">
	</script>
</head>

<body>
  
  	<a href="logout">Sair do sistema</a><br />
  	<a href="novoOrcamento">Cadastrar novo orcamento</a><br />
  	<a href="menu">Voltar ao menu principal</a><br />

  <br /> <br />        

  <table id="tabelaOrcamentos">
  <tr>
    <th>Id</th>
    <th>Cliente</th>
    <th>Personagem</th>
    <th>Serie</th>
    <th>Local</th>
    <th>Data</th>
    <th>Comentarios</th>
  </tr>
  <c:forEach items="${orcamentos}" var="o">
    <tr id="orcamento_${o.id}">
      <td>${o.id}</td>
      <td>${o.cliente.nome}</td>
      <td>${o.personagem}</td>
      <td>${o.serie}</td>
      <td>${o.local}</td>
      <c:if test="${not empty o.data}">
      	<td><fmt:formatDate 
          value="${o.data.time}" 
          pattern="dd/MM/yyyy"/>
      	</td>
      </c:if>
      <c:if test="${empty o.data}">
      	<td>Data não cadastrada</td>
      </c:if>
      <td>${o.comentarios}</td>
      
      <td><a href="mostraOrcamento?id=${o.id}">Alterar</a></td>
      <td><a href="removeOrcamento?id=${o.id}">Remover</a></td>
      <td><a href="novaEncomenda?id=${o.id}">Converter para encomenda</a></td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>