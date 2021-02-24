package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Reserva;
import util.ServiceLocator;

public class ReservaDAO implements CRUD{

    private Reserva reserva;
    
    public ReservaDAO(){
        reserva = new Reserva();
    }
    
    public void setReserva(Reserva r){
        this.reserva=r;
    }
    
    public Reserva getReserva(){
        return this.reserva;
    }
    
    @Override//APROVED
    public void Insertar() {
        try {
            String strSQL = "INSERT INTO reserva (k_numero_reserva,q_numero_dias,f_inicio,f_final,i_estado_reserva,k_numero_documento,k_iddescuento) "
                            + "VALUES(?,?,?,?,?,?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,reserva.getNumeroReserva()); 
            prepStmt.setInt(2,reserva.getNumeroDias()); 
            prepStmt.setDate(3,Date.valueOf(reserva.getFechaInicio())); 
            prepStmt.setDate(4,Date.valueOf(reserva.getFechaFinal())); 
            prepStmt.setString(5,reserva.getEstado()); 
            prepStmt.setString(6,reserva.getNumeroDocumento()); 
            prepStmt.setString(7,reserva.getIdDescuento());
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
            String strSQL = "DELETE FROM reserva WHERE k_numero_reserva=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,reserva.getNumeroReserva()); 
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
            String strSQL = "SELECT * FROM reserva WHERE k_numero_reserva=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,reserva.getNumeroReserva());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                reserva.setNumeroReserva(rs.getString(1));
                reserva.setNumeroDias(rs.getInt(2));
                reserva.setFechaInicio(rs.getString(3));
                reserva.setFechaFinal(rs.getString(4));
                reserva.setEstado(rs.getString(5));
                reserva.setNumeroDocumento(rs.getString(6));
                reserva.setIdDescuento(rs.getString(7));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    @Override//APROVADO
    public void Modificar() {
        try{
            String strSQL = "UPDATE reserva SET q_numero_dias=? ,f_inicio=? ,f_final=? ,i_estado_reserva=? ,k_numero_documento=? ,k_iddescuento=? "
                            + "WHERE k_numero_reserva=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1,reserva.getNumeroDias());
            prepStmt.setDate(2,Date.valueOf(reserva.getFechaInicio()));
            prepStmt.setDate(3,Date.valueOf(reserva.getFechaFinal()));
            prepStmt.setString(4,reserva.getEstado());
            prepStmt.setString(5,reserva.getNumeroDocumento());
            prepStmt.setString(6,reserva.getIdDescuento());
            prepStmt.setString(7,reserva.getNumeroReserva());
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
