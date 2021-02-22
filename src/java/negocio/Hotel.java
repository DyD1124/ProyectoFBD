package negocio;

public class Hotel {
    
    private String idDescuento;
    private int dias;
    private int descuento;
    private String causante;

    public Hotel() {
    }

    public String getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(String idDescuento) {
        this.idDescuento = idDescuento;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getCausante() {
        return causante;
    }

    public void setCausante(String causante) {
        this.causante = causante;
    }
    
}
