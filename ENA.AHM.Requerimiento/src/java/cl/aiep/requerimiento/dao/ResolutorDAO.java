/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.dao;

import cl.aiep.requerimiento.modelo.ResolutorModel;
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
public class ResolutorDAO extends DAOBase {

        public List<ResolutorModel> getResolutores(int areaResolutoraId) {

        List<ResolutorModel> resolutor = new ArrayList<ResolutorModel>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            pst = conn.prepareStatement(query.toString());
            pst.setInt( 1, areaResolutoraId );
            rs = pst.executeQuery();

            while (rs.next()) {
                ResolutorModel model = toModel( rs );
                resolutor.add(model);
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return resolutor;
    }
     
     public ResolutorModel getDepartamento( int id) {

        ResolutorModel resolutor =  new ResolutorModel();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            query.append( " WHERE resolutorId = ? ");                    
            pst = conn.prepareStatement(query.toString());
            pst.setInt( 1, id );
            rs = pst.executeQuery();

            while (rs.next()) {
                resolutor = toModel( rs );                
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return resolutor;
    }
    
    private StringBuilder getQuerySelect() {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT ");
        query.append("  resolutorId ");
        query.append(" ,nombreResolutor");  
        query.append(" ,areaResolutoraId");  
        query.append(" FROM resolutor ");

        return query;
    }
    
    private ResolutorModel toModel(ResultSet rs) {
        ResolutorModel model = new ResolutorModel();
        
        try{
            model.setResolutorId(rs.getInt("resolutorId"));
            model.setNombreResolutor(rs.getString("nombreResolutor"));  
            model.setAreaResolutorId(rs.getInt("areaResolutoraId"));
        }
        catch( SQLException ex ){
            writeErrorConsole( ex );
        }
        
        return model ;
    }   
    
}
