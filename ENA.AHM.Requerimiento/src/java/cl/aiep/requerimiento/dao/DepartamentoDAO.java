/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.dao;

import cl.aiep.requerimiento.modelo.DepartamentoModel;
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
public class DepartamentoDAO extends DAOBase{
    
        public List<DepartamentoModel> getDepartamentos(int gerenciaId) {

        List<DepartamentoModel> departamentos = new ArrayList<DepartamentoModel>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            query.append( " WHERE gerenciaId = ? ");                    
            pst = conn.prepareStatement(query.toString());
            pst.setInt( 1, gerenciaId );
            rs = pst.executeQuery();

            while (rs.next()) {
                DepartamentoModel model = toModel( rs );
                departamentos.add(model);
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return departamentos;
    }
     
     public DepartamentoModel getDepartamento( int id) {

        DepartamentoModel departamento =  new DepartamentoModel();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            query.append( " WHERE departamentoId = ? ");                    
            pst = conn.prepareStatement(query.toString());
            pst.setInt( 1, id );
            rs = pst.executeQuery();

            while (rs.next()) {
                departamento = toModel( rs );                
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return departamento;
    }
    
    private StringBuilder getQuerySelect() {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT ");
        query.append("  departamentoId ");
        query.append(" ,descripcionDepartamento");  
        query.append(" ,gerenciaId");  
        query.append(" FROM departamento ");

        return query;
    }
    
    private DepartamentoModel toModel(ResultSet rs) {
        DepartamentoModel model = new DepartamentoModel();
        
        try{
            model.setDepartamentoId(rs.getInt("departamentoId"));
            model.setDescripcionDepartamento(rs.getString("descripcionDepartamento"));  
            model.setGerenciaId(rs.getInt("gerenciaId"));
        }
        catch( SQLException ex ){
            writeErrorConsole( ex );
        }
        
        return model ;
    }    
    
}
