package uno.poo1.banco;

public class CuentaCorriente extends Cuenta {
	
	private Cuenta cuentaDeAhorroAsociada;
	
	public CuentaCorriente(Integer dni , CuentaDeAhorro ca) {
		super(dni);
		this.cuentaDeAhorroAsociada = ca;
			
	}
	
	public Cuenta getCuentaDeAhorroAsociada() {
		return cuentaDeAhorroAsociada;
	}

	public void setCuentaDeAhorroAsociada(Cuenta cuentaDeAhorroAsociada) {
		this.cuentaDeAhorroAsociada = cuentaDeAhorroAsociada;
	}

	@Override
	public Double extraer(double monto) {
		try {
			if(super.getSaldo() >= monto) {
				super.setSaldo(super.getSaldo() - monto);
				
				return monto;
			}
			else {
				
				if(this.cuentaDeAhorroAsociada != null && this.cuentaDeAhorroAsociada.getSaldo() >= (monto - super.getSaldo())) {
					this.depositar(this.cuentaDeAhorroAsociada.extraer(monto - super.getSaldo()));
					super.setSaldo(super.getSaldo() - monto);
					return monto;
				}
				else throw new SaldoNegativoException("No dispone de dinero suficiente");	
			}
			
		} catch (SaldoNegativoException sne) {
			System.err.println(sne.getMessage());
			return 0.0;
		}
	}

}
