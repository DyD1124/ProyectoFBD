package negocio;

public class Pago {
    
    private String idPago;
    private float valorPagado;
    private String fromaPago;
    private String fechaPago;
    private String idCuenta;
    
    public Pago(){
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public float getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(float valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getFromaPago() {
        return fromaPago;
    }

    public void setFromaPago(String fromaPago) {
        this.fromaPago = fromaPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    
    
}
