/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author mile1
 */
public class Registro {
    private String idRegistro;
    private String f_entrada;
    private String f_salida;
    private String numeroReserva;
    private String documentoIdentidad;

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getF_entrada() {
        return f_entrada;
    }

    public void setF_entrada(String f_entrada) {
        this.f_entrada = f_entrada;
    }

    public String getF_salida() {
        return f_salida;
    }

    public void setF_salida(String f_salida) {
        this.f_salida = f_salida;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
    
    

}
