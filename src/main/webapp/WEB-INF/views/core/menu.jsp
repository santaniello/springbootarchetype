<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	
	<c:set var="primeiroNome" value="${fn:split(usuarioLogado.nome, ' ')}" />

    <div class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
      <div class="">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}">
			<img src="${pageContext.request.contextPath}/resources/core/img/logo-tdv.png" height="30px" alt="Cadastro TDV"/>
		  </a>
        </div>
        <div class="navbar-collapse collapse">

		  <c:if test="${not empty usuarioLogado}">
		    	<ul class="nav navbar-nav">
		        	<li class="active">
						<a href="${pageContext.request.contextPath}/" >
							<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
							Menu1								
						</a>
		            </li>
		            <li>
						<a href="${pageContext.request.contextPath}/" >
							<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
							Menu2
						</a>
		            </li> 
		  		</ul>
	  				  
	          <ul class="nav navbar-nav navbar-right" ng-show="usuLoginCtrl.isLogged == true" style="font-family: monospace;">
	            <li class="dropdown">
	              <a href= class="dropdown-toggle" data-toggle="dropdown">
	              		<img src="${pageContext.request.contextPath}/resources/core/img/default-avatar.png" height="18px" class="img-circle" alt=""> 
<!-- 						<i class="fa fa-user fa-lg"></i> -->
						&nbsp; <span class="username hidden-xs">${ primeiroNome[0] }</span> 
						&nbsp; <span class="caret"></span>
				  </a>
	              <ul class="dropdown-menu" role="menu"> 
					<li class="dropdown-header">
						Login: <span class="badge"><i class="glyphicon glyphicon-user"></i> ${ usuarioLogado.login }</span>
					</li>
					<li class="dropdown-header">
						CNPJ.: <span class="badge"><i class="glyphicon glyphicon-credit-card"></i> ${ usuarioLogado.cnpjLogado }</span>
					</li>
					<li class="dropdown-header">
						Email: <span class="badge"><i class="glyphicon glyphicon-envelope"></i> ${ usuarioLogado.email }</span>
					</li>
					<li role="separator" class="divider"></li>
					<li class="dropdown-header">
						<i class="glyphicon glyphicon-phone-alt"></i> Telefones..:
					</li>
					<li class="dropdown-header">
						<span class="badge"><i class="glyphicon glyphicon-earphone"></i> ${ usuarioLogado.telefoneRamal }</span>
					</li>
					<li class="dropdown-header">
						<span class="badge"><i class="glyphicon glyphicon-earphone"></i> ${ usuarioLogado.telefoneCelular }</span>
					</li>
	                <li class="divider"></li>
					<li class="">
						<a href="http://extranet.dellavolpe.com.br:6917/usuario/editsimple/${ usuarioLogado.codigo }" onclick="showDialog(this.href); return false;">
							<i class="glyphicon glyphicon-user"></i> &nbsp; Alterar Perfil...
						</a>
					</li>						
	                <li class="divider"></li> 		                
					<li class="dropdown-header">
						<a href="#" onclick="logout();">
							<i class="glyphicon glyphicon-log-out"></i> &nbsp; Sair
						</a>
					</li>
	              </ul>
	            </li>
	          </ul> 
	               
	 		  <ul class="nav navbar-nav navbar-right">
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span class="username hidden-xs">Ajuda</span> 
						<span class="caret"></span>
				  </a>
	              <ul class="dropdown-menu" role="menu">
					<li>
						<!-- <a target="blank" href="http://extranet.dellavolpe.com.br:2100/shares/tdvsis/jcoleta/jcoleta.pdf">Manual</a>-->
						<a href="#" target="blank" >Manual</a>
					</li>
	              </ul>
	            </li>
	          </ul>	               
	               
		  </c:if>
                    
        </div><!--/.nav-collapse -->
      </div>
    </div>
    
    <script type="text/javascript">
    	
	    function showDialog(url) {
	     	var urlLogin = 'http://extranet.dellavolpe.com.br:6917/usuario/usuario/login/set/${  usuarioLogado.codigo }/${ usuarioLogado.cnpjLogado }/000';
	   		url = urlLogin + '?next='+ url;
      		modalSmallShowSimple("Alterar Perfil",'<iframe width="100%" marginHeight=0 marginWidth=0 scrolling=no style="min-height:595px;" frameborder="0" src="'+url+'"></iframe>');
	    }             
    	
	    var modalSmallShowSimple = function(title, body) {
	    	$('#myModalSmallLabel').html(title);
	    	$('#id-modalSmall-body').html(body); 
	    	$('#modalSmall-btn-close').html("Fechar"); 
	    	$('#modalSmall-btn-save').hide();							
	    	$('#myModalSmall').modal('show'); 
	    }; 
    
    </script>    
    