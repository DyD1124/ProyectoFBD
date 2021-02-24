package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Hotel;
import util.ServiceLocator;

public class HotelDAO implements CRUD{
    
    private Hotel hotel;
    
    public HotelDAO(){
        this.hotel = new Hotel();
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    @Override
    public void Insertar() {
        try {
            String strSQL = "INSERT INTO hotel (k_iddescuento,q_numero_dias_minimo,t_descuento,n_causante) VALUES(?,?,?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, hotel.getIdDescuento());
            prepStmt.setInt(2, hotel.getDias());
            prepStmt.setInt(3, hotel.getDescuento());
            prepStmt.setString(4, hotel.getCausante());
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
            String strSQL = "DELETE FROM hotel WHERE k_iddescuento=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, hotel.getIdDescuento());
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
            String strSQL = "SELECT * FROM hotel WHERE q_numero_dias_minimo=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, hotel.getDias());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                hotel.setIdDescuento(rs.getString(1));
                hotel.setDias(rs.getInt(2));
                hotel.setDescuento(rs.getInt(3));
                hotel.setCausante(rs.getString(4));
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
            String strSQL = "UPDATE hotel SET q_numero_dias_minimo=?, t_descuento=?, n_causante=? WHERE k_iddescuento=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, hotel.getDias());
            prepStmt.setInt(2, hotel.getDescuento());
            prepStmt.setString(3, hotel.getCausante());
            prepStmt.setString(4, hotel.getIdDescuento());
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
