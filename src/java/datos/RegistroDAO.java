package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Registro;
import util.ServiceLocator;

public class RegistroDAO implements CRUD{
    
    private Registro registro;

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    @Override
    public void Insertar() {
           try {
            String strSQL = "INSERT INTO registro (k_numero_registro, f_entrada, f_salida, k_numero_reserva, k_numero_documento) VALUES(?,?,?,?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, registro.getIdRegistro()); 
            prepStmt.setDate(2,Date.valueOf(registro.getF_entrada())); 
            prepStmt.setDate(3,Date.valueOf(registro.getF_salida())); 
            prepStmt.setString(4, registro.getNumeroReserva()); 
            prepStmt.setString(5,registro.getDocumentoIdentidad()); 
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
            String strSQL = "DELETE FROM registro WHERE k_numero_registro=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, registro.getIdRegistro()); 
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
            String strSQL = "SELECT * FROM registro WHERE k_numero_registro=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,registro.getIdRegistro());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                registro.setIdRegistro(rs.getString(1));
                registro.setF_entrada(rs.getString(2));
                registro.setF_salida(rs.getString(3));
                registro.setNumeroReserva(rs.getString(4));
                registro.setDocumentoIdentidad(rs.getString(5));
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
            String strSQL = "UPDATE registro SET f_entrada=?, f_salida=?, k_numero_reserva=?, k_numero_documento=? WHERE k_numero_registro=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setDate(1,Date.valueOf(registro.getF_entrada()));
            prepStmt.setDate(2,Date.valueOf(registro.getF_salida()));
            prepStmt.setString(3,registro.getNumeroReserva());
            prepStmt.setString(4,registro.getDocumentoIdentidad());
            prepStmt.setString(5,registro.getIdRegistro());
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
