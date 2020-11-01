package uno.poo1.banco;

public class BancoTest {

	public static void main(String[] args) {
		CuentaDeAhorro ca = new CuentaDeAhorro(11111111);
		CuentaCorriente cc = new CuentaCorriente(22222222);
		cc.setCuentaDeAhorroAsociada(ca);
		ca.depositar(1000);
		cc.depositar(500);
		
		
		System.out.println(cc.getSaldo());
		System.out.println(ca.getSaldo());
		cc.extraer(1000);
		System.out.println(cc.getSaldo());
		System.out.println(ca.getSaldo());
		
		

	}

}
