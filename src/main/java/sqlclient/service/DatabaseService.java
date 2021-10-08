package sqlclient.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sqlclient.exception.SQLNaoPermitidoException;
import sqlclient.model.Credencial;
import sqlclient.util.ConnectionFactory;

public class DatabaseService {

	private int updateCount;

	public void testarConexao(Credencial credencial) throws SQLException {
		ConnectionFactory.createConnection(credencial);
	}

	public ResultSet execute(String sql, Credencial credencial) throws SQLException, SQLNaoPermitidoException {
		
		if (!sql.startsWith("SELECT") 
				&& !sql.startsWith("UPDATE") 
				&& !sql.startsWith("DELETE")
				&& !sql.startsWith("INSERT")) {
			throw new SQLNaoPermitidoException("Apenas Select, delete, update e insert são permitidos");
		}
	
		Connection connection = ConnectionFactory.createConnection(credencial);
		
		System.out.println(connection);
		
		PreparedStatement ps = connection.prepareStatement(sql);
		boolean foiUmSelect = ps.execute();
		
		ResultSet resultSet = null;
		
		if (foiUmSelect) {
			resultSet = ps.getResultSet();
		}
		
		updateCount = ps.getUpdateCount();
		
		return resultSet;
		
	}

	public int getUpdateCount() {
		return updateCount;
	}

}
