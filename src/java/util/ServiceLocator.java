package util;

import java.sql.*;

public class ServiceLocator {
    
    private static ServiceLocator instance=null;
    private Connection conexion=null;
    private boolean conexionLibre=true;
    
    public static ServiceLocator getInstance(){
        if (instance == null) {
            try {
                instance = new ServiceLocator();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("arriba");
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    private ServiceLocator() throws Exception{
        Class.forName("org.postgresql.Driver").newInstance();
        conexion=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProyectoFinal","postgres","macanuda1205");
        conexion.setAutoCommit(false);        
    }
    
    public synchronized Connection tomarConexion() {
        while (!conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = false;
        notify();
        return conexion;
    }
    
    public synchronized void liberarConexion() {
        while (conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = true;
        notify();
    }
    
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void commit() {
        try {
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
