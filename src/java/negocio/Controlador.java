package negocio;

import datos.*;
import java.sql.Connection;
import util.ServiceLocator;

public class Controlador {
    //Se crean los DAO'S para las entidades de la BD 
    private PersonaDAO personaDAO;
    private ReservaDAO reservaDAO;
    private PagoDAO pagoDAO; 
    private CuentaDAO cuentaDAO;
    private HabitacionDAO habitacionDAO;
    private HotelDAO hotelDAO;
    private HuespedDAO huespedDAO;
    private ProductoServicio_CuentaDAO productoServicio_CuentaDAO;
    private ProductoServicioDAO productoServicioDAO;
    private RegistroDAO registroDAO;
    private Reserva_HabitacionDAO reserva_HabitacionDAO;
    private TipoDAO tipoDAO;
    
    //Se instancian los objetos DAO
    public Controlador(){
        personaDAO = new PersonaDAO();
        reservaDAO = new ReservaDAO();
        pagoDAO = new PagoDAO();
        cuentaDAO = new CuentaDAO();
        habitacionDAO = new HabitacionDAO();
        hotelDAO = new HotelDAO();
        huespedDAO = new HuespedDAO();
        productoServicio_CuentaDAO = new ProductoServicio_CuentaDAO();
        productoServicioDAO = new ProductoServicioDAO();
        registroDAO = new RegistroDAO();
        reserva_HabitacionDAO = new Reserva_HabitacionDAO();
        tipoDAO = new TipoDAO();
    }
    
    //GET
    
    public Persona getPersona(){
        return personaDAO.getPersona();
    }
    
    public Reserva getReserva(){
        return reservaDAO.getReserva();
    }
    
    public Pago getPago(){
        return pagoDAO.getPago();
    }
    
    public Cuenta getCuenta(){
        return cuentaDAO.getCuenta();
    }
    
    public Habitacion getHabitacion(){
        return habitacionDAO.getHabitacion();
    }
    
    private Hotel getHotel(){
        return hotelDAO.getHotel();
    }
    
    public Huesped getHuesped(){
        return huespedDAO.getHuesped();
    }
    
    public ProductoServicio_Cuenta getProductoServicio_Cuenta(){
        return productoServicio_CuentaDAO.getProductoServicio_Cuenta();
    }
    
    public ProductoServicio getProductoServicio(){
        return productoServicioDAO.getProductoServicio();
    }
    
    public Registro getRegistro(){
        return registroDAO.getRegistro();
    }
    
    public Reserva_Habitacion getReserva_HabitacionDAO(){
        return reserva_HabitacionDAO.getReserva_Habitacion();
    }
    
    private Tipo getTipoDAO(){
        return tipoDAO.getTipo();
    }
    
    //INSERT
    
    public void InsertarPersona(){
        personaDAO.Insertar();
    }
    
    public void InsertarReserva(){
        reservaDAO.Insertar();  
    }
    
    public void InsertarPago(){
        pagoDAO.Insertar();
    }
    
    public void InsertarCuenta(){
        cuentaDAO.Insertar();
    }
    
    public void InsertarHabitacion(){
        habitacionDAO.Insertar();
    }
    
    public void InsertarHotel(){
        hotelDAO.Insertar();
    }
    
    public void InsertarHuesped(){
        huespedDAO.Insertar();
    }
    
    public void InsertarProductoServicio_Cuenta(){
        productoServicio_CuentaDAO.Insertar();
    }
    
    public void InsertarProductoServicio(){
        productoServicioDAO.Insertar();
    }
    
    public void InsertarRegistro(){
        registroDAO.Insertar();
    }
    
    public void InsertarReserva_Habitacion(){
        reserva_HabitacionDAO.Insertar();
    }
    
    private void InsertarTipo(){
        tipoDAO.Insertar();
    }
    
    //FIND
    
    public void BuscarPersona(){
        personaDAO.Buscar();
    }
    
    public void BuscarReserva(){
        reservaDAO.Buscar();
    }   
    
    public void BuscarPago(){
        pagoDAO.Buscar();
    }
    
    public void BuscarCuenta(){
        cuentaDAO.Buscar();
    }
    
    public void BuscarHabitacion(){
        habitacionDAO.Buscar();
    }
    
    private void BuscarHotel(){
        hotelDAO.Buscar();
    }
    
    public void BuscarHuesped(){
        huespedDAO.Buscar();
    }
    
    public void BuscarProductoServicio_Cuenta(){
        productoServicio_CuentaDAO.Buscar();
    }
    
    public void BuscarProductoServicio(){
        productoServicioDAO.Buscar();
    }
    
    public void BuscarRegistro(){
        registroDAO.Buscar();
    }
    
    public void BuscarReserva_Habitacion(){
        reserva_HabitacionDAO.Buscar();
    }
    
    private void BuscarTipo(){
        tipoDAO.Buscar();
    }
    
    
    //DELETE
    
    public void EliminarPersona(){
        personaDAO.Eliminar();
    } 
    
    public void EliminarReserva(){
        reservaDAO.Eliminar();
    }
    
    public void EliminarPago(){
        pagoDAO.Eliminar();
    } 
    
    public void EliminarCuenta(){
        cuentaDAO.Eliminar();
    } 
    
    public void EliminarHabitacion(){
        habitacionDAO.Eliminar();
    }
    
    private void EliminarHotel(){
        hotelDAO.Eliminar();
    }
    
    public void EliminarHuesped(){
        huespedDAO.Eliminar();
    }
    
    public void EliminarProductoServicio_Cuenta(){
        productoServicio_CuentaDAO.Eliminar();
    }
    
    public void EliminarProductoServicio(){
        productoServicioDAO.Eliminar();
    }
    
    public void EliminarRegistro(){
        registroDAO.Eliminar();
    }
    
    public void EliminarReserva_Habitacion(){
        reserva_HabitacionDAO.Eliminar();
    }
    
    private void EliminarTipo(){
        tipoDAO.Eliminar();
    }
    
    //UPDATE
    
    public void ModificarPersona(){
        personaDAO.Modificar();
    } 
    
    public void ModificarReserva(){
        reservaDAO.Modificar();
    }
    
    public void ModificarPago(){
        pagoDAO.Modificar();
    } 
    
    public void ModificarCuenta(){
        cuentaDAO.Modificar();
    }
    
    public void ModificarHabitacion(){
        habitacionDAO.Modificar();
    }
    
    private void ModificarHotel(){
        hotelDAO.Modificar();
    }
    
    public void ModificarHuesped(){
        huespedDAO.Modificar();
    }
    
    public void ModificarProductoServicio_Cuenta(){
        productoServicio_CuentaDAO.Modificar();
    }
    
    public void ModificarProductoServicio(){
        productoServicioDAO.Modificar();
    }
    
    public void ModificarRegistro(){
        registroDAO.Modificar();
    }
    
    public void ModificarReserva_Habitacion(){
        reserva_HabitacionDAO.Modificar();
    }
    
    private void ModificarTipo(){
        tipoDAO.Modificar();
    }
    
}
