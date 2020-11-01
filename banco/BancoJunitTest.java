package uno.poo1.banco;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class BancoJunitTest {
	CuentaDeAhorro ca;
	CuentaCorriente cc;

	@Before
	public void setUp() throws Exception {
		ca = new CuentaDeAhorro(11111111);
		cc = new CuentaCorriente(22222222);
		cc.setCuentaDeAhorroAsociada(ca);

	}

	@Test
	public void depositarCuentaDeAhorroTest() {
		ca.depositar(1000);
		double expected = 1000;
		double actual = ca.getSaldo();
		Assert.assertEquals(expected, actual, 0.001);
		
	}
	
	@Test
	public void extraerCuentaDeAhorroTest() {
		ca.depositar(1000);
		ca.extraer(100000);
		double expected = 1000;
		double actual = ca.getSaldo();
		Assert.assertEquals(expected, actual, 0.001);
		
	}

}
