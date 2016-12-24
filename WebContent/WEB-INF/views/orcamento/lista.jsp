<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>

	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link href="resources/css/theme.css" media="all" rel="stylesheet" type="text/css" />
	<link href="resources/css/font-awesome.css" media="all" rel="stylesheet" type="text/css" />
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 	<script src="resources/js/star-rating.js" type="text/javascript"></script>
 	<script src="resources/js/theme.js" type="text/javascript"></script>
 	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	<link href="resources/css/caspokewigs.css" media="all" rel="stylesheet" type="text/css" />
	
	<script>
	//NÃO USADO
	$(function(){
		$('.kv-ltr-theme-fa-star').rating({
			min: 0,
			max: 6,
			stars: 6,
			step: 1,
			clearCaption: 'Não avaliado',
			size: 'xs',
			showCaption: true,
			showClear: false,
			theme: 'krajee-fa',
			starCaptions: {1: 'Aguardando entrada', 2: 'Aguardando compra', 3: 'Aguardando materiais', 4: 'Em desenvolvimento', 5: 'Concluido', 6: 'Enviado'}
		});
		
		$('.kv-ltr-theme-fa-star').rating().on("rating.change", function(event, value) {
				if (value > 1)
				{
					$.post("novaEncomenda", {'id' : this.id, 'statusId' : value})
				}
			});
	});
	</script>
	
	
	
</head>

<body>
  
  	<a href="logout">Sair do sistema</a><br />
  	<a href="novoOrcamento">Cadastrar novo orcamento</a><br />
  	<a href="menu">Voltar ao menu principal</a><br />
  <br /> <br />        

	<h3>Lista de orçamentos em espera</h3>
	<br />
	  <table id="tabelaOrcamentos">
		  <c:forEach items="${orcamentosEmEspera}" var="oe">
		    <tr id="orcamento_${oe.id}">
		      	<th>Personagem:</th>
		      	<td>${oe.personagem}</td>
		      	<th>Cliente:</th>
		      	<td>${oe.cliente.nome}</td>
		      	<td><a href="mostraOrcamento?id=${oe.id}">Alterar</a></td>
			</tr>
			<tr>
				<th>Série:</th>
		      	<td>${oe.serie}</td>
		      	<th>Plataforma:</th>
		      	<td>${oe.local}</td>
		      	<td><a href="removeOrcamento?id=${oe.id}">Remover</a></td>
		    </tr>
		    <tr>
		    	<th>Comentários:</th>
		    	<td colspan="3">${oe.comentarios}</td>
		      	<th><a href="novaEncomenda?id=${oe.id}">Pagamento recebido</a></th>
		    </tr>
		   	
		      <!-- 
		      <c:if test="${not empty o.data_cadastro}">
		      	<td><fmt:formatDate 
		          value="${o.data_cadastro.time}" 
		          pattern="dd/MM/yyyy"/>
		      	</td>
		      </c:if>
		      <c:if test="${empty o.data_cadastro}">
		      	<td>Data não cadastrada</td>
		      </c:if>
		      -->
		  </c:forEach>
		</table>
  
  <br /><br /><br />
      <h3>Orçamentos aceitos</h3>
      <br />
      
       <table id="tabelaOrcamentos">
		  <c:forEach items="${orcamentosAceitos}" var="oa">
		    <tr id="orcamento_${oa.id}">
		      	<th>Personagem:</th>
		      	<td>${oa.personagem}</td>
		      	<th>Cliente:</th>
		      	<td>${oa.cliente.nome}</td>
		      	<td><a href="mostraOrcamento?id=${oa.id}">Alterar</a></td>
			</tr>
			<tr>
				<th>Série:</th>
		      	<td>${oa.serie}</td>
		      	<th>Plataforma:</th>
		      	<td>${oa.local}</td>
		      	<td><a href="removeOrcamento?id=${oa.id}">Remover</a></td>
		    </tr>
		    <tr>
		    	<th>Comentários:</th>
		    	<td colspan="3">${oa.comentarios}</td>
		    </tr>
		     
		  </c:forEach>
  		</table>
</body>
</html>