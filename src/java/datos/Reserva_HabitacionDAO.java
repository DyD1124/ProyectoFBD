/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Reserva_Habitacion;
import util.ServiceLocator;

/**
 *
 * @author mile1
 */
public class Reserva_HabitacionDAO implements CRUD{
    
    private Reserva_Habitacion rh;

    public Reserva_Habitacion getRh() {
        return rh;
    }

    public void setRh(Reserva_Habitacion rh) {
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
    
    
    
}
