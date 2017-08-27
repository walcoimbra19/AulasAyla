package SistemaViacaoRT;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SistemaVRTTest {

	@Test
	public void test() {
		SistemaVRT sistemaViaRT = new SistemaVRT();
		try {
			sistemaViaRT.cadastrarUsuario("020.528.122-29", "Waldemar", "Estudante");
		}catch(UsuarioJaExisteException e) {
			fail("Não deveria ter lançado essa exceção pois o usuario não existe");
		}
		List<Usuario> usuariosCadastrados = sistemaViaRT.getUsuarios();
		assertTrue(usuariosCadastrados.size()==1);
		assertTrue(usuariosCadastrados.get(0).getIdUsuario().equals("020.528.122-29"));
		
		int numeroPassagensVendidas = sistemaViaRT.obterNumeroDePassagensVendidasParaUsuario("020.528.122-29");
		assertTrue(numeroPassagensVendidas == 0);
		assertEquals(0, numeroPassagensVendidas);
		
		
		try {
			sistemaViaRT.comprarPassagem("27Out2011_07:00", 1, "020.528.122-29");
		}catch(AssentoInexistenteException e ) {
			fail("Não deveria ter lançado essa exceção: "+e.getMessage());
		}catch(AssentoOcupadoException e) {
			fail("Não deveria ter lançado essa exceção: "+e.getMessage());
		}
		numeroPassagensVendidas = sistemaViaRT.obterNumeroDePassagensVendidasParaUsuario("020.528.122-29");
		assertEquals(1, numeroPassagensVendidas);
		
		
		
		
		
		try {
			sistemaViaRT.cadastrarUsuario("020.528.122-29", "Waldemar", "Estudante");
			fail("Deveria ter lançado uma exceção aqui");
		}catch(UsuarioJaExisteException e) {
			System.out.println("muito bem");
		}
		
		try {
			sistemaViaRT.comprarPassagem("27Out2011_07:00", 1, "020.528.122-29");
			fail("Deveria  ter lançado uma exceção aqui");
		}catch(AssentoInexistenteException e ) {
			fail("Não deveria ter lançado essa exceção: "+e.getMessage());
		}catch(AssentoOcupadoException e) {
			System.out.println("muito bem");
		}
		numeroPassagensVendidas = sistemaViaRT.obterNumeroDePassagensVendidasParaUsuario("020.528.122-29");
		assertEquals(1, numeroPassagensVendidas);
	
		
	}

}
