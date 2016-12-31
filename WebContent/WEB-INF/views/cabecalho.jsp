<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<nav class="navbar navbar-inverse navbar-fixed-top navbar-static-top">
		<div class="container">
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
			        <li class="nav-item active">
			          <a class="nav-link" target="_blank" href="http://www.facebook.com/CaspokeWigs"><i class="fa fa-facebook" aria-hidden="true"></i></a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" target="_blank" href="#"><i class="fa fa-youtube" aria-hidden="true"></i></a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" target="_blank" href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" target="_blank" href="http://www.instagram.com/CaspokeWigs"><i class="fa fa-instagram" aria-hidden="true"></i></a>
			        </li>
		      	</ul>
		      	<ul class="nav navbar-nav navbar-right">
		      		<c:choose>
		      			<c:when test="${empty user}">
		      				<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Entrar</a></li>
		      			</c:when>
		      			<c:otherwise>
		      				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown""><span class="glyphicon glyphicon-user"></span> Olá, ${user.nome}</a>
			        			<ul class="dropdown-menu">
			        				<li><a href="listaOrcamentos">Meus orçamentos</a></li>
			        				<li><a href="#">Minhas encomendas</a></li>
			        				<li role="separator" class="divider"></li>
			        				<li><a href="logout">Sair do sistema</a></li>
			        			</ul>
			        		</li>
			        	</c:otherwise>
			        </c:choose>
			        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
			    </ul>
		     </div>
      	</div>
	</nav>
	
	<div class="jumbotron jumbotron-banner">
		<div class="container">
			<div class="banner-logo-container">
				<a href="menu"><img class="img-responsive" width="600" src="<c:url value="/resources/imagens/caspokewigs/banner-inverso2.png"/>" /></a>
			</div>
		</div>
	</div>
	
	<nav class="navbar navbar-default">
		<div class="container">
			<ul class="nav navbar-nav">
		      <li class="active"><a href="menu">Página inicial</a></li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown""><span class="glyphicon glyphicon-lock"></span>Perucas<span class="caret"></span></a>
		      	<ul class="dropdown-menu">
		      		<li><a href="listaPerucas">Perucas favoritas</a></li>
		      		<li><a href="listaPerucasBase">Perucas compradas</a></li>
		      		<li><a href="novaPeruca">Cadastrar nova peruca</a></li>
		      	</ul>
		      </li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-lock"></span>Clientes<span class="caret"></span></a>
		      	<ul class="dropdown-menu">
		      		<li><a href="listaClientes">Clientes cadastrados</a></li>
		      		<li><a href="novoCliente">Cadastrar novo cliente</a></li>
		      	</ul>
		      </li>
		    </ul>
		</div>
	</nav>