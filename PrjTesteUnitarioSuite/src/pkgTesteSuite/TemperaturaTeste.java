package pkgTesteSuite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TemperaturaTeste {
Temperatura t;
	@Before
	public void setUp() throws Exception {
		t = new Temperatura();
	}

	@Test
	public void deveriaConverterCelsiusParaFarenheit() {
assertEquals("Caso 1",23,t.celsiusParaFarenheit(-5),0);
assertEquals("Caso 2",32,t.celsiusParaFarenheit(0),0);
assertEquals("Caso 3",64.40,t.celsiusParaFarenheit(18),0);
	}

	@Test
	public void deveriaConverterCelsiusParaKelvin() {
assertEquals("Caso 4",268.150,t.celsiusParaKelvin(-5),0);
assertEquals("Caso 5",273.150,t.celsiusParaKelvin(0),0);
assertEquals("Caso 6",291.150,t.celsiusParaKelvin(18),0);
	}

	@Test
	public void deveriaClassificarTemperatura() {

assertTrue("Caso 7","NEGATIVA"==t.classificaTemperatura(-5));
assertTrue("Caso 8","ZERO"==t.classificaTemperatura(0));
assertTrue("Caso 8","POSITIVA"==t.classificaTemperatura(18));
	}

	@Test
	public void deveriaValidarConversaoValidaConversaoCelsiusFarenheit() {
		assertTrue("Caso 8",true==t.validaConversaoCelsiusFarenheit(-5, 23));
	}

}
