package uno.poo1.banco;

public abstract class Cuenta {
	private Double saldo;
	private Integer dni;
	
	public Cuenta(Integer dni) {
		this.saldo=0.0;
		this.dni=dni;
	}
	
	public void depositar(double monto) {
		this.saldo+=monto;
	
	}
	public abstract Double extraer(double monto);
	
	public Double getSaldo() {
		return saldo;
	}

	protected void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	} 
	
	
	
	
	
	
}
