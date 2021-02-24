package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Habitacion;
import negocio.Reserva;
import negocio.Reserva_Habitacion;
import negocio.Tipo;
import util.ServiceLocator;

public class Reserva_HabitacionDAO implements CRUD{
    
    private Reserva_Habitacion rh;
    private Habitacion h;
    private Reserva r;
    
   public Reserva_HabitacionDAO(){
       rh = new Reserva_Habitacion();
       h = new Habitacion();
       r = new Reserva();
   }
    
    public Habitacion getH() {
        return h;
    }

    public void setH(Habitacion h) {
        this.h = h;
    }

    public Reserva getR() {
        return r;
    }

    public void setR(Reserva r) {
        this.r = r;
    }

    public Reserva_Habitacion getReserva_Habitacion() {
        return rh;
    }

    public void setReserva_Habitacion(Reserva_Habitacion rh) {
        this.rh = rh;
    }

    @Override
    public void Insertar() {
        try {
            String strSQL = "INSERT INTO reserva_habitacion (k_numero_habitacion, k_numero_reserva) VALUES(?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, rh.getIdHabitacion()); 
            prepStmt.setString(2, rh.getNumeroReserva()); 
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        }  finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override
    public void Eliminar() {
         try {
            String strSQL = "DELETE FROM reserva_habitacion WHERE k_numero_habitacion=? AND k_numero_reserva=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, rh.getIdHabitacion()); 
            prepStmt.setString(2, rh.getNumeroReserva());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        }  finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override
    public void Buscar() {
        try{
            String strSQL = "SELECT * FROM reserva_habitacion WHERE k_numero_habitacion=? AND k_numero_reserva=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, rh.getIdHabitacion()); 
            prepStmt.setString(2, rh.getNumeroReserva());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                rh.setIdHabitacion(rs.getString(1));
                rh.setNumeroReserva(rs.getString(2));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override
    public void Modificar() {
      
    }
    
    public ResultSet Habitaciones_diponibles(){
        ResultSet rs=null;
        try{
            String strSQL = 
                "SELECT distinct h.k_numero_habitacion ,h.q_numero_camas, t.n_descripcion, t.v_precio\n" +
                    "FROM habitacion h, reserva r, reserva_habitacion rh, tipo t \n" +
                    "WHERE (h.k_numero_habitacion = rh.k_numero_habitacion and r.k_numero_reserva = rh.k_numero_reserva\n" +
                    "and r.f_inicio not between ? and ?\n" +
                    "and r.f_final not between ? and ?) or (h.k_numero_habitacion != rh.k_numero_habitacion);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setDate(1, Date.valueOf(r.getFechaInicio())); 
            prepStmt.setDate(2, Date.valueOf(r.getFechaFinal())); 
            prepStmt.setDate(3, Date.valueOf(r.getFechaInicio())); 
            prepStmt.setDate(4, Date.valueOf(r.getFechaFinal())); 
            rs = prepStmt.executeQuery();
            
          
        }
        catch(SQLException e){
            ServiceLocator.getInstance().rollback();
            System.out.println(e);
        } finally {
           
            ServiceLocator.getInstance().liberarConexion();
        }
        return rs;

        
    }
    
}
