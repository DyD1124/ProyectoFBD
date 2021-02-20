package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ServiceLocator;
import negocio.ProductoServicio;

public class ProductoServicioDAO implements CRUD {

	private ProductoServicio productoServicio;

	public ProductoServicioDAO() {
		productoServicio = new ProductoServicio();
	}

	public ProductoServicio getProductoServicio() {
		return productoServicio;
	}

	public void setProductoServicio(ProductoServicio productoServicio) {
		this.productoServicio = productoServicio;
	}

	@Override // APROVED
	public void Insertar() {
		try {
			String strSQL = "INSERT INTO ProductoServicio (k_codigo,n_nombre_producto,n_unidad,q_stock,v_precio) "
					+ "VALUES(?,?,?,?,?);";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, productoServicio.getCodigo());
			prepStmt.setString(2, productoServicio.getNombreProducto());
			prepStmt.setString(3, productoServicio.getUnidad());
			prepStmt.setInt(4, productoServicio.getStock());
			prepStmt.setFloat(5, productoServicio.getPrecio());
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
			prepStmt.setString(1, productoServicio.getCodigo());
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
			prepStmt.setString(1, productoServicio.getCodigo());
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				productoServicio.setCodigo(rs.getString(1));
				productoServicio.setNombreProducto(rs.getString(2));
				productoServicio.setUnidad(rs.getString(3));
				productoServicio.setStock(rs.getInt(4));
				productoServicio.setPrecio(rs.getFloat(5));
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
			prepStmt.setString(1, productoServicio.getNombreProducto());
			prepStmt.setString(2, productoServicio.getUnidad());
			prepStmt.setInt(3, productoServicio.getStock());
			prepStmt.setFloat(4, productoServicio.getPrecio());
			prepStmt.setString(5, productoServicio.getCodigo());
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
