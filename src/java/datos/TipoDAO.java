package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Tipo;
import util.ServiceLocator;

public class TipoDAO implements CRUD{
    
    private Tipo tipo;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void Insertar() {
        try {
            String strSQL = "INSERT INTO tipo (k_idtipo, n_descripcion, v_precio) VALUES(?,?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, tipo.getIdTipo()); 
            prepStmt.setString(2, tipo.getDescripcion()); 
            prepStmt.setFloat(3, tipo.getPrecio()); 
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
            String strSQL = "DELETE FROM tipo WHERE k_idtipo=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, tipo.getIdTipo()); 
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
            String strSQL = "SELECT * FROM tipo WHERE k_idtipo=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,tipo.getIdTipo());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                tipo.setIdTipo(rs.getString(1));
                tipo.setDescripcion(rs.getString(2));
                tipo.setPrecio(rs.getFloat(3));
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
            String strSQL = "UPDATE tipo SET n_descripcion=?, v_precio=? WHERE k_idtipo=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,tipo.getDescripcion());
            prepStmt.setFloat(2,tipo.getPrecio());
            prepStmt.setString(3,tipo.getIdTipo());
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
