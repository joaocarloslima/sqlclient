package sqlclient.model;

public class Credencial {

	private String url;
	private String usuario;
	private String senha;

	public Credencial(String url, String usuario, String senha) {
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
		
	}

	public String getUrl() {
		return url;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

}
