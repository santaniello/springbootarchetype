<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="pt-br">

  <head>
    <title>${ initParam.project }</title>
	<!-- start: META -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="Sistemas Transportes Della Volpe" name="description" />
	<meta content="TDV TI Development" name="author" />

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/tdv/img/favicon.png">

    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/tdv/css/common.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/static/bootstrap/css/sticky-footer-navbar.css" rel="stylesheet">
	<link href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css" rel="stylesheet" >
	
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/ie-emulation-modes-warning.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/tdv/js/window-common.js" type="text/javascript"></script>	
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
			<img id="img-spinner" src="${pageContext.request.contextPath}/static/tdv/img/loading.gif" alt="Aguarde..."/>
			<p id="id_message_load">Aguarde...</p>
		</div>	
    
		<!-- start: PAGE CONTENT -->

				<div class="container">

 						<!-- start: BREADCRUMB -->
						<div class="row">
							<div class="col-md-12">
								<ol class="breadcrumb">
									<li>
										<a href="#">
											<span  class="glyphicon glyphicon-home"></span>
										</a>
									</li>
									<li class="active">
										Erro 500
									</li>
								</ol>
							</div>
						</div>
						<!-- end: BREADCRUMB -->
						<!-- start: PAGE CONTENT -->
						<div class="row">
							<div class="col-md-12 text-center">
								<div class="page-error animated shake">
									<div class="error-number text-warning"><h1>500</h1></div>
									<div class="error-details col-sm-6 col-sm-offset-3">
										<h3>Oops! Erro no servidor: <p><small class="text-danger">${pageContext.exception}</small></p></h3>
										<br/>
										<p>
											Estamos trabalhando para melhorar o sistema!
											<br/><br/> 
											Não deixe de relatar os erros para o Departamento de T.I.
										</p>
										<br/>
										<p>											
											<a href="${pageContext.request.contextPath}" class="btn btn-primary btn-return">
												<span class="glyphicon glyphicon-home"></span> Retornar para Página Home
											</a>
											<!-- 
											<br>
											<!-- Still no luck? 
											<br>
											Pesquisar, ou dar uma olhada em todo o resto do nosso sistema.
											-->
										</p>
										<!-- 
										<form action="#">
											<div class="input-group">
												<input type="text" placeholder="digite o que procura..." size="16" class="form-control">
												<span class="input-group-btn"><button class="btn btn-warning">Pesquisar</button></span>
											</div>
										</form>
										--> 
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-1"></div>									    
							<div class="col-md-10">
								
								<div class="panel panel-white">
									<div class="panel-body">						
										<div class="table-responsive">
										   <div style="width:100%; height:400px; overflow: auto;" >						
												<table class="table table-condensed table-hover table-striped table-bordered" >
													<thead>
														<tr class="danger text-red" valign="top">
															<td width="40%"><b>Error:</b></td>
															<td class="class_exceptionMessage">${pageContext.exception}</td>
														</tr>
													</thead>
													<tbody>
														<tr class="success" valign="top">
															<td><b>URI:</b></td>
															<td class="class_uri">${pageContext.errorData.requestURI}</td>
														</tr>		
														<tr class="active" valign="top">
															<td><b>Status code:</b></td>
															<td class="class_statusCode">${pageContext.errorData.statusCode}</td>
														</tr>		
														<tr class="warning" valign="top">
															<td><b>Stack trace:</b></td>
															<td> 
																<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
																	<p>${trace}</p>
																</c:forEach>
															</td>
														</tr>																											
													</tbody>
												</table>	
											</div>
										</div>		
									</div>
								</div>																			
							</div>
						<div class="col-md-1"></div>							
						</div>
						<!-- end: PAGE CONTENT-->
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

    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
	<script>
		jQuery(document).ready(function() {
			$("#spinner").bind("ajaxSend", function() {
				$(this).show();
			}).bind("ajaxStop", function() {
				$(this).hide();
			}).bind("ajaxError", function() {
				$(this).hide();
			});
			$(document).ajaxStart(function(){
				$('#spinner').show();
				$( "button" ).addClass('disabled');
			 }).ajaxStop(function(){
				 $('#spinner').hide();
				 $( "button" ).removeClass( "disabled" );
			 });					
		});
	</script>    
    
  </body>
</html>
