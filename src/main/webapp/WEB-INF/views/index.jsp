<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>${ initParam.project }</title>
	<!-- start: META -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="pt-br">
	<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="${ initParam.project }" name="description" />
	<meta content="TDV TI Development at 2015/2016" name="author" />

    <link href="${ pageContext.request.contextPath }/resources/core/img/favicon.png" rel="shortcut icon" >

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/jquery-ui.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/sticky-footer-navbar.css" rel="stylesheet">
	
	<!-- Plugin Select 2 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.css">
	<!-- Plugin font-awesome / Icones -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/font-awesome/css/font-awesome.min.css">
	<!-- Datatable Plugin -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/dataTables/media/css/dataTables.bootstrap.css">
	
	<!-- alert customizado -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/alertify.js-0.3.11/themes/alertify.core.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/alertify.js-0.3.11/themes/alertify.default.css" id="toggleCSS" />
	<style>
		.alertify-log-custom {
			background: blue;
		}
	</style>	
	
	<script src="${pageContext.request.contextPath}/resources/core/js/ConfigApp.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/alertify.js-0.3.11/lib/alertify.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/alertify.js-0.3.11/configAlertify.js"></script>
	
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie-emulation-modes-warning.js"></script>

	<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.min.1.11.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/configDatePicker.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>

	<jsp:include page="core/menu.jsp"></jsp:include>
	<jsp:include page="core/modal-small.jsp"></jsp:include>
	
	<c:if test="${not empty content_page}">
		<c:import url="${content_page}"></c:import>
	</c:if>

	<jsp:include page="core/footer.jsp"></jsp:include>
	
    <!-- JS Bootstrap core JavaScript ======================================================================================== -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
    <script src="${pageContext.request.contextPath}/resources/core/js/services/UsuarioService.js"></script>	
	<!-- Pligin Select 2 -->
	<script src="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/select2/configSelect2.js"></script>	
	<!-- Datatable Plugin -->
	<script src="${pageContext.request.contextPath}/resources/plugins/dataTables/media/js/jquery.dataTables.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/dataTables/media/js/dataTables.bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/dataTables/configDataTable.js"></script>	    
		
	<!-- end: CORE JAVASCRIPTS  -->
	<script type="text/javascript">
		jQuery(document).ready(function() {
			// Diego --> Loading 
			$("#spinner").bind("ajaxSend", function() {
				$(this).show();
			}).bind("ajaxStop", function() {
				$(this).hide();
			}).bind("ajaxError", function() {
				$(this).hide();
			});
			// Diego --> Loading Ajax
			$(document).ajaxStart(function(){
				$('#spinner').show();
				$( "button" ).addClass('disabled');
			 }).ajaxStop(function(){
				 $('#spinner').hide();
				 $( "button" ).removeClass( "disabled" );
			 });					
		});
		
		// encerra sessao
		function logout() {
			var usuarioService = new UsuarioService();
			usuarioService.logout().success(function() {
				//window.close();
			}).fail(function(error) {
				if(error.status == 200) { 
					//window.close();
					window.location.href = "http://extranet.dellavolpe.com.br";
				} 
				else alert("Erro ao encerrar sessão\n"+JSON.stringify(error));
			});
		}
		
	</script>    
	
</body>
</html>
