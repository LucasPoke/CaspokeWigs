<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>CaspokeWigs</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  	<script src="https://use.fontawesome.com/126680faf3.js"></script>
	  	
	  	<link href="resources/css/caspokewigs.css" media="all" rel="stylesheet" type="text/css" />
	  	
	</head>

	<body>
  		<c:import url="/WEB-INF/views/cabecalho.jsp"/>
  		<div class="container">
			<c:choose>
			<c:when test="${empty orcamentosEmEspera}">
				<p> Você não tem orçamentos cadastrados no momento</p>
				<a href="novoOrcamento">Clique aqui para solicitar um orçamento!</a>
	  		</c:when>
	  		<c:otherwise>
	  			<div class="col-sm-2">
	  				<a href="novoOrcamento">Novo orçamento</a>
	  			</div>
	  			<div class="col-sm-10">
	  				<h2>Meus orçamentos</h2>
	  				<div class="panel-group" id="accordion">
	  					<c:forEach items="${orcamentosEmEspera}" var="oe">
  						<div class="panel panel-default">
  							<div class="panel-heading">
     							<h4 class="panel-title">
        							<a data-toggle="collapse" data-parent="#accordion" href="#collapse${oe.id}">${oe.personagem}, ${oe.serie}</a> <!-- tratar quanto nulos -->
      							</h4>
    						</div>
  							<div id="collapse${oe.id}" class="panel-collapse collapse">
  								<div class="panel-body">
  								<!-- personagem, serie, data de cadastro, mensagens, imagens, botao pra pagamento -->
  								<div class="col-sm-8">
	  								<div class="media">
	  								<c:forEach items="${oe.mensagens}" var="msg">
	  									<c:choose>
	  									<c:when test="${msg.doCliente==true}">
		  									<div class="media-left">
		  										<h4>${user.nome} <small><i>Postada em <fmt:formatDate value="${msg.data.time}" pattern="yyyy-MM-dd HH:mm:ss" /></i></small></h4>
		  										<p>${msg.texto}</p>
		  									</div>
		  								</c:when>
		  								<c:otherwise>
		  									<div class="media-right">
		  										<h4>CaspokeWigs <small><i>Postada em <fmt:formatDate value="${msg.data.time}" pattern="yyyy-MM-dd HH:mm:ss" /></i></small></h4>
		  										<p>${msg.texto}</p>
		  									</div>
		  								</c:otherwise>
		  								</c:choose>
		  							</c:forEach>
		  							<div class="input-group">
		  								<textarea id="novaMensagem" rows="3" class="form-control"></textarea>
		  								<span class="input-group-addon"><i class="glyphicon glyphicon glyphicon-envelope"></i></span>
		  							</div>
	  								</div>
	  							</div>
  								<div class="col-sm-4">
  									<p>Aqui vão ficar as imagens</p>
  								</div>
  								</div>
  							</div>
  						</div>
  						</c:forEach>
  					</div>
	  			</div>
	  			<!-- 
	  			<div class="table-responsive"> 
	  			<table id="tabelaOrcamentos" class="table">
		  			<c:forEach items="${orcamentosEmEspera}" var="o">
		    			<tr id="orcamento_${oe.id}">
		      				<th>Personagem:</th>
		      				<td>${o.personagem}</td>
						</tr>
						<tr>
							<th>Série:</th>
		      				<td>${o.serie}</td>
		      				<th>Plataforma:</th>
		      				<td>${o.local}</td>
		    			</tr>
		    			<tr>
		    				<th>Comentários:</th>
		    				<td colspan="3">${oe.comentarios}</td>
		      				<th><a href="#" class="btn btn-success">Solicitar encomenda</a></th>
		   				 </tr>
		  			</c:forEach>
				</table>
				</div>
				 -->
			</c:otherwise>
			</c:choose>
		</div>
</body>
</html>