/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.dao;

import cl.aiep.requerimiento.modelo.AreaResolutoraModel;
import cl.aiep.requerimiento.modelo.DepartamentoModel;
import cl.aiep.requerimiento.modelo.GerenciaModel;
import cl.aiep.requerimiento.modelo.RequerimientoModel;
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
public class RequerimientoDAO extends DAOBase {

    public boolean insert(RequerimientoModel model) {
        PreparedStatement pst = null;
        Connection conn = null;
        boolean status = false;

        try {
            conn = getConnection();
            pst = conn.prepareStatement(getQueryInsert().toString());
            pst.setInt(1, model.getGerencia().getGerenciaId());
            pst.setInt(2, model.getDepartamento().getDepartamentoId());
            pst.setInt(3, model.getAreaResolutora().getAreaResolutoraId());
            pst.setInt(4, model.getResolutor().getResolutorId());
            pst.setString(6, model.getRequerimiento());
            pst.setString(7, model.getEstado());

            int afectados = pst.executeUpdate();
            status = (afectados > 0);

        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst);
        }

        return status;
    }

    private StringBuilder getQueryInsert() {

        StringBuilder query = new StringBuilder();

        query.append(" INSERT INTO requerimiento ");
        query.append(" ( ");
        query.append("   gerenciaId");
        query.append("  ,departamentoId ");
        query.append("  ,areaResolutoraId ");
        query.append("  ,resolutorId");
        query.append("  ,fechaIngreso");
        query.append("  ,requerimiento");
        query.append("  ,estado");
        query.append(" ) ");
        query.append(" VALUES ");
        query.append(" ( ");
        query.append("   ?");
        query.append("  ,?");
        query.append("  ,?");
        query.append("  ,?");
        query.append("  ,sysdate()");
        query.append("  ,?");
        query.append("  ,Abierto");
        query.append(" ) ");

        return query;
    }

    public boolean update(int id) {
        PreparedStatement pst = null;
        Connection conn = null;
        boolean status = false;

        try {
            conn = getConnection();
            pst = conn.prepareStatement(getQueryUpdate().toString());
            pst.setInt(1, id);
          
            int afectados = pst.executeUpdate();
            status = (afectados > 0);

        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst);
        }

        return status;
        
    }

    private StringBuilder getQueryUpdate() {

        StringBuilder query = new StringBuilder();

        query.append(" UPDATE requerimiento ");
        query.append(" SET ");
        query.append("  ,estado = 'Cerrado'");
        query.append("  ,fechaCierre = sysdate()");
        query.append(" WHERE ");
        query.append("    requerimientoId = ? ");

        return query;
    }

    public List<RequerimientoModel> getRequerimientos(int gerenciaId, int departamentoId, int areaResolutoraId) {

        List<RequerimientoModel> requerimientos = new ArrayList<RequerimientoModel>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
       

        try {
            
            conn = getConnection();
            StringBuilder query = getQuerySelect();

            if (gerenciaId > 0) {
                query.append("AND re.gerenciaId = ?");
            }

            if (departamentoId > 0) {
                query.append("AND re.departamentoId = ?");
            }

            if (areaResolutoraId > 0) {
                query.append("AND re.areaResolutoraId = ?");
            }

            
            pst = conn.prepareStatement(query.toString());
            int n = 0;
           
            if (gerenciaId > 0) {
                n ++;
                pst.setInt(n, gerenciaId);
            }

            if (departamentoId > 0) {
                n ++;
                pst.setInt(n, departamentoId);
            }

            if (areaResolutoraId > 0) {
                n ++;
                pst.setInt(n, areaResolutoraId);
            }

            rs = pst.executeQuery();

            while (rs.next()) {
                RequerimientoModel model = toModel(rs);
                requerimientos.add(model);
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return requerimientos;
    }

    public RequerimientoModel getRequerimiento(int id) {

        RequerimientoModel requerimiento = new RequerimientoModel();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            StringBuilder query = getQuerySelect();
            query.append(" WHERE requerimientoId = ? ");
            pst = conn.prepareStatement(query.toString());
            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                requerimiento = toModel(rs);
            }
        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst, rs);
        }
        return requerimiento;
    }

    private RequerimientoModel toModel(ResultSet rs) {
        RequerimientoModel requerimiento = new RequerimientoModel();
        GerenciaModel gerencia = new GerenciaModel();
        DepartamentoModel departamento = new DepartamentoModel();
        AreaResolutoraModel areaResolutora = new AreaResolutoraModel();
        ResolutorModel resolutor = new ResolutorModel();

        try {

            requerimiento.setRequerimientoId(rs.getInt("requerimientoId"));

            gerencia.setGerenciaId(rs.getInt("gerenciaId"));
            gerencia.setDescripcionGerencia(rs.getString("g.descripcionGerencia"));
            requerimiento.setGerencia(gerencia);

            departamento.setDepartamentoId(rs.getInt("departamentoId"));
            departamento.setDescripcionDepartamento(rs.getString("d.descripcionDepartamento"));
            requerimiento.setDepartamento(departamento);

            areaResolutora.setAreaResolutoraId(rs.getInt("areaResolutoraId"));
            areaResolutora.setDescripcionArea(rs.getString("ar.descripcionArea"));
            requerimiento.setAreaResolutora(areaResolutora);

            resolutor.setResolutorId(rs.getInt("resolutorId"));
            resolutor.setNombreResolutor(rs.getString("r.nombreResolutor"));
            requerimiento.setResolutor(resolutor);

            requerimiento.setRequerimiento(rs.getString("requerimiento"));
            requerimiento.setEstado(rs.getString("estado"));

        } catch (SQLException ex) {
            writeErrorConsole(ex);
        }

        return requerimiento;
    }

    private StringBuilder getQuerySelect() {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT ");
        query.append("  re.requerimientoId ");
        query.append(" ,re.gerenciaId");
        query.append(" ,g.descripcionGerencia ");
        query.append(" ,re.departamentoId ");
        query.append(" ,d.descripcionDepartamento ");
        query.append(" ,re.areaResolutoraId ");
        query.append(" ,ar.descripcionArea ");
        query.append(" ,re.resolutorId ");
        query.append(" ,re.fechaIngreso ");
        query.append(" ,r.nombreResolutor  ");
        query.append(" ,re.requerimiento ");
        query.append(" ,re.estado ");
        query.append(" ,re.fechaCierre ");
        query.append(" FROM requerimiento re ");
        query.append("  INNER JOIN gerencia g ON g.gerenciaId = re.gerenciaId");
        query.append("  INNER JOIN departamento	d  ON d.departamentoId = re.departamentoId");
        query.append("  INNER JOIN areaResolutora ar  ON ar.areaResolutoraId = re.areaResolutoraId");
        query.append("  INNER JOIN resolutor r  ON r.resolutorId = re.resolutorId");

        query.append(" WHERE 1 = 1 ");

        return query;
    }

    public boolean delRequerimiento(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean status = false;

        try {
            conn = getConnection();
            StringBuilder query = getQueryDelete();
            query.append(" WHERE requerimientoId = ? ");
            pst = conn.prepareStatement(query.toString());
            pst.setInt(1, id);

            int afectados = pst.executeUpdate();
            status = (afectados > 0);

        } catch (SQLException e) {
            writeErrorConsole(e);
        } finally {
            closeConnection(conn, pst);
        }

        return status;
    }

    private StringBuilder getQueryDelete() {
        StringBuilder query = new StringBuilder();

        query.append(" DELETE ");
        query.append(" FROM requerimiento ");

        return query;
    }

}
