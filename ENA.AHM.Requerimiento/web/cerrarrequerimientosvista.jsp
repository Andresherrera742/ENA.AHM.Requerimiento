<%-- 
    Document   : requerimiento
    Created on : 22-07-2020, 23:17:08
    Author     : Andres
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<title>Cerrar Requerimientos</title>
<html>    
    <%@include file="/part/head.jsp" %>

    <body>
        <div class="container shadow">            
            <%@include file="/part/header.jsp" %>



            <div class="card shadow w-100 mx-auto" >

                <div class="card-header bg-dark text-white">
                    <h4>Listado de Requerimientos</h4>
                </div>	
                <div class="card-body">	

                    <div class="form-group">
                        Gerencia 
                        <select name="cboGerenciaConsulta" class="form-control" required onchange="submit()" >

                            <option value="0">Todos</option>
                            <c:forEach  var="g"  items="${gerencias}" >

                                <option value="${g.gerenciaId}"  
                                        ${g.gerenciaId == requerimiento.getGerencia().getGerenciaId() ? ' selected ' : ' '}>


                                    ${g.descripcionGerencia}
                                </option>

                            </c:forEach>

                        </select>			
                    </div>
                    <div class="form-group">
                        Departamento

                        <select name="cboDepartamentoConsulta" class="form-control" required  >

                            <option value="0">Todos</option>
                            <c:forEach  var="d"  items="${departamentos}" >

                                <option value="${d.departamentoId}"
                                        ${d.departamentoId == requerimiento.getDepartamento().getDepartamentoId() ? ' selected ' : ' '  } >
                                    ${d.descripcionDepartamento}
                                </option>

                            </c:forEach>

                        </select>
                    </div>                           

                    <div class="form-group">
                        Area Resolutora

                        <select name="cboAreaResolutoraConsulta" class="form-control" required >

                            <option value="0">Todos</option>
                            <c:forEach  var="ar"  items="${areaResolutoras}" >

                                <option value="${ar.areaResolutoraId}"
                                        ${ar.areaResolutoraId == requerimiento.getAreaResolutora().getAreaResolutoraId() ? ' selected ' : ' '  } >
                                    ${ar.descripcionArea}
                                </option>

                            </c:forEach>


                        </select>
                    </div>  
                    <td>

                        <a href="requerimientoController.do?action=listar&id=${requerimiento.requerientoId}"
                           class="btn btn-primary" >Buscar</a>                                                                           

                    </td>

                    <div class="card-body">						                            	
                        <table class="table  table-stripper hover">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Gerencia</th>
                                    <th>Departamento</th>
                                    <th>Area Resolutora</th>
                                    <th>Resolutor</th>
                                    <th>Fecha Creacion</th>                                
                                    <th>Requerimiento</th>
                                    <th>Estado</th>
                                    <th>Fecha Cierre</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="requerimiento" items="${requerimientos}">                                
                                    <tr>    

                                        <td>${requerimiento.requerimientoId}</td>
                                        <td>${requerimiento.gerencia.descripcionGerencia}</td>    
                                        <td>${requerimiento.departamento.descripcionDepartamento}</td>    
                                        <td>${requerimiento.areaResolutora.descripcionArea}</td>    
                                        <td>${requerimiento.resolutor.nombreResolutor}</td>                                 
                                        <td>${requerimiento.fechaIngreso}</td>
                                        <td>${requerimiento.requerimiento}</td>
                                        <td>${requerimiento.estado}</td>
                                        <td>${requerimiento.fechaCierre}</td>
                                        <td>
                                            <a href="requerimientoController.do?action=editar&id=${requerimiento.requerimientoId}"
                                               class="btn btn-danger" onclick=" return confirm('¿Seguro que desea Cerrar el Requerimiento?)')">Cerrar</a>                                    
                                        </td> 

                                    </tr>                            
                                </c:forEach>                            

                            </tbody>

                            <div class="${estiloMensaje}" role="alert">
                                ${mensaje}                                
                            </div>

                        </table>  

                    </div>
                </div>     

            </div> 

            <%@include file="/part/footer.jsp" %> 

        </div>
    </body>
</html>
