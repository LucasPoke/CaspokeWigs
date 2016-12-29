<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>

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
	
		<link href="resources/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
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
		
		var cor = "#" + $("span[id^='cor_']").attr('id').substring(4);
		console.log(cor)
		if (cor != null)
			$(".banner-logo-container").css("background-color", cor);
	});
	
	
	</script>
</head>

<body>
	<c:import url="/WEB-INF/views/cabecalho.jsp"/>
	<span id="cor_${corSelecionada.cod}"></span>
	<div class="container">
		<nav class="navbar navbar-default fill-space">
			<ul>
				<c:forEach items="${cores}" var="c">
					<li class="fill-space">
						<a href="filtraPorCor?cor=${c}"><img width="100%" height="auto" src="<c:url value="/resources/imagens/perucas/cores/${c}.png"/>"/></a>
					</li>
				</c:forEach>
			</ul>
		</nav>
		<div class="row">
			<div class="col-sm-4">
		  		<h2> Filtros de busca</h2>
		  		
			  	<div class="col-sm-12">
		  			<p>Aqui vão ficar opções adicionais de filtro
		  		</div>
		  		
			  	<a href="listaPerucas">Mostrar todas as perucas</a>
			</div>
			<div class="col-sm-8">
				<h2> Resultado</h2>
				<c:if test="${empty perucas}">
					<p>Infelizmente não foram encontradas perucas que satisfazem os filtros selecionados.</p>
				</c:if>
				<c:if test="${not empty perucas}">
				<form action="solicitaImagem" method="post">
					<table id="tabelaPerucas" class="table">
						<c:forEach items="${perucas}" var="p">
							<tr id="peruca_${p.id}">
					   			<td rowspan="5"><input type="checkbox" name="selecao" value="${p.id}::${p.cor}" /></td>	
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
					<br /><br /><input type="submit" value="Adicionar imagem às selecionadas">
				</form>
				</c:if>
  			</div>
  		</div>
	</div>
	
</body>
</html>