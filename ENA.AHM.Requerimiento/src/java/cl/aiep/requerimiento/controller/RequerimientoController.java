/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.requerimiento.controller;

import cl.aiep.requerimiento.dao.AreaResolutoraDAO;
import cl.aiep.requerimiento.dao.DepartamentoDAO;
import cl.aiep.requerimiento.dao.GerenciaDAO;
import cl.aiep.requerimiento.dao.RequerimientoDAO;
import cl.aiep.requerimiento.dao.ResolutorDAO;
import cl.aiep.requerimiento.modelo.AreaResolutoraModel;
import cl.aiep.requerimiento.modelo.DepartamentoModel;
import cl.aiep.requerimiento.modelo.GerenciaModel;
import cl.aiep.requerimiento.modelo.RequerimientoModel;
import cl.aiep.requerimiento.modelo.ResolutorModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aeherrera
 */
public class RequerimientoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String accion = request.getParameter("action");
        String cboGerencia = request.getParameter("cboGerencia");
        String cboDepartamento = request.getParameter("cboDepartamento");
        String cboAreaResolutora = request.getParameter("cboAreaResolutora");
        String cboResolutor = request.getParameter("cboResolutor");
        
        if( accion == null ){
            accion = "";
        }
        
        switch (accion) {

            //case "index":
             //   inicio(request, response);
              //  break;

            case "nuevo":
                nuevoRequerimiento(request, response);
                break;

            case "cerrar":
                cerrarRequerimiento(request, response);
                break;

            case "listar":
               // verificaAccesoPermitido(request, response);
                listarRequerimiento(request, response);
                break;

            case "Grabar":
                grabarRequerimiento(request, response);
                break;

            case "eliminar":
                //eliminaCliente(request, response);
                break;

            case "Acceder":
                //accederSistema(request, response);
                break;

            default:
                if ( cboGerencia != null &&  !"".equals( cboGerencia )) {
                    cambiarRequerimiento(request, response);
                }
                
                if ( cboAreaResolutora != null &&  !"".equals( cboAreaResolutora )) {
                    cambiarRequerimiento(request, response);
                }

        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void nuevoRequerimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequerimientoModel requerimiento = new RequerimientoModel();       
        cargaCboBase( request, response);
        request.setAttribute("requerimiento", requerimiento);
       

        request.getRequestDispatcher("ingresorequerimientovista.jsp").forward(request, response);
    }
    
     private void cargaCboBase(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<GerenciaModel> gerencias = new GerenciaDAO().getGerencia();
        List<AreaResolutoraModel> areasResolutoras = new AreaResolutoraDAO().getAreaResolutora();
        request.setAttribute("gerencias", gerencias);
        request.setAttribute("areaResolutoras", areasResolutoras);
     }
    
    
      private void cerrarRequerimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        RequerimientoModel requerimiento = new RequerimientoDAO().getRequerimiento(id);
        List<GerenciaModel> gerencia = new GerenciaDAO().getGerencia();
        int idGerencia = requerimiento.getGerencia().getGerenciaId();
        List<DepartamentoModel> departamentos = new DepartamentoDAO().getDepartamentos(idGerencia);

        List<AreaResolutoraModel> areaResolutora = new AreaResolutoraDAO().getAreaResolutora();
        int idAreaResolutora = requerimiento.getAreaResolutora().getAreaResolutoraId();
        List<ResolutorModel> resolutores = new ResolutorDAO().getResolutores(idAreaResolutora);
        
        request.setAttribute("requerimiento", requerimiento);
        request.setAttribute("gerencia", gerencia);
        request.setAttribute("gerencia", requerimiento.getGerencia().getGerenciaId());

        request.setAttribute("departamentos", departamentos);
        request.setAttribute("departamento", requerimiento.getDepartamento().getDepartamentoId());
        
        request.setAttribute("areaResolutora", areaResolutora);
        request.setAttribute("areaResolutora", requerimiento.getAreaResolutora().getAreaResolutoraId());

        request.setAttribute("resolutores", resolutores);
        request.setAttribute("resolutores", requerimiento.getResolutor().getResolutorId());

        request.getRequestDispatcher("ingresorequerimientovista.jsp").forward(request, response);

    }

    private void inicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void grabarRequerimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mensaje = "";
        String estiloMensaje = "";
        String identificador = request.getParameter("hidId");
        boolean exito = false;
        int id = 0;

        if (identificador != null) {
            id = Integer.parseInt(identificador);
        }

        RequerimientoModel model = new RequerimientoModel();
        model.setRequerimientoId(id);
        
        int idGerencia = Integer.parseInt(request.getParameter("cboGerencia"));
        GerenciaModel gerencia = new GerenciaModel();
        gerencia.setGerenciaId(idGerencia);
        model.setGerencia(gerencia);

        int idDepartamento = Integer.parseInt(request.getParameter("cboDepartamento"));
        DepartamentoModel departamento = new DepartamentoModel();
        departamento.setDepartamentoId(idDepartamento);
        model.setDepartamento(departamento);
        
        int idAreaResolutora = Integer.parseInt(request.getParameter("cboAreaResolutora"));
        AreaResolutoraModel areaResolutora = new AreaResolutoraModel();
        areaResolutora.setAreaResolutoraId(idAreaResolutora);
        model.setAreaResolutora(areaResolutora);

        int idResolutor = Integer.parseInt(request.getParameter("cboResolutor"));
        ResolutorModel resolutor = new ResolutorModel();
        resolutor.setResolutorId(idResolutor);
        model.setResolutor(resolutor);
        
        model.setRequerimiento(request.getParameter("txtRequerimiento"));
        

        if (model.getRequerimientoId() == 0) {
            RequerimientoDAO dao = new RequerimientoDAO();
            exito = dao.insert(model);

            if (!exito) {
                mensaje = "Error al grabar Requerimiento";
                estiloMensaje = "alert alert-danger text-center";
            } else {
                mensaje = "Requerimiento grabado con exito";
                estiloMensaje = "alert alert-success text-center";
            }
        } else {

            RequerimientoDAO dao = new RequerimientoDAO();
            exito = dao.update(model);

            if (!exito) {
                mensaje = "Error al cerrar Requerimiento";
                estiloMensaje = "alert alert-danger text-center";
            } else {
                mensaje = "Requerimiento cerrado con exito";
                estiloMensaje = "alert alert-success text-center";
            }
        }

        request.setAttribute("mensaje", mensaje);
        request.setAttribute("estiloMensaje", estiloMensaje);
        request.getRequestDispatcher("ingresorequerimientovista.jsp").forward(request, response);

    }

    private void listarRequerimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<RequerimientoModel> entidades = new RequerimientoDAO().getRequerimientos();
        request.setAttribute("requerimientos", entidades);
        request.getRequestDispatcher("requerimientosvista.jsp").forward(request, response);

    }
   
    private void cambiarRequerimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idGerencia = getIDDesdeCombo( request, response,"cboGerencia" );        
        List<DepartamentoModel> departamentos = new DepartamentoDAO().getDepartamentos(idGerencia);
        
        int idAreaResolutora = getIDDesdeCombo( request, response,"cboAreaResolutora" );        
        List<ResolutorModel> resolutores = new ResolutorDAO().getResolutores(idAreaResolutora);

        //Mantenemos los datos del empleado para enviar en el request, los sacamos desde los input de la pagina
        RequerimientoModel requerimiento = new RequerimientoModel();
        int id = Integer.parseInt(request.getParameter("hidId"));
        
        requerimiento.setRequerimientoId(id);                
        
        GerenciaModel gerencia = new GerenciaModel();
        gerencia.setGerenciaId(idGerencia);
        requerimiento.setGerencia(gerencia);

        
        int idDepartamento = getIDDesdeCombo( request, response,"cboDepartamento" );
        DepartamentoModel departamento = new DepartamentoModel();
        departamento.setDepartamentoId(idDepartamento);
        requerimiento.setDepartamento(departamento);
        
        
       
        AreaResolutoraModel areaResolutora = new AreaResolutoraModel();
        areaResolutora.setAreaResolutoraId(idAreaResolutora);
        requerimiento.setAreaResolutora(areaResolutora);
        
        int idResolutor = getIDDesdeCombo( request, response,"cboResolutor" );        
        ResolutorModel resolutor = new ResolutorModel();
        resolutor.setResolutorId(idResolutor);
        requerimiento.setResolutor(resolutor);
        
        requerimiento.setRequerimiento(request.getParameter("txtRequerimiento"));

        request.setAttribute("requerimiento", requerimiento);                
        request.setAttribute("departamentos", departamentos);
        request.setAttribute("resolutores", resolutores);        
        
        cargaCboBase( request, response);

        request.getRequestDispatcher("ingresorequerimientovista.jsp").forward(request, response);
    }
    
    
     private int getIDDesdeCombo(HttpServletRequest request, HttpServletResponse response, String nameCombo)
            throws ServletException, IOException {
        String valor = request.getParameter(nameCombo);
        int id = 0;
        if (valor != null && !"".equals(valor)) {
            id = Integer.parseInt(valor);
        }
        return id;
    }
    
    
}
