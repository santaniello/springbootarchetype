package br.com.tdv.springbootarchetype.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.tdvframework.beans.ConnectionDetail;
import br.com.tdvframework.beans.UsuarioWebLogado;
import oracle.jdbc.OracleTypes;

@Repository("usuarioDao")
public class UsuarioDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDao.class);
	
	
	private String dsJndiName = "java:comp/env/jdbc/TdvGlobal";	
	
	@Autowired @Qualifier("dsProducao")
	private DataSource dsProducao;
	
	public ConnectionDetail getConnectionDetail() throws SQLException {
		logger.info( "getConnectionDetail()..." );
		Connection connection = dsProducao.getConnection();
		ConnectionDetail connectionDetail = null;
		try{
			connectionDetail = new ConnectionDetail(dsJndiName, connection);
		} finally{
			connection.close();
		}
		return connectionDetail;
	}	
		

	/**
	 * Pega dados do usuario pelo usuarioCodigo e cnpj
	 * @param usuario
	 * @param cnpj
	 * @return Contato
	 */
	public UsuarioWebLogado getUsuario(String usuario, String cnpj) {
		logger.info( "getUsuario("+usuario+", "+cnpj+")..." );
		String procName = "tdvadm.Pkg_Usu_UsuarioWeb.Sp_Get_Usuario";
		
		CallableStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		UsuarioWebLogado usuarioLogado = null; // 		
		
		try {
			conn = this.dsProducao.getConnection();
			stmt = conn.prepareCall("{ call "+procName+"(:pUsuario, :pCursor, :pStatus, :pMessage) }");
			
			stmt.setString(1, usuario);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.registerOutParameter(3, OracleTypes.VARCHAR);
			stmt.registerOutParameter(4, OracleTypes.VARCHAR);

			stmt.execute();	
			
			String status = stmt.getString(3).toString().trim();
			
			if( "N".equals( status ) == false ){
				throw new RuntimeException( stmt.getString(4).toString() );
			}
						
			rs = (ResultSet) stmt.getObject(2);
			if (rs.next()) {
				// TODO valida Telefone, email, nome, nome completo, cnpj
				usuarioLogado = new UsuarioWebLogado();
				usuarioLogado.setCodigo( rs.getString("usu_usuario_codigo") == null ? "" : rs.getString("usu_usuario_codigo").trim() );
				usuarioLogado.setLogin( rs.getString("usu_usuario_login") == null ? "" : rs.getString("usu_usuario_login").trim() );
				usuarioLogado.setNome( rs.getString("usu_usuario_nome") == null ? "" : rs.getString("usu_usuario_nome").trim() );
    			usuarioLogado.setTelefoneCelular( rs.getString("usu_usuario_celular") == null ? "" : rs.getString("usu_usuario_celular").trim() );
				//usuarioLogado.setCnpjLogado( rs.getString("usu_usuario_cpf") == null ? "" : rs.getString("usu_usuario_cpf").trim() );
    			usuarioLogado.setCnpjLogado( cnpj );
				usuarioLogado.setEmail( rs.getString("usu_usuario_email") == null ? "" : rs.getString("usu_usuario_email").trim() );
				usuarioLogado.setTelefoneRamal( rs.getString("usu_usuario_ramal") == null ? "" : rs.getString("usu_usuario_ramal").trim());
			}
		} catch (SQLException e) {
			logger.error( e.getMessage() );
			throw new RuntimeException(e);
		} finally {
			try {
				this.dsProducao.getConnection().close();;
			} catch (SQLException e) {
				logger.error( "Erro ao fechar conexão: " + e.getMessage() );
				e.printStackTrace();
				throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage());
			}
		}
		
		return usuarioLogado;
	}	
	
}
