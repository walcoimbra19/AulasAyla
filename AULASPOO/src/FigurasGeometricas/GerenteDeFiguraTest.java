package FigurasGeometricas;

import static org.junit.Assert.*;

import org.junit.Test;

public class GerenteDeFiguraTest {

	@Test
	public void test() {
		GerenteDeFigura gerente = new GerenteDeFigura();
		Retangulo r = new Retangulo();
		//retangulo
		try{
			r.setBase(2);
		}catch(valorInvalidoException e) {
			fail("não deveria ter entrado aqui");
		}
		try{
			r.setAltura(5);
		}catch(valorInvalidoException e) {
			fail("não deveria ter entrado aqui");
		}
		gerente.adicionaFigura(r);
		
		//triangulo
		Triangulo t = new Triangulo();
		try{
			t.setBase(2);
		}catch(valorInvalidoException e) {
			fail("não deveria ter entrado aqui");
		}
		try{
			t.setAltura(5);
		}catch(valorInvalidoException e) {
			fail("não deveria ter entrado aqui");
		}
		gerente.adicionaFigura(t);
		
		
		double areatotal = gerente.calculaAreaTotalDasFiguras();
		System.out.println(areatotal);
		
		//assertEquals(15 ,areatotal);
		assertTrue(areatotal == 15);
		
		
	}

}
