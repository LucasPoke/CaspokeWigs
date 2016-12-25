<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<nav class="navbar navbar-inverse navbar-fixed-top navbar-static-top">
		<div class="container">
			<!--
			<div class="navbar-header">
			    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>                        
			    </button>
			    <a class="navbar-brand" href="menu">CaspokeWigs</a>
			</div>
			 -->    
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
		      		<c:if test="${empty usuarioLogado}">
		      			<li><a href="loginForm"><span class="glyphicon glyphicon-log-in"></span> Entrar</a></li>
		      		</c:if>
		      		<c:if test="${not empty usuarioLogado}">
			        	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown""><span class="glyphicon glyphicon-user"></span> Olá, ${usuarioLogado.nome}</a>
			        		<ul class="dropdown-menu">
			        			<li><a href="logout">Sair do sistema</a></li>
			        		</ul>
			        	</li>
			        </c:if>
			        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
			    </ul>
		     </div>
      	</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<a href="menu"><img class="img-responsive"  src="<c:url value="/resources/imagens/caspokewigs/banner.png"/>" /></a>
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
		      	</ul>
		      </li>
		      <li><a href="#"><span class="glyphicon glyphicon-lock"></span>Clientes</a></li>
		    </ul>
		</div>
	</nav>