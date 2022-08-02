package TDD;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SalarioLiquidoTeste {
	SalarioLiquido s;
	@Before
	public void setUp() throws Exception {
		s = new SalarioLiquido();
	}

	@Test
	public void deveriaCalcularINSS() {
	assertEquals("CASO 1:", 80, s.calcularINSS(1000),0);
	assertEquals("CASO 2:", 180, s.calcularINSS(2000),0);
	assertEquals("CASO 3:", 330, s.calcularINSS(3000),0);
	assertEquals("CASO 4:", 621.04, s.calcularINSS(8000),0);
	}

}
