<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!--========================================================================================================================-->
<!--*** Modal Connection Detail ********************************************************************************************-->
<!--========================================================================================================================-->
<div class="modal fade showModalFooter" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      
      	<div class="modal-header" style="background-color:#f49b17;color:white;">
        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        	<h3 class="modal-title"><i class="glyphicon glyphicon-link"></i> Connection Detail</h3>
      	</div>
		
		<div class="modal-body">
       		<h5>DataSource: <span class="label label-default">${ connectionDetail.poolName }</span></h5>
        	<h5>User:       <span class="label label-default">${ connectionDetail.databaseUser }</span></h5>
        	<h5>Usuario:    <span class="label label-default">${ usuarioLogado != null ? usuarioLogado.nome : null }</span></h5>
        	<h5>CNPJ:       <span class="label label-default">${ usuarioLogado != null ? usuarioLogado.cnpjLogado : null }</span></h5>
        	<h5 id="urlModalFooter" class="hidden">URL:        <small class="label label-default">${ connectionDetail.databaseUrl }</small></h5>
      	</div>
      	
      	<div class="modal-footer">
       		<button type="button" class="btn btn-default" data-dismiss="modal"><i class="glyphicon glyphicon-log-out"></i> Fechar</button>
      	</div>
            
    </div>
  </div>
</div>

<div class="footer">
     <div class="container">
       <p class="text-muted">
   		<strong>Connection Detail:</strong> 
   		<a data-toggle="modal" data-target=".showModalFooter">
   			${connectionDetail != null ? connectionDetail.poolName : 'NoConnection'}
   		</a> 
       	&nbsp;|&nbsp; 2015-2016 &copy; Transportes Della Volpe by TI Development. 
       	&nbsp;|&nbsp; <strong>versão:</strong> ${initParam.version}
       </p>
     </div> 
</div>	   
<script language="JavaScript" src="http://codigofonte.uol.com.br/wp-content/uploads/legado/codigos/833/shortcut.js"></script>
<script>
	shortcut.add("CTRL+ALT+D",function() {
		if($('#urlModalFooter').hasClass("hidden")){
			$('#urlModalFooter').removeClass("hidden");			
		}else{
			$('#urlModalFooter').addClass("hidden");
		}
	});
</script> 


