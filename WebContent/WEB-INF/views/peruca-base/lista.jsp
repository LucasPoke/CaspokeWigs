<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CaspokeWigs</title>
		<meta charset="utf-8">
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  	<link href="resources/css/caspokewigs.css" media="all" rel="stylesheet" type="text/css" />
	  	
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  	<script src="https://use.fontawesome.com/126680faf3.js"></script>
  
	<script>
	$(function(){
		$(".starrating").rating({
			step: 1,
			clearCaption: 'N�o avaliado',
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
			$(this).parent().text("Peruca em m�os!");
		    $(this).hide();
		});
		
	});
	
	
	</script>
</head>

<body>
	<c:import url="/WEB-INF/views/cabecalho.jsp"/>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h2>Filtros de pesquisa</h2>
				<p>Aqui v�o ficar filtros de busca</p>
			</div>
			<div class="col-sm-8">
				<h2> Resultado</h2>
				<c:if test="${empty perucas}">
					<p>Infelizmente n�o foram encontradas perucas que satisfazem os filtros selecionados.</p>
				</c:if>
				<c:if test="${not empty perucas}">
 					<table id="tabelaPerucasBase" class="table">
  						<c:forEach items="${perucas}" var="p">
						    <tr id="peruca_${p.id}">
						    	<tr>
						    		<td rowspan="5"><a href="${p.peruca.link}"><img src="<c:url value="/resources/imagens/perucas/${p.peruca.id}.jpg"/>" height="150"/></a></td>
						      		<th>Pre�o</th>
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
						      			<td>Rastreio n�o dispon�vel</td>
						      		</c:if>
						      		<c:if test="${not empty p.rastreio}">
						      			<td><a href="http://websro.correios.com.br/sro_bin/txect01$.QueryList?P_LINGUA=001&P_TIPO=001&P_COD_UNI=${p.rastreio}">${p.rastreio}</a></td>
						      		</c:if>
						      	</tr>
						      	<tr>
						      		<th>Local</th>
						      		<td>${p.peruca.local}:${p.peruca.vendedor}</td>
						      		<td></td>
						      		<c:if test="${p.chegou}">
						      			<th>Peruca em m�os!</th>
						      		</c:if>
						      		<c:if test="${not p.chegou}">
						      			<th id="chegada"><button id="${p.id}">Notificar chegada</button></th>
						      		</c:if>
						      	</tr>
						  </c:forEach>
						  </table>
  					</c:if>
  				</div>
  			</div>
  		</div>
</body>
</html>