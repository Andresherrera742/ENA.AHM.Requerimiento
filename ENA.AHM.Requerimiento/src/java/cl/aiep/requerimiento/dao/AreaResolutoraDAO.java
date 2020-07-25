/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.dao;

import cl.aiep.requerimiento.modelo.AreaResolutoraModel;
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
public class AreaResolutoraDAO extends DAOBase {

        public List<AreaResolutoraModel> getAreaResolutora() {

        List<AreaResolutoraModel> areaResolutora = new ArrayList<AreaResolutoraModel>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            pst = conn.prepareStatement(query.toString());
            rs = pst.executeQuery();

            while (rs.next()) {
                AreaResolutoraModel model = toModel( rs );
                areaResolutora.add(model);
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return areaResolutora;
    }
     
     public AreaResolutoraModel getAreaResolutora( int id) {

        AreaResolutoraModel areaResolutora =  new AreaResolutoraModel();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            query.append( " WHERE areaResolutoraId = ? ");                    
            pst = conn.prepareStatement(query.toString());
            pst.setInt( 1, id );
            rs = pst.executeQuery();

            while (rs.next()) {
                areaResolutora = toModel( rs );                
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return areaResolutora;
    }
    
    private StringBuilder getQuerySelect() {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT ");
        query.append("  areaResolutoraId ");
        query.append(" ,descripcionArea");        
        query.append(" FROM areaResolutora ");

        return query;
    }
    
    private AreaResolutoraModel toModel(ResultSet rs) {
        AreaResolutoraModel model = new AreaResolutoraModel();
        
        try{
            model.setAreaResolutoraId(rs.getInt("areaResolutoraId"));
            model.setDescripcionArea(rs.getString("descripcionArea"));            
        }
        catch( SQLException ex ){
            writeErrorConsole( ex );
        }
        
        return model ;
    }    
}
