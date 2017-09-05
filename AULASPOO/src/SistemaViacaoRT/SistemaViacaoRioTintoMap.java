package SistemaViacaoRT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaViacaoRioTintoMap implements SistemaVendasDePassagens {
	private Map<String, Usuario> usuarios;
	private Map<String, Passagem> passagens;
	private final int maxAssentos = 46;
	
	public SistemaViacaoRioTintoMap() {
		this.passagens = new HashMap<String, Passagem>();
		this.usuarios = new HashMap<String, Usuario>();
	}
	@Override
	public void comprarPassagem(String horarioOnibus, int numeroAssento, String idUsuario)
			throws AssentoInexistenteException, AssentoOcupadoException {
		if(numeroAssento > maxAssentos || numeroAssento < 0) {
			throw new AssentoInexistenteException("Este assento não existe: "+numeroAssento);
		}
		Collection<Passagem> lista = this.passagens.values();
		for(Passagem p: lista) {
			if(p.getNumAssento()==numeroAssento) {
				throw new AssentoOcupadoException("Este assento já foi selecionado: "+numeroAssento);
			}
		}
		Passagem p = new Passagem(horarioOnibus, numeroAssento, idUsuario);
		this.passagens.put(idUsuario, p);
		
		
	}

	@Override
	public void cadastrarUsuario(String idUsuario, String nome, String tipo) throws UsuarioJaExisteException {
		if(this.usuarios.get(idUsuario)!=null) {
			throw new UsuarioJaExisteException("Este usuario já esta cadastrado "+nome);
		}
		Usuario u = new Usuario(idUsuario, nome, tipo);
		this.usuarios.put(idUsuario, u);
	}

	@Override
	public int obterNumeroDePassagensVendidasPorHorario(String horarioOnibus) {
		int numeroPassagens = 0;
		List<Passagem> lista = new ArrayList<>(passagens.values());
		for(Passagem p:lista ) {
			if(p.getHorarioBus().equals(horarioOnibus)) {
				numeroPassagens++;
			}
		}
		return numeroPassagens;
	}

	@Override
	public int obterNumeroDePassagensVendidasParaUsuario(String idUsuario) {
		int numeroPassagens = 0;
		List<Passagem> lista = new ArrayList<>(passagens.values());
		for(Passagem p: lista) {
			if(p.getIdUsuario().equals(idUsuario)) {
				numeroPassagens++;
			}
		}
		return numeroPassagens;
	}

	@Override
	public List<Usuario> getUsuarios() {
		List<Usuario> lista = new ArrayList<Usuario>(usuarios.values());
		return lista;
	}

}
