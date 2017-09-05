package SistemaViacaoRT;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
public class SistemaViacaoRioTintoMapTest {

	@Test
	public void test()  {
		SistemaViacaoRioTintoMap sistema = new SistemaViacaoRioTintoMap();
		try { 
			sistema.cadastrarUsuario("020.528.122-29", "Waldemar", "Estudante");
		}catch(UsuarioJaExisteException e) {
			fail("não deveria ter chegado aqui");
		}
		
		try {
			sistema.comprarPassagem("27Out2011_07:00", 50, "020.528.122-29");
		}catch(AssentoInexistenteException e) {
			System.out.println("é pra ter lançado essa excessão"+e.getMessage());
		}catch(AssentoOcupadoException e ) {
			fail("não deveria ter lançado essa excessão");
		}
		
		List<Usuario> testeListaUsuario = sistema.getUsuarios();
		assertTrue(testeListaUsuario.size()==1);
		assertTrue(testeListaUsuario.get(0).getIdUsuario().equals("020.528.122-29"));
		int passagensVendidas = sistema.obterNumeroDePassagensVendidasParaUsuario("020.528.122-29");
		assertEquals(1, passagensVendidas);
		
		
		try { 
			sistema.cadastrarUsuario("020.528.122-29", "Waldemar", "Estudante");
		}catch(UsuarioJaExisteException e) {
			System.out.println("muito bem");
		}
		
		try {
			sistema.comprarPassagem("27Out2011_07:00", 50, "020.528.122-29");
		}catch(AssentoInexistenteException e) {
			System.out.println("é pra ter lançado essa excessão"+e.getMessage());
		}catch(AssentoOcupadoException e ) {
			System.out.println("muito bem");
		}
		
		
		
	}

}
