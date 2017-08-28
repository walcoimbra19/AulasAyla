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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
	
	
	
	
}
