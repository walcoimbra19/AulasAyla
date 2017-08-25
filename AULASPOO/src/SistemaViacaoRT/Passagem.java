package SistemaViacaoRT;

public class Passagem {
	private String horarioBus;
	private int numAssento;
	private String idUsuario;
	
	public Passagem () {
		this.horarioBus = "";
		this.numAssento = 0;
		this.idUsuario = "";
		
	}
	public Passagem (String horario, int num, String id) {
		this.horarioBus = horario;
		this.idUsuario = id;
		this.numAssento = num;
	}
	public String getHorarioBus() {
		return horarioBus;
	}
	public void setHorarioBus(String horarioBus) {
		this.horarioBus = horarioBus;
	}
	public int getNumAssento() {
		return numAssento;
	}
	public void setNumAssento(int numAssento) {
		this.numAssento = numAssento;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
