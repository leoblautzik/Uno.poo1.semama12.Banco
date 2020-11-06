package uno.poo1.banco;

public class CuentaDeAhorro extends Cuenta{

	
	public CuentaDeAhorro(Integer dni) {
		super(dni);
		
	}

	@Override
	public Double extraer(double monto) {
		try {
			if(super.getSaldo() >= monto) {
				super.setSaldo(super.getSaldo() - monto);
				return monto;
			} else throw new SaldoNegativoException("No dispone de dinero suficiente"); 
		} catch (SaldoNegativoException sne) {
			System.err.println(sne.getMessage());
			return 0.0;
		}

		
	}

}
