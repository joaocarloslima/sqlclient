package sqlclient.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabela extends JTable {
	
	private static final long serialVersionUID = 1L;

	private DefaultTableModel model = new DefaultTableModel();
	
	public Tabela() {
		setModel(model);
	}

	public void exibirDados(ResultSet rs) throws SQLException {
		Vector<String> registro;
		
		model.setNumRows(0);
		model.setColumnCount(0);

		int columnCount = rs.getMetaData().getColumnCount();
		
		for( int i = 1; i < columnCount+1; i++) {
			String columnName = rs.getMetaData().getColumnName(i);
			model.addColumn(columnName);
		}
		
		
		while(rs.next()) {
			registro = new Vector<String>();
			
			for(int i = 1; i < columnCount+1; i++) {
				registro.add(rs.getString(i));
			}

			model.addRow(registro);		
		}
	}

}
