package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Habitacion;
import util.ServiceLocator;

public class HabitacionDAO implements CRUD{
    
    private Habitacion Habitacion;
    
    public HabitacionDAO(){
        Habitacion = new Habitacion();
    }

    public Habitacion getHabitacion() {
        return Habitacion;
    }

    public void setHabitacion(Habitacion Habitacion) {
        this.Habitacion = Habitacion;
    }

    @Override
    public void Insertar() {
         try {
            String strSQL = "INSERT INTO habitacion (k_numero_habitacion, q_numero_camas, k_idtipo) VALUES(?,?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, Habitacion.getIdHabitacion());
            prepStmt.setInt(2, Habitacion.getNumCamas());
            prepStmt.setString(3, Habitacion.getIdTipo());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override
    public void Eliminar() {
          try {
            String strSQL = "DELETE FROM habitacion WHERE k_numero_habitacion=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, Habitacion.getIdHabitacion());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override
    public void Buscar() {
           try {
            String strSQL = "SELECT * FROM habitacion WHERE k_numero_habitacion=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, Habitacion.getIdHabitacion());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Habitacion.setIdHabitacion(rs.getString(1));
                Habitacion.setNumCamas(rs.getInt(2));
                Habitacion.setIdTipo(rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override
    public void Modificar() {
         try {
            String strSQL = "UPDATE habitacion SET q_numero_camas=?, k_idtipo=? WHERE k_numero_habitacion=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, Habitacion.getNumCamas());
            prepStmt.setString(2, Habitacion.getIdTipo());
            prepStmt.setString(3, Habitacion.getIdHabitacion());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    
    
}
