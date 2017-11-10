/**
 * 
 * Classe UsuarioService
 * 
 */

function UsuarioService() {

	var configApp = new ConfigApp();

	/**
	 * 
	 * Encerra sessao
	 * 
	 */
	var _logout = function() {
		return $.getJSON(configApp.server('/api/login/logout'));
	};

	return {

		logout : _logout

	};

}