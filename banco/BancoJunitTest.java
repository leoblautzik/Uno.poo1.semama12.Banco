package uno.poo1.banco;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class BancoJunitTest {
	CuentaDeAhorro ca;
	CuentaCorriente cc;
	CuentaCorriente cc2;
	CuentaDeAhorroEspecial cae;

	@Before
	public void setUp() throws Exception {
		ca = new CuentaDeAhorro(11111111);
		cae = new CuentaDeAhorroEspecial(33333333,10);
		cc = new CuentaCorriente(22222222,ca);
		cc2 = new CuentaCorriente(44444444,cae);
		
	}
	
	@Test
	public void extraerCAETest() {
		cae.depositar(1000);
		Assert.assertEquals(100, cae.extraer(100),0.01);
		Assert.assertEquals(890.0,cae.getSaldo(),0.01);
		
	}
	
	@Test
	public void casoPizarron2Test() {
		cc2.depositar(1000);
		cae.depositar(500);
		Assert.assertEquals(1200,cc2.extraer(1200),0.01);
		Assert.assertEquals(0.0,cc2.getSaldo(),0.01);
		Assert.assertEquals(280.0,cae.getSaldo(),0.01);
		
	}
			
	@Test
	public void casoPizarronTest() {
		ca.depositar(100);
		cc.depositar(500);
		
		Assert.assertEquals(550.00, cc.extraer(550), 0.001);
		Assert.assertEquals(0.00, cc.getSaldo(), 0.001);
		Assert.assertEquals(50.00, ca.getSaldo(), 0.001);	
		
	}
	
	@Test
	public void extraerSinTocarCaTest() {
		ca.depositar(100);
		cc.depositar(1000);
		
		Assert.assertEquals(550.00, cc.extraer(550), 0.001);
		Assert.assertEquals(450.00, cc.getSaldo(), 0.001);
		Assert.assertEquals(100.00, ca.getSaldo(), 0.001);	
		
	}
	
	@Test
	public void extraerDeMasCCTest() {
		ca.depositar(100);
		cc.depositar(1000);
		
		Assert.assertEquals(0, cc.extraer(1550), 0.001);
		Assert.assertEquals(1000.00, cc.getSaldo(), 0.001);
		Assert.assertEquals(100.00, ca.getSaldo(), 0.001);	
		
	}
	@Test
	public void extraerTodoCaTest() {
		ca.depositar(100);
		cc.depositar(1000);
		
		Assert.assertEquals(1100.00, cc.extraer(1100), 0.001);
		Assert.assertEquals(0.00, cc.getSaldo(), 0.001);
		Assert.assertEquals(0.00, ca.getSaldo(), 0.001);	
		
	}
	@Test
	public void extraerJustitoSinTocarCaTest() {
		ca.depositar(100);
		cc.depositar(1000);
		
		Assert.assertEquals(1000.00, cc.extraer(1000), 0.001);
		Assert.assertEquals(0.00, cc.getSaldo(), 0.001);
		Assert.assertEquals(100.00, ca.getSaldo(), 0.001);	
		
	}
	

	@Test
	public void depositarCuentaDeAhorroTest() {
		ca.depositar(1000);
		double expected = 1000;
		double actual = ca.getSaldo();
		Assert.assertEquals(expected, actual, 0.001);
		
	}
	
	@Test
	public void extraerSiMeAlcanzaCuentaDeAhorroTest() {
		ca.depositar(1000);
		double saldoExpected = 600;
		double extraerExpected = 400;
		double extraerActual = ca.extraer(400);
		double saldoActual = ca.getSaldo();
		Assert.assertEquals(extraerExpected, extraerActual, 0.001);
		Assert.assertEquals(saldoExpected, saldoActual, 0.001);
	}
	
	@Test
	public void extraerNoMeAlcanzaCuentaDeAhorroTest() {
		ca.depositar(1000);
		ca.extraer(100000);
		double expected = 1000;
		double actual = ca.getSaldo();
		Assert.assertEquals(expected, actual, 0.001);
		
	}
	
	@Test
	public void extraerCAInsuficienteVerExtraerTest() {
		ca.depositar(1000);
		double expected = 0;
		double actual = ca.extraer(100000);
		Assert.assertEquals(expected, actual, 0.001);
		
	}

}
