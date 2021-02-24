package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Cuenta;
import util.ServiceLocator;

public class CuentaDAO implements CRUD {

    private Cuenta cuenta;

    public CuentaDAO() {
        cuenta = new Cuenta();
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override // APROVED
    public void Insertar() {
        try {
            String strSQL = "INSERT INTO Cuenta (k_idcuenta,v_valor,i_estado_cuenta,k_numero_reserva) VALUES(?,?,?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, cuenta.getIdCuenta());
            prepStmt.setFloat(2, cuenta.getValor());
            prepStmt.setString(3, cuenta.getEstadoCuenta());
            prepStmt.setString(4, cuenta.getNumeroReserva());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override // APROVED
    public void Eliminar() {
        try {
            String strSQL = "DELETE FROM Cuenta WHERE k_idcuenta=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, cuenta.getIdCuenta());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override // APROVED
    public void Buscar() {
        try {
            String strSQL = "SELECT * FROM Cuenta WHERE k_idcuenta=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, cuenta.getIdCuenta());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                cuenta.setIdCuenta(rs.getString(1));
                cuenta.setValor(rs.getFloat(2));
                cuenta.setEstadoCuenta(rs.getString(3));
                cuenta.setNumeroReserva(rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    @Override // APROVED
    public void Modificar() {
        try {
            String strSQL = "UPDATE Cuenta SET v_valor=?, i_estado_cuenta=?, k_numero_reserva=? WHERE k_idcuenta=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setFloat(1, cuenta.getValor());
            prepStmt.setString(2, cuenta.getEstadoCuenta());
            prepStmt.setString(3, cuenta.getNumeroReserva());
            prepStmt.setString(4, cuenta.getIdCuenta());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void BuscarPorReserva() {
        try {
            String strSQL = "SELECT * FROM Cuenta WHERE k_numero_reserva=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, cuenta.getNumeroReserva());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                cuenta.setIdCuenta(rs.getString(1));
                cuenta.setValor(rs.getFloat(2));
                cuenta.setEstadoCuenta(rs.getString(3));
                cuenta.setNumeroReserva(rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
}
