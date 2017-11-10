<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="pt-br">

	 <head>
	 	<title>${ initParam.project }</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta content="Cadastros Della Volpe" name="description" />
		<meta content="TDV TI Development" name="author" />
	
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/core/img/favicon.png">
	
	   	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/core/css/common.css" type="text/css" rel="stylesheet" />
		<link href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css" rel="stylesheet" >
		<link href="${pageContext.request.contextPath}/resources/bootstrap/css/sticky-footer-navbar.css" rel="stylesheet">
	   	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	   	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie-emulation-modes-warning.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/core/js/window-common.js"></script>	
		<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	   	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	   	<!--[if lt IE 9]>
	     <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	     <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	   <![endif]-->
	 </head>

<body>
  
    <!-- Fixed navbar -->
	<jsp:include page="menu.jsp"></jsp:include>

    <div class="container">
    
		<div id="spinner" class="spinner" style="display:none;">
			<img id="img-spinner" src="${pageContext.request.contextPath}/resources/core/img/loading.gif" alt="Aguarde..."/>
			<p id="id_message_load">Aguarde...</p>
		</div>	
    
    
		<!-- start: PAGE CONTENT -->

		<div class="container">

			<div>
				<div class="col-md-12 text-center">
					<div class="page-error animated shake">
						
						<p>
							<img alt="Logo Della Volpe" src="${pageContext.request.contextPath}/resources/bootstrap/img/logo-tdv.png">
						</p>
						
						<div class="panel panel-default">
							<div class="panel-body">
								<img alt="404" src="${pageContext.request.contextPath}/resources/bootstrap/img/404.png">
							
								<p class="text-warning">
									Infelizmente, a página que você acessou não pode ser encontrado.
									<br/><br/> 
									Ela pode estar temporariamente indisponível, movido ou não existe mais.
									<br/>
								</p>
								<br/>
							</div>
						</div>
						<p>											
							<a href="${pageContext.request.contextPath}/" class="btn btn-warning btn-return">
								<span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp; Retornar para Página Home
							</a>
						</p>						
					</div>
				</div>
			</div>

		</div>			
		<!-- end: PAGE CONTENT-->
		
    </div> <!-- /container -->
    
    <div class="footer">
      <div class="container">
        <p class="text-muted">
        	<strong>Context:</strong> 
        	<span class="underline">${configuracaoAcesso.dataSourcePoolName}</span> 
        	&nbsp;|&nbsp; 2014 &copy; Transportes Della Volpe by TI Development. 
        	&nbsp;|&nbsp; <strong>versão:</strong> ${initParam.version}
        </p>
      </div>
    </div>	    

    <!-- Bootstrap core JavaScript ============================================================================== -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    
</body>
</html>
