package tddpkg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalarioLiquidoTeste {

	SalarioLiquido s;
	@Before
	public void setUp() throws Exception {
		s= new SalarioLiquido();
	}

	@Test
	public void deveriaCalcularINSS() {
		assertEquals("Caso 1: ", 80, s.calcularINSS(1000),0);
		assertEquals("Caso 2: ", 180, s.calcularINSS(2000),0);
		assertEquals("Caso 3: ", 330, s.calcularINSS(3000),0);
		assertEquals("Caso 4: ", 621.04, s.calcularINSS(8000),0);
	}
	
	@Test
	public void deveriaCalcularIRRF() {
		assertEquals("Caso 5: ", 0, s.calcularIRRF(1000),0);
		assertEquals("Caso 6: ", 150, s.calcularIRRF(2200),0);
		assertEquals("Caso 7: ", 350, s.calcularIRRF(3000),0);
		assertEquals("Caso 8: ", 600, s.calcularIRRF(4000),0);
		assertEquals("Caso 9: ", 900, s.calcularIRRF(5000),0);

	}
	@Test
	public void deveriaCalcularPlanoOdontologico() {
		assertEquals("Caso 10: ", 150, s.calcularPlanoOdontologico(3000),0);
		assertEquals("Caso 11: ", 100, s.calcularPlanoOdontologico(2000),0);
		assertEquals("Caso 12: ", 50, s.calcularPlanoOdontologico(1000),0);

	}
	@Test
	public void deveriaCalcularPlanoSaude() {
		assertEquals("Caso 13: ", 300, s.calcularPlanoSaude(3000),0);
		assertEquals("Caso 14: ", 200, s.calcularPlanoSaude(2000),0);
		assertEquals("Caso 15: ", 100, s.calcularPlanoSaude(1000),0);

	}
	@Test
	public void deveriaCalcularValorHora() {
		assertEquals("Caso 16: ", 13.64, s.calcularValorHora(3000),0.01);
		assertEquals("Caso 17: ", 9.09, s.calcularValorHora(2000),0.01);
		assertEquals("Caso 18: ", 4.55, s.calcularValorHora(1000),0.01);

	}
	@Test
	public void deveriaCalcularValorHoraExtra() {
		assertEquals("Caso 19: ", 409.09, s.calcularValorHoraExtra(3000),0);
		assertEquals("Caso 20: ", 272.73, s.calcularValorHoraExtra(2000),0);
		assertEquals("Caso 21: ", 136.36, s.calcularValorHoraExtra(1000),0);

	}
	@Test
	public void deveriaCalcularSalarioLiquido() {
	assertEquals("Caso 22:", 2279.09 , s.calcularSalarioLiquido(3000),0.01);
	assertEquals("Caso 23:", 1642.73 , s.calcularSalarioLiquido(2000),0.01);
	assertEquals("Caso 24:", 906.36  , s.calcularSalarioLiquido(1000),0.01);
	}
}


