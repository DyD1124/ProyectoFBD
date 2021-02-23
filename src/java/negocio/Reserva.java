package negocio;

public class Reserva {
    
    private String numeroReserva;
    private int numeroDias;
    private String fechaInicio;
    private String fechaFinal;
    private String estado;
    private String numeroDocumento;
    private String idDescuento;
    
    public Reserva(){
        this.numeroReserva="";
        this.numeroDias=0;
        this.fechaFinal="";
        this.fechaFinal="";
        this.numeroDocumento="";
        this.idDescuento="";
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(String idDescuento) {
        this.idDescuento = idDescuento;
    }
    
    
    
}
