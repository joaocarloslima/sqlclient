package sqlclient.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sqlclient.exception.SQLNaoPermitidoException;
import sqlclient.service.DatabaseService;
import sqlclient.view.PainelDeComandos;

public class ComandoController implements ActionListener {

	private PainelDeComandos view;
	private DatabaseService databaseService = new DatabaseService();

	public ComandoController(PainelDeComandos view) {
		this.view = view;
		
	}

	public void actionPerformed(ActionEvent e) {
		JTextField txtComando = (JTextField) e.getSource();
		try {
			String sql = txtComando.getText();
			
			ResultSet rs = databaseService.execute(
					sql, 
					view.getApp().getCredencial()
			);
			
			if (rs != null) {
				view.exibirDados(rs);
				return;
			}
			
			view.getApp().mostrarMensagem("Registros alterados: " + databaseService.getUpdateCount(), "Update" , JOptionPane.INFORMATION_MESSAGE);
			
			
		} catch (SQLException | SQLNaoPermitidoException erro) {
			view.getApp().mostrarMensagem("Erro: " + erro.getMessage(), "teste", JOptionPane.ERROR_MESSAGE);
			erro.printStackTrace();
		}
		

	}

}
