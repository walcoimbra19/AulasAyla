package SistemaViacaoRT;

import java.util.List;

public interface SistemaVendasDePassagens {
	
	public void comprarPassagem(String horarioOnibus, int numeroAssento, String idUsuario)throws AssentoInexistenteException, AssentoOcupadoException;
	public void cadastrarUsuario(String idUsuario, String nome, String tipo) throws UsuarioJaExisteException;
	public int obterNumeroDePassagensVendidasPorHorario (String horarioOnibus);
	public int obterNumeroDePassagensVendidasParaUsuario(String idUsuario);
	public List<Usuario> getUsuarios();
}
