package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Pago;
import util.ServiceLocator;

public class PagoDAO implements CRUD{

    private Pago pago;
    
    public PagoDAO(){
        pago = new Pago();
    }
    
    public void setPago(Pago p){
        this.pago=p;
    }
    
    public Pago getPago(){
        return this.pago;
    }
    
    @Override//APROVED
    public void Insertar() {
        try {
            String strSQL = "INSERT INTO pago (k_idpago,v_valorpagado,i_formapago,f_pago,k_Idcuenta) VALUES(?,?,?,?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,pago.getIdPago()); 
            prepStmt.setFloat(2,pago.getValorPagado()); 
            prepStmt.setString(3,pago.getFromaPago()); 
            prepStmt.setDate(4,Date.valueOf(pago.getFechaPago())); 
            prepStmt.setString(5,pago.getIdCuenta()); 
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        }  finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override//APROVED
    public void Eliminar() {
        try {
            String strSQL = "DELETE FROM pago WHERE k_idpago=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,pago.getIdPago()); 
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        }  finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override//APROVED
    public void Buscar() {
        try{
            String strSQL = "SELECT * FROM pago WHERE k_idpago=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,pago.getIdPago());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                pago.setIdPago(rs.getString(1));
                pago.setValorPagado(rs.getFloat(2));
                pago.setFromaPago(rs.getString(3));
                pago.setFechaPago(rs.getString(4));
                pago.setIdCuenta(rs.getString(5));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override//APROVED
    public void Modificar() {
        try{
            String strSQL = "UPDATE pago SET v_valorpagado=?, i_formapago=?, f_pago=?, k_idcuenta=? WHERE k_idpago=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setDouble(1,pago.getValorPagado());
            prepStmt.setString(2,pago.getFromaPago());
            prepStmt.setDate(3,Date.valueOf(pago.getFechaPago()));
            prepStmt.setString(4,pago.getIdCuenta());
            prepStmt.setString(5,pago.getIdPago());
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
