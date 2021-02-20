package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Huesped;
import util.ServiceLocator;

public class HuespedDAO implements CRUD {
    
    private Huesped huesped;

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    @Override
    public void Insertar() {
          try {
            String strSQL = "INSERT INTO huesped (k_numero_documento, n_idhuesped) VALUES(?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, huesped.getDocumentoIdentidad()); 
            prepStmt.setString(2, huesped.getIdHuesped()); 
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
            String strSQL = "DELETE FROM huesped WHERE k_numero_documento=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, huesped.getDocumentoIdentidad()); 
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
            String strSQL = "SELECT * FROM huesped WHERE k_numero_documento=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,huesped.getDocumentoIdentidad());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                huesped.setDocumentoIdentidad(rs.getString(1));
                huesped.setIdHuesped(rs.getString(2));
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
        try{
            String strSQL = "UPDATE huesped SET n_idhuesped=? WHERE k_numero_documento=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,huesped.getIdHuesped());
            prepStmt.setString(2,huesped.getDocumentoIdentidad());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        }
        catch(SQLException e){
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    
    
}
