package negocio;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Reserva {
    
    private String numeroReserva;
    private int numeroDias;
    private String fechaInicio;
    private String fechaFinal;
    private String estado;
    private String numeroDocumento;
    private String idDescuento;    
    private Date fechaComienzo = null;
    private Date fechaFin = null;
    
    private Calendar c = Calendar.getInstance();
    public String dia = Integer.toString(c.get(Calendar.DATE));
    public String mes = Integer.toString(c.get(Calendar.MONTH)+1);
    public String annio = Integer.toString(c.get(Calendar.YEAR));
    
    public Date fecha = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public Date fechaActual = null;
    
    public Reserva(){
        this.numeroReserva="";
        this.numeroDias=0;
        this.fechaInicio="";
        this.fechaFinal="";
        this.numeroDocumento="";
        this.idDescuento="";
    }                
    
    public boolean ValidarFechas(){     
        
        try{                        
        fechaComienzo= formato.parse(fechaInicio);
        fechaFin = formato.parse(fechaFinal);          
        } catch (ParseException ex){
            ex.printStackTrace();
        }
        if (fechaComienzo.before(fecha) && fechaFin.after(fecha)){
            return true;
        }else{
            return false;
        }                         
    }      
    
    public String randon(){
        String aux;
        int aux1 = (int)(Math.random()*100+1);        
        aux = String.valueOf(aux1);        
        return aux;        
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
