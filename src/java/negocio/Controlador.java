package negocio;

import datos.*;

public class Controlador {
    
    private PagoDAO pagoDAO = new PagoDAO();  
    private PersonaDAO personaDAO = new PersonaDAO();
    private ReservaDAO reservaDAO = new ReservaDAO();

    public Controlador(){
        pagoDAO = new PagoDAO();
        personaDAO = new PersonaDAO();
        reservaDAO = new ReservaDAO();
    }

    public Persona getPersona(){
        return personaDAO.getPersona();
    }
    
    public Reserva getReserva(){
        return reservaDAO.getReserva();
    }
    
    public Pago getPago(){
        return pagoDAO.getPago();
    }
    
    public void InsertarPersona(){
        personaDAO.Insertar();
    }
    
    public void InsertarReserva(){
        reservaDAO.Insertar();  
    }
    
    public void InsertarPago(){
        pagoDAO.Insertar();
    }
    
    public void BuscarPersona(){
        personaDAO.Buscar();
    }
    
    public void BuscarReserva(){
        reservaDAO.Buscar();
    }
    
    public void BuscarPago(){
        pagoDAO.Buscar();
    }
    
    public void EliminarPersona(){
        personaDAO.Eliminar();
    } 
    
    public void EliminarReserva(){
        reservaDAO.Eliminar();
    }
    
    public void EliminarPago(){
        pagoDAO.Eliminar();
    } 
    
    public void ModificarPersona(){
        personaDAO.Modificar();
    } 
    
    public void ModificarReserva(){
        reservaDAO.Modificar();
    }
    
    public void ModificarPago(){
        pagoDAO.Modificar();
    } 
    
    
    public static void main(String[] args) {
        Controlador c = new Controlador();
        Reserva r = c.getReserva();
        r.setNumeroReserva("100000000");
        r.setNumeroDias(7);
        r.setFechaInicio("2021-01-19");
        r.setFechaFinal("2021-01-26");
        r.setEstado("P");
        r.setNumeroDocumento("0000000000");
        r.setIdDescuento("01");
        c.ModificarReserva();
    }
    
}
