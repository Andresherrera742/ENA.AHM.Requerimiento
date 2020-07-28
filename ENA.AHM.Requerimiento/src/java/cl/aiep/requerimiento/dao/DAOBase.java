/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aeherrera
 */
public class DAOBase {
    
    private Connection conn = null;
    private final String dbName = "jdbc:mysql://localhost:3306/requerimientos?serverTimezone=UTC";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "aherrera";        
    private final String pass = "Nicolas742";
    
        protected Connection getConnection(){
        try{            
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(dbName, user, pass);
        }
        catch( SQLException e){
            writeErrorConsole(e);
        }
        catch( Exception e){
            writeErrorConsole(e);
        }
    
        return conn;
    }
    
    protected void closeConnection( Connection conn, PreparedStatement pst, ResultSet rs){
    
        if( conn != null){
            try{
                conn.close();
            }
            catch( SQLException e){
                writeErrorConsole(e);    
            }
        }
        
        if( pst != null){
            try{
                pst.close();
            }
            catch( SQLException e){
                writeErrorConsole(e);
            }
        }
        
        if( rs != null){
            try{
                rs.close();
            }
            catch( SQLException e){
                writeErrorConsole(e);                
            }
        }
    }
    
    protected void closeConnection( Connection conn, PreparedStatement pst){        
        closeConnection( conn, pst, null);    
    }
    
    
    protected void writeErrorConsole( SQLException e){
        System.out.println( e );
        String mensaje = e.getMessage();
        int codigo = e.getErrorCode();
        String estado = e.getSQLState();
        System.out.println( "Inicio Error SQL " );
        System.out.println( mensaje + " " + codigo + " " +  estado ); 
        System.out.println( "Fin Error SQL " );
    }
    
    protected void writeErrorConsole( Exception e){
        System.out.println( e );
        String mensaje = e.getMessage();        
        System.out.println( "Inicio Error generico " );
        System.out.println( mensaje ); 
        System.out.println( "Fin Error generico " );
    }
    
}
