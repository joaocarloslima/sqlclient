package sqlclient.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import sqlclient.model.Credencial;

public class App extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private PainelConexao painelConexao = new PainelConexao(this);
	private PainelDeComandos painelDeComandos = new PainelDeComandos(this);
	

	public App() {
		
		add(painelConexao, BorderLayout.WEST);
		add(painelDeComandos, BorderLayout.CENTER);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SQL Client");
		setSize(800, 400);
		setVisible(true);
		
	}
	
	public void mostrarMensagem(String mensagem, String titulo, int tipo) {
		JOptionPane.showMessageDialog(this, mensagem, titulo, tipo);		
	}

	public Credencial getCredencial() {
		return this.painelConexao.getCredencial();
	}

}
