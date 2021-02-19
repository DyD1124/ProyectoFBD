package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ServiceLocator;
import negocio.ProductoServicios;

public class ProductoServicioDAO implements CRUD {

	private ProductoServicios productoServicios;

	public ProductoServicioDAO() {
		productoServicios = new ProductoServicios();
	}

	public ProductoServicios getProductoServicios() {
		return productoServicios;
	}

	public void setProductoServicios(ProductoServicios productoServicios) {
		this.productoServicios = productoServicios;
	}

	@Override // APROVED
	public void Insertar() {
		try {
			String strSQL = "INSERT INTO ProductoServicio (k_codigo,n_nombre_producto,n_unidad,q_stock,v_precio) "
					+ "VALUES(?,?,?,?,?);";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, productoServicios.getCodigo());
			prepStmt.setString(2, productoServicios.getNombreProducto());
			prepStmt.setString(3, productoServicios.getUnidad());
			prepStmt.setInt(4, productoServicios.getStock());
			prepStmt.setFloat(5, productoServicios.getPrecio());
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
			String strSQL = "DELETE FROM ProductoServicio WHERE k_codigo=?;";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, productoServicios.getCodigo());
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
			String strSQL = "SELECT * FROM ProductoServicio WHERE k_codigo=?;";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, productoServicios.getCodigo());
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				productoServicios.setCodigo(rs.getString(1));
				productoServicios.setNombreProducto(rs.getString(2));
				productoServicios.setUnidad(rs.getString(3));
				productoServicios.setStock(rs.getInt(4));
				productoServicios.setPrecio(rs.getFloat(5));
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
			String strSQL = "UPDATE ProductoServicio SET n_nombre_producto=?, n_unidad=?, q_stock=?, v_precio=?"
					+ " WHERE k_codigo=?;";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, productoServicios.getNombreProducto());
			prepStmt.setString(2, productoServicios.getUnidad());
			prepStmt.setInt(3, productoServicios.getStock());
			prepStmt.setFloat(4, productoServicios.getPrecio());
			prepStmt.setString(5, productoServicios.getCodigo());
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
