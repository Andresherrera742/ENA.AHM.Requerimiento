/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.dao;

import cl.aiep.requerimiento.modelo.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aeherrera
 */
public class UsuarioDAO extends DAOBase {

    public UsuarioModel getUsuario( String usuario  ) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        UsuarioModel model = new UsuarioModel();
        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            query.append(" WHERE usuario = ? ");
            
            pst = conn.prepareStatement(query.toString());
            pst.setString(1, usuario);
            
            rs = pst.executeQuery();

            while (rs.next()) {
                model = toModel( rs );
                
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return model;
    }
     
    private StringBuilder getQuerySelect() {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT ");
        query.append("  usuarioId ");
        query.append(" ,usuario ");
        query.append(" ,contraseña ");        
        query.append(" FROM usuario ");

        return query;
    }
    
    private UsuarioModel toModel(ResultSet rs) {
        UsuarioModel model = new UsuarioModel();
        
        try{
            model.setUsuarioId(rs.getInt("usuarioId"));
            model.setUsuario(rs.getString("usuario"));
            model.setContraseña( rs.getString("contraseña"));            
        }
        catch( SQLException ex ){
            writeErrorConsole( ex );
        }
        
        return model ;
    }    
    
}
