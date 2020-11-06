package uno.poo1.banco;

public class CuentaDeAhorroEspecial extends CuentaDeAhorro {

	private int penalizacion;
	
	public CuentaDeAhorroEspecial(Integer dni, int porcPenal) {
		super(dni);
		this.penalizacion = porcPenal;
		
	}
		
	@Override
	public Double extraer(double monto) {
		try {
			double montoPenalizado = monto*(1+this.penalizacion*1.0/100);
			if((super.getSaldo()) >= montoPenalizado) {
				super.setSaldo(super.getSaldo() - montoPenalizado) ;
				return monto;
			} else throw new SaldoNegativoException("No dispone de dinero suficiente"); 
		} catch (SaldoNegativoException sne) {
			System.err.println(sne.getMessage());
			return 0.0;
		}

		
	}


}
