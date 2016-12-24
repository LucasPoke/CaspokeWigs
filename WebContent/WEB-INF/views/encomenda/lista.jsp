<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "div[id^='accordion']" ).accordion({
    	collapsible: true
    });
  } );
  </script>
</head>

<body>
  
  	<a href="logout">Sair do sistema</a>
  	<a href="listaOrcamentos">Voltar � lista de or�amentos</a><br />
  	<a href="menu">Voltar ao menu principal</a><br />

  <br /> <br />        

	<c:forEach items="${encomendas}" var="e">
		<table>
			<tr>
				<th>Personagem:</th>
				<td>${e.orcamento.personagem}</td>
			</tr>
			<tr>
				<th>Pre�o:</th>
				<td>${e.preco}</td>
			</tr>
			<!-- linhda de deadline aqui (se n�o enviado) -->
			<tr>
				<th>Descri��o:</th>
				<td>${e.orcamento.comentarios}</td>
			</tr>
		</table>
		<div id="accordion_${e.id}">
			<h3>Envio</h3>
			<div>
				<table>
					<tr>
						<!--  Endereco -->
						<th>Frete:</th>
						<td>R$${e.frete}</td>
						<th>Rastreio:</th>
						<td>${e.rastreio_br}</td>
					</tr>
				</table>
			</div>
			<h3>Perucas base</h3>
			<div>
				A implementar
			</div>
		</div>
		
	</c:forEach>
	<!-- 
		<table id="tabelaEncomendas">
	  <tr>
	  	<th>Status</th>
	  	<th>Cliente</th>
	    <th>Personagem</th>
	    <th>Pre�o</th>
	    <th>Rastreio</th>
	  </tr>
	  <c:forEach items="${encomendas}" var="e">
		<tr id="encomenda_${e.id}">	
			<td>${e.status}</td>
			<td>${e.orcamento.cliente.nome}</td>
	      	<td>${e.orcamento.personagem}</td>
	      	<td>${e.preco}</td>
	      	<td>${e.rastreio_br}</td>
	      
	      <td><a href="detalharEncomenda?id=${e.id}">Detalhes (N�O IMPL)</a>
	      <td><a href="mostraEncomenda?id=${e.id}">Alterar</a></td>
	      <td><a href="removeEncomenda?id=${e.id}">Remover</a></td>
	    </tr>
	  </c:forEach>
	  </table>
	   -->
</body>
</html>