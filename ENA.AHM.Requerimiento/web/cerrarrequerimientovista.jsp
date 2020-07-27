<%-- 
    Document   : cerrarrequerimientovista
    Created on : 27-07-2020, 1:36:16
    Author     : aeherrera
--%>

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
                    <h4>Cerrar Requerimientos</h4>
                </div>	
                <div class="card-body">	

                    <div class="form-group">
                        Gerencia 
                        <select name="cboGerenciaConsulta" class="form-control" required onchange="submit()" >

                            <option value="0">Todos</option>
                            <c:forEach  var="g"  items="${gerencias}" >

                                <option value="${gerenciaId}"  
                                        ${g.gerenciaId == requerimientos.getGerencia().getGerenciaId() ? ' selected ' : ' '}>


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

                                <option value="${departamentoId}"
                                        ${d.departamentoId == requerimientos.getDepartamento().getDepartamentoId() ? ' selected ' : ' '  } >
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

                                <option value="${areaResolutoraId}"
                                        ${ar.areaResolutoraId == requerimientos.getAreaResolutora().getAreaResolutoraId() ? ' selected ' : ' '  } >
                                    ${ar.descripcionArea}
                                </option>

                            </c:forEach>


                        </select>
                    </div>  
                    <td>

                        <a href="requerimientoController.do?action=listar&id=${requerimientos.requerientoId}"
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
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="requerimientos" items="${requerimientos}">                                
                                <tr>    

                                    <td>${requerimientos.requerimientoId}</td>
                                    <td>${requerimientos.gerencia.descripcionGerencia}</td>    
                                    <td>${requerimientos.departamento.descripcionDepartamento}</td>    
                                    <td>${requerimientos.areaResolutora.descripcionArea}</td>    
                                    <td>${requerimientos.resolutor.nombreResolutor}</td>                                 
                                    <td>${requerimientos.fechaIngreso}</td>
                                    <td>${requerimientos.requerimiento}</td>
                                    <td>${requerimientos.estado}</td>
                                    <td>${requerimientos.fechaCierre}</td>                                  
                                    <td>
                                        <a href="requerimientoController.do?action=cerrar&id=${requerimientos.requerimientoId}"
                                           class="btn btn-danger" onclick=" return confirm('¿Seguro que desea Cerrar el Requerimiento?)')">Cerrar</a>                                    
                                    </td> 

                                </tr>                            
                            </c:forEach>                            

                            </tbody>

                        </table>  

                    </div>
                </div>     

            </div>
                                           
            <%@include file="/part/footer.jsp" %> 

        </div>
    </body>
</html>
