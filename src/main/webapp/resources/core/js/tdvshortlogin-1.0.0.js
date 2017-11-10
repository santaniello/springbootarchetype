/**
 * utilizando alert personalizado
 */
alertify.log('Acesso Negado');

var app = new ConfigApp();

var next = window.location.href;
 
if(next.indexOf("logout") > -1) 
	next = "";

shortcut.add("CTRL+M",function() {
	alertify.prompt("...", function (e, str) {
		if(e) {
			var req = app.server("/usuario/login/set/"+str+"/61139432000172/021");			
			if ( (str == 'sdrumond') || (str == 'fgoes') || (str == 'kasouza') || (str == 'ddamaceno') || (str == 'bbernardo') ) 
				window.location = req + "?next="+next;
			else alertify.error('NÃO');
		}
	});	
});