<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	  	
	  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</head>

  	<body>
  		<div class="container">
	  		<nav class="navbar navbar-inverse">
				<p class="navbar-text">Identificação</p>
			</nav>
			<h2>Cadastro</h2>
		  		<div class="col-sm-offset-3 col-sm-6 col-sm-offset-3">
				    
				    <form:form class="form-horizontal" modelAttribute="cliente" action="adicionaCliente" method="post" accept-charset="UTF-8">
				    	<form:input type="hidden" path="id" id="id"/>
				    	
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="nome">Nome</label>
	   						<div class="col-sm-10">
	      						<form:input type="text" class="form-control" id="nome" path="nome" placeholder="Inserir nome" />
	    					</div>
				    	</div>
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="email">Email</label>
	   						<div class="col-sm-10">
	      						<form:input type="text" class="form-control" id="email" path="email" placeholder="Inserir email" value="${c.email}" />
	    					</div>
				    	</div>
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="ssoId">Usuario</label>
				    		<div class="col-sm-10">
				    			<c:choose>
                            		<c:when test="${edit}">
                                		<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>
                            		</c:when>
                            		<c:otherwise>
                                		<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />
                                		<div class="has-error">
                                    		<form:errors path="ssoId" class="help-inline"/>
                                		</div>
                            		</c:otherwise>
                       			</c:choose>
				    		</div>
				    	</div>
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="senha">Senha</label>
	   						<div class="col-sm-10">
	      						<form:input type="password" class="form-control" id="senha" path="senha" placeholder="Inserir senha" />
	    					</div>
				    	</div>
				    	
				    	
				    	<sec:authorize access="hasRole('TOTAL')">
					    	<div class="form-group">
						    	<label class="control-label col-sm-2" for="data">Data de cadastro</label>
						    	<div class="col-sm-10">
						    		<caspoke:campoData id="data"/><br />
						    	</div>
					    	</div>
						    	
						    <div class="form-group">
						    	<label class="control-label col-sm-2" for="type">Permissao</label>
								<div class="col-sm-10">
	                        		<form:select path="profiles" items="${roles}" multiple="true" itemValue="id" itemLabel="tipo" class="form-control input-sm" />
	                        		<div class="has-error">
	                            		<form:errors path="profiles" class="help-inline"/>
	                        		</div>
	                    		</div>
							</div>
						</sec:authorize>
						
				    	<div class="form-group"> 
						    <div class="col-sm-offset-2 col-sm-10">
						    	<c:choose>
                        			<c:when test="${edit}">
                            			<input type="submit" value="Atualizar" class="btn btn-primary btn-sm"/> ou <a href="<c:url value='menu' />">Cancel</a>
                        			</c:when>
                        			<c:otherwise>
                            			<input type="submit" value="Cadastrar" class="btn btn-primary btn-sm"/> ou <a href="<c:url value='menu' />">Cancelar</a>
                        			</c:otherwise>
                    			</c:choose>
						    </div>
						</div>
				    </form:form>
		  		</div>
			    
	    </div>
  	</body>
</html>
  </body>
</html>