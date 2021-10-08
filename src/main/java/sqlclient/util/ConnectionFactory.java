package sqlclient.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sqlclient.model.Credencial;

public class ConnectionFactory {
	
	
	private static Connection connection;

	public static Connection createConnection(Credencial credencial) throws SQLException {
		
		if(connection == null ) {
			connection = DriverManager.getConnection(
					credencial.getUrl(), 
					credencial.getUsuario(), 
					credencial.getSenha()
					);	
		}
		
		return connection;
		
	}

}
