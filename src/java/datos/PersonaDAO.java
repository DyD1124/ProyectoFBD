package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import negocio.Persona;
import util.ServiceLocator;

public class PersonaDAO implements CRUD{

    private Persona persona;
    
    public PersonaDAO(){
        persona = new Persona();
    }
    
    public void setPersona(Persona p){
        this.persona=p;
    }
    
    public Persona getPersona(){
        return this.persona;
    }
    
    @Override//APROVED
    public void Insertar() {
        try {
            String strSQL = "INSERT INTO persona (k_num_doc,n_primnom,n_segnom,n_primapell,n_segapell,"
                            + "n_direccalle,n_direcavenida,n_direcciudad,n_direcadic,i_tipodoc,f_nacimiento,n_telefono) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,persona.getDocumentoIdentidad()); 
            prepStmt.setString(2, persona.getPrimerNombre()); 
            prepStmt.setString(3, persona.getSegundoNombre()); 
            prepStmt.setString(4, persona.getPrimerApellido()); 
            prepStmt.setString(5, persona.getSegundoApellido()); 
            prepStmt.setString(6, persona.getCalle()); 
            prepStmt.setString(7, persona.getAvenida());
            prepStmt.setString(8, persona.getCiudad());
            prepStmt.setString(9, persona.getAdicional());
            prepStmt.setString(10, persona.getTipoDocumento());
            prepStmt.setDate(11, Date.valueOf(persona.getFechaNacimiento()));
            prepStmt.setString(12, persona.getTelefono());
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
            String strSQL = "DELETE FROM persona WHERE k_num_doc=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,persona.getDocumentoIdentidad()); 
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
            String strSQL = "SELECT * FROM persona WHERE k_num_doc=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
             prepStmt.setString(1,persona.getDocumentoIdentidad());
             ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                persona.setDocumentoIdentidad(rs.getString(1));
                persona.setPrimerNombre(rs.getString(2));
                persona.setSegundoNombre(rs.getString(3));
                persona.setPrimerApellido(rs.getString(4));
                persona.setSegundoApellido(rs.getString(5));
                persona.setCalle(rs.getString(6));
                persona.setAvenida(rs.getString(7));
                persona.setCiudad(rs.getString(8));
                persona.setAdicional(rs.getString(9));
                persona.setTipoDocumento(rs.getString(10));
                persona.setFechaNacimiento(rs.getString(11));
                persona.setTelefono(rs.getString(12));
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
            String strSQL = "UPDATE persona SET n_primnom=? ,n_segnom=? ,n_primapell=? ,n_segapell=? "
                            + ",n_direccalle=? ,n_direcavenida=? ,n_direcciudad=? ,n_direcadic=? ,i_tipodoc=? ,f_nacimiento=? ,n_telefono=? "
                            + "WHERE k_num_doc=?;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1,persona.getPrimerNombre());
            prepStmt.setString(2,persona.getSegundoNombre());
            prepStmt.setString(3,persona.getPrimerApellido());
            prepStmt.setString(4,persona.getSegundoApellido());
            prepStmt.setString(5,persona.getCalle());
            prepStmt.setString(6,persona.getAvenida());
            prepStmt.setString(7,persona.getCiudad());
            prepStmt.setString(8,persona.getAdicional());
            prepStmt.setString(9,persona.getTipoDocumento());
            prepStmt.setDate(10,Date.valueOf(persona.getFechaNacimiento()));
            prepStmt.setString(11,persona.getTelefono());
            prepStmt.setString(12,persona.getDocumentoIdentidad());
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
