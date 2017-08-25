package SistemaViacaoRT;

public class Usuario {
	private String idUsuario;
	private String nomeUsuario;
	private String tipoUsuario;
	
	public Usuario() {
		this.idUsuario = "";
		this.nomeUsuario = "";
		this.tipoUsuario = "";
		
	}public Usuario(String id, String nome, String tipo){
		this.idUsuario = id;
		this.nomeUsuario = nome;
		this.tipoUsuario = tipo;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
