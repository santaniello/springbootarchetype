/**
 * 
 */
$(document).ready(function() {	

	$('.dataTable').dataTable({
		"autoWidth" : true,
		"oLanguage": {
                      "sInfo" : "Mostrando registros de _START_ a _END_ de um total de _TOTAL_",
					  "sInfoEmpty" : "Nenhum registro para exibir",
					  "sSearch" : "Pesquisa r&aacute;pida",
					  "sZeroRecords" : "Nenhum Registro Encontrado !",
		    		  "sInfoFiltered" : "",
					  "sLengthMenu" : "Mostrar _MENU_ entradas",
					  "oPaginate" : {
									"sFirst" : "Primeiro",
									"sNext" : "Proximo",
									"sPrevious" : "Anterior"
							        },						
		}
    });
});	