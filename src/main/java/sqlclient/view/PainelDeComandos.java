package sqlclient.view;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import sqlclient.controller.ComandoController;

public class PainelDeComandos extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField comando = new JTextField();
	private Tabela tabela = new Tabela();

	private App app;
	
	public PainelDeComandos(App app) {
		this.app = app;
		setLayout(new BorderLayout());
		
		add(comando, BorderLayout.NORTH);
		add(new JScrollPane(tabela), BorderLayout.CENTER);
		
		comando.addActionListener(new ComandoController(this));
		
		comando.setText("SELECT * FROM filmes");
	}

	public App getApp() {
		return app;
	}

	public void exibirDados(ResultSet rs) throws SQLException {
		tabela.exibirDados(rs);		
	}
	
	

}
