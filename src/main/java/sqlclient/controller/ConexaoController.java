package sqlclient.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sqlclient.model.Credencial;
import sqlclient.service.DatabaseService;
import sqlclient.view.PainelConexao;

public class ConexaoController implements ActionListener {
	
	private DatabaseService databaseService = new DatabaseService();
	private PainelConexao view;

	public ConexaoController(PainelConexao painelConexao) {
		this.view = painelConexao;
		
	}

	public void actionPerformed(ActionEvent e) {
		Credencial credencial = view.getCredencial();
		
		try {
			databaseService.testarConexao(credencial);
			view.getApp().mostrarMensagem("Conexão realizada com sucesso", "Conectado", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e1) {
			view.getApp().mostrarMensagem("Erro ao conectar", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		

	}

}
