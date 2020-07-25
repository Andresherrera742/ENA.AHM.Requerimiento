/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.dao;

import cl.aiep.requerimiento.modelo.GerenciaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aeherrera
 */
public class GerenciaDAO extends DAOBase {
    
        public List<GerenciaModel> getGerencia() {

        List<GerenciaModel> gerencia = new ArrayList<GerenciaModel>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            pst = conn.prepareStatement(query.toString());
            rs = pst.executeQuery();

            while (rs.next()) {
                GerenciaModel model = toModel( rs );
                gerencia.add(model);
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return gerencia;
    }
     
     public GerenciaModel getGerencia( int id) {

        GerenciaModel gerencia =  new GerenciaModel();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            query.append( " WHERE gerenciaId = ? ");                    
            pst = conn.prepareStatement(query.toString());
            pst.setInt( 1, id );
            rs = pst.executeQuery();

            while (rs.next()) {
                gerencia = toModel( rs );                
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return gerencia;
    }
    
    private StringBuilder getQuerySelect() {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT ");
        query.append("  gerenciaId ");
        query.append(" ,descripcionGerencia");        
        query.append(" FROM gerencia ");

        return query;
    }
    
    private GerenciaModel toModel(ResultSet rs) {
        GerenciaModel model = new GerenciaModel();
        
        try{
            model.setGerenciaId(rs.getInt("gerenciaId"));
            model.setDescripcionGerencia(rs.getString("descripcionGerencia"));            
        }
        catch( SQLException ex ){
            writeErrorConsole( ex );
        }
        
        return model ;
    }
    
}
