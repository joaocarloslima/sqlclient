package sqlclient.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sqlclient.controller.ConexaoController;
import sqlclient.model.Credencial;

public class PainelConexao extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtUrl = new JTextField(20);
	private JTextField txtUsuario = new JTextField(20);
	private JTextField txtSenha = new JTextField(20);
	private JButton botao = new JButton("Testar Conexão");

	private App app;
	
	public PainelConexao(App app) {
		this.app = app;
		setPreferredSize(new Dimension(250, 400));
		
		add(new JLabel("URL JDBC"));
		add(txtUrl);
		add(new JLabel("Usuário"));
		add(txtUsuario);
		add(new JLabel("Senha"));
		add(txtSenha);
		add(botao);
		
		txtUrl.setText("jdbc:mysql://localhost:3306/fiapplus");
		txtUsuario.setText("root");
		
		botao.addActionListener(new ConexaoController(this));
	}

	public Credencial getCredencial() {
		return new Credencial(
				txtUrl.getText(), 
				txtUsuario.getText(),
				txtSenha.getText()
			);
		
	}

	public App getApp() {
		return app;
	}


	
	

}
