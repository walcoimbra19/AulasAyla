package SistemaViacaoRT;

import java.util.ArrayList;
import java.util.List;

public class SistemaVRT implements SistemaVendasDePassagens {
	
	private List<Passagem> passagens;
	private List<Usuario> usuarios;

	public SistemaVRT() {
		this.passagens = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	}
	
	@Override
	public void comprarPassagem(String horarioOnibus, int numeroAssento, String idUsuario)
			throws AssentoInexistenteException, AssentoOcupadoException {
		int maxAcentos = 46;
		if(numeroAssento > maxAcentos ||numeroAssento < 0 ) {
			throw new AssentoInexistenteException("Essa poltrona não existe: "+numeroAssento);
		}
		for (Passagem p: this.passagens) {
			if(p.getNumAssento()==(numeroAssento)) {
				throw new AssentoOcupadoException("Essa poltrona já esta ocupada: "+numeroAssento);
			}
		}Passagem passagem = new Passagem(horarioOnibus, numeroAssento, idUsuario);
		passagens.add(passagem);
		
	}

	@Override
	public void cadastrarUsuario(String idUsuario, String nome, String tipo) throws UsuarioJaExisteException {
		for(Usuario usuario: this.usuarios) {
			if(usuario.getIdUsuario().equals(idUsuario)) {
				throw new UsuarioJaExisteException("já existe usuario com esse ID: "+idUsuario);
			}
			
		}
		Usuario g = new Usuario(idUsuario, nome, tipo);
		this.usuarios.add(g);
		
	}

	@Override
	public int obterNumeroDePassagensVendidasPorHorario(String horarioOnibus) {
		int quantPassagens = 0;
		for(Passagem p: this.passagens) {
			if(p.getHorarioBus().equalsIgnoreCase(horarioOnibus)){
				quantPassagens++;
			}
		}
		return quantPassagens;
	}

	@Override
	public int obterNumeroDePassagensVendidasParaUsuario(String idUsuario) {
		int quantPass = 0;
		for(Passagem p: this.passagens) {
			if(p.getIdUsuario().equalsIgnoreCase(idUsuario)) {
				quantPass++;
			}
		}
		return quantPass;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

}
