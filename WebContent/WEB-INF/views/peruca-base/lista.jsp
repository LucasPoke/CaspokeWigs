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
		
		$("button").click(function(){
			$.post("atualizaChegada", {'id' : this.id });
			$(this).parent().text("Peruca em mãos!");
		    $(this).hide();
		});
		
	});
	
	
	</script>
</head>

<body>
  	<a href="logout">Sair do sistema</a><br />
  	<a href="menu">Voltar ao menu principal</a><br />

  <h2>Perucas base</h2>
  <table id="tabelaPerucasBase">
  <c:forEach items="${perucas}" var="p">
    <tr id="peruca_${p.id}">
    	<tr>
    		<td rowspan="5"><a href="${p.peruca.link}"><img src="<c:url value="/resources/imagens/perucas/${p.peruca.id}.jpg"/>" height="150"/></a></td>
      		<th>Preço</th>
      		<td>$${p.peruca.preco}</td>
      		<td><a href="mostraPerucaBase?id=${p.id}">Alterar</a></td>
      		<td>
      	</tr>
      	<tr>
      		<th>Tamanho</th>
      		<td>${p.peruca.tamanho}cm</td>
      		<td><a href="removePerucaBase?id=${p.id}">Remover</a></td>
      	</tr>
      	<tr>
      		<th>Peso</th>
      		<c:if test="${p.peruca.peso == 0}">
      			<td>-</td>
      		</c:if>
      		<c:if test="${p.peruca.peso > 0}">
      			<td>${p.peruca.peso}g</td>
      		</c:if>
      		<th>Quantidade:</th>
      		<td>${p.quantidade}</td>
      	</tr>
      	<tr>
      		<th>Cor</th>
      		<td>${p.peruca.cor}</td>
      		<th>Rastreio:</th>
      		<c:if test="${empty p.rastreio}">
      			<td>Rastreio não disponível</td>
      		</c:if>
      		<c:if test="${not empty p.rastreio}">
      			<td>${p.rastreio}</td>
      		</c:if>
      	</tr>
      	<tr>
      		<th>Local</th>
      		<td>${p.peruca.local}:${p.peruca.vendedor}</td>
      		<td></td>
      		<c:if test="${p.chegou}">
      			<th>Peruca em mãos!</th>
      		</c:if>
      		<c:if test="${not p.chegou}">
      			<th id="chegada"><button id="${p.id}">Notificar chegada</button></th>
      		</c:if>
      	</tr>
  </c:forEach>
  </table>
  
</body>
</html>