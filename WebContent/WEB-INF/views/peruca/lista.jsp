<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 	<script src="resources/js/star-rating.js" type="text/javascript"></script>
 	
  
  
	<script>
	$(function(){
		$(".starrating").rating({
			step: 1,
			clearCaption: 'Não avaliado',
			size: 'xs',
			showCaption: false
		});
		
		$(".starrating").rating().on("rating.change", function(event, value) {
				$.post("atualizaAvaliacao", {'id' : this.id, 'valor' : value})
			});
		
		$(".starrating").rating().on("rating.clear", function(event) {
			$.post("atualizaAvaliacao", {'id' : this.id, 'valor' : 0})	
		});
	});
	
	
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
      		<th>Preço</th>
      		<td>$${p.preco}</td>
      		<td><a href="mostraPeruca?id=${p.id}">Alterar</a></td>
      		<td>
      	</tr>
      	<tr>
      		<th>Tamanho</th>
      		<td>${p.tamanho}cm</td>
      		<td><a href="removePeruca?id=${p.id}">Remover</a></td>
      	</tr>
      	<tr>
      		<th>Peso</th>
      		<c:if test="${p.peso == 0}">
      			<td>-</td>
      		</c:if>
      		<c:if test="${p.peso > 0}">
      			<td>${p.peso}g</td>
      		</c:if>
      		<td><a href="novaPerucaBase?id=${p.id}">Usar como peruca base!</a></td>
      	</tr>
      	<tr>
      		<th>Cor</th>
      		<td>${p.cor}</td>
      		<td>
				<input class="starrating" id="${p.id}" value="${p.avaliacao}"/>
      		</td>
      	</tr>
      	<tr>
      		<th>Local</th>
      		<td>${p.local}:${p.vendedor}</td>
      	</tr>
  </c:forEach>
  </table>
  
  <!--
  <table id="tabelaPerucas">
  <tr>
  	<th>Imagem</th>
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
      	<td><a href="${p.link}">Acessar página</a></td>
      
      <td><a href="mostraPeruca?id=${p.id}">Alterar</a></td>
      <td><a href="removePeruca?id=${p.id}">Remover</a></td>
      <td><a href="novoEstoque?id=${p.id}">Adicionar ao estoque</a></td>
    </tr>
  </c:forEach>
  </table>
   -->  
  
  
  
</body>
</html>