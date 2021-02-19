package negocio;

public class ProductoServicio_Cuenta {

	private String codigo;
	private String idCuenta;
	private int cantidad;
	private String fechaPedido;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

}
