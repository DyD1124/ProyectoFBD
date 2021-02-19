package negocio;

public class Cuenta {
	
	private String idCuenta;
	private float valor;
	private String estadoCuenta;
	private String numeroReserva;
	
	public Cuenta() {
	}

	public String getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	
}
