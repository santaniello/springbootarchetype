package br.com.tdv.springbootarchetype.services;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.tdv.springbootarchetype.repositories.UsuarioDao;
import br.com.tdvframework.beans.ConnectionDetail;
import br.com.tdvframework.beans.UsuarioWebLogado;

@Service("usuarioService")
public class UsuarioService {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired @Qualifier("usuarioDao")
	private UsuarioDao usuarioDao;

	public ConnectionDetail getConnectionDetail() {
		logger.info( "getConnectionDetail()..." );
		try {
			return this.usuarioDao.getConnectionDetail();
		} catch (RuntimeException | SQLException e) {
			logger.error( e.getMessage() );
			e.printStackTrace();			
			throw new RuntimeException(e.getMessage());
		}
	}	
	
	public UsuarioWebLogado getUsuario(String usuario, String cnpj) {
		logger.info( "getUsuario( "+usuario+", "+cnpj+" )..." );
		try{
			return this.usuarioDao.getUsuario(usuario, cnpj);
		} catch (RuntimeException e) {
			logger.error( e.getMessage() );
			e.printStackTrace();			
			throw new RuntimeException(e.getMessage());
		}			
	}	
	
}
