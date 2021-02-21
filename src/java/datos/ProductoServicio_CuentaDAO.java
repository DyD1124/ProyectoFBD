package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ServiceLocator;
import java.sql.Date;
import negocio.ProductoServicio_Cuenta;

public class ProductoServicio_CuentaDAO implements CRUD {

	private ProductoServicio_Cuenta productoServicio_Cuenta;

	public ProductoServicio_CuentaDAO() {
		productoServicio_Cuenta = new ProductoServicio_Cuenta();
	}

	public ProductoServicio_Cuenta getProductoServicio_Cuenta() {
		return productoServicio_Cuenta;
	}

	public void setProductoServicio_Cuenta(ProductoServicio_Cuenta productoServicio_Cuenta) {
		this.productoServicio_Cuenta = productoServicio_Cuenta;
	}

	@Override // APROVED
	public void Insertar() {
		try {
			String strSQL = "INSERT INTO ProductoServicio_Cuenta (k_codigo,k_idcuenta,q_cantidad,f_pedido) "
					+ "VALUES(?,?,?,?);";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(2, productoServicio_Cuenta.getIdCuenta());
			prepStmt.setInt(3, productoServicio_Cuenta.getCantidad());
			prepStmt.setDate(4, Date.valueOf(productoServicio_Cuenta.getFechaPedido()));
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
			String strSQL = "DELETE FROM ProductoServicio_Cuenta WHERE k_codigo=? AND k_idcuenta=?;";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, productoServicio_Cuenta.getCodigo());
			prepStmt.setString(2, productoServicio_Cuenta.getIdCuenta());
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
			String strSQL = "SELECT * FROM ProductoServicio_Cuenta WHERE k_codigo=? AND k_idcuenta=?;";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, productoServicio_Cuenta.getCodigo());
			prepStmt.setString(2, productoServicio_Cuenta.getIdCuenta());
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				productoServicio_Cuenta.setCodigo(rs.getString(1));
				productoServicio_Cuenta.setIdCuenta(rs.getString(2));
				productoServicio_Cuenta.setCantidad(rs.getInt(3));
				productoServicio_Cuenta.setFechaPedido(rs.getString(4));
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
			String strSQL = "UPDATE ProductoServicio_Cuenta SET q_cantidad=?, f_pedido=? WHERE k_codigo=? AND k_idcuenta=?;";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setInt(1, productoServicio_Cuenta.getCantidad());
			prepStmt.setDate(2, Date.valueOf(productoServicio_Cuenta.getFechaPedido()));
			prepStmt.setString(3, productoServicio_Cuenta.getCodigo());
			prepStmt.setString(4, productoServicio_Cuenta.getIdCuenta());
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
