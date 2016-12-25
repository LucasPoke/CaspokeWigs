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
	
		<link href="resources/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
		<script src="resources/js/star-rating.js" type="text/javascript"></script>
		
		<script>
			function alteraData(id) {
		      $.post("dataAtual", {'id' : id}, function(resposta) {
		        // selecionando o elemento html através da 
		        // ID e alterando o HTML dele 
		        $("#cliente_"+id).html(resposta);
		      });
		    }
			
			function remove(id) {
			      $.post("remove", {'id' : id}, function() {
			        // selecionando o elemento html através da 
			        // ID e alterando o HTML dele 
			        $(this).closest("tr").hide();
			      });
			    }
		</script>
</head>

<body>
	<c:import url="/WEB-INF/views/cabecalho.jsp"/>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h2>Filtros de pesquisa</h2>
				<p>Aqui vão ficar filtros de busca</p>
			</div>
			<div class="col-sm-8">
				<div class="table-responsive">  
				<table id="tabelaClientes" class="table">
					<tr>
					    <th>Nome</th>
					    <th>Email</th>
					    <th>Data de cadastro</th>
				 	</tr>
				  	<c:forEach items="${clientes}" var="c">
				    <tr id="cliente_${c.id}">
				      	<td>${c.nome}</td>
				      	<td>${c.email}</td>
				      	<td><fmt:formatDate value="${c.data.time}" pattern="dd/MM/yyyy"/></td>
					    <td><a href="mostraCliente?id=${c.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
				      	<td><a href="removeCliente?id=${c.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
			    	</tr>
			  		</c:forEach>
			  	</table>
			  	</div>
		  	</div>
	  	</div>
  	</div>
</body>
</html>