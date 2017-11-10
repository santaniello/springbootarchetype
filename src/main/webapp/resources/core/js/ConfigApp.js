function ConfigApp() {
	
	var _server = function(url) {
		return "/springbootarchetype" + url;
	};
	
	var _isSessionInvalid = function(responseText) {
		return responseText.indexOf("Sessão Encerrada") > -1;
	};
	
	return {
		server : _server,
		
		isSessionInvalid : _isSessionInvalid
	};
	
}