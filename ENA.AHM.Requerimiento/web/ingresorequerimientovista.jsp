<%-- 
    Document   : requerimiento
    Created on : 22-07-2020, 22:05:16
    Author     : Andres
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<title>Ingreso Requerimiento</title>
<html>    
     <%@include file="/part/head.jsp" %>
    
    <body>
        <div class="container">
            <%@include file="/part/header.jsp" %>

            <form action="requerimientoController.do"  method="POST">
                <div class="container shadow">
                    
                    <div class="card shadow w-50 mx-auto" >
                        <div class="card-header bg-dark text-white">
                            
                            <h4>
                                Ingreso de Requerimientos
                            </h4>
                            
                        </div>					
                        <div class="card-body">	
                            <input type="hidden" name="hidId" value="${requerimiento.requerimientoId}" >
                            <div class="form-group">
                                Gerencia 
                                <select name="cboGerencia" class="form-control" required onchange="submit()" >
                                    
                                    <option value=""></option>
                                    <c:forEach  var="g"  items="${gerencias}" >
                                        
                                        <option value="${gerenciaId}"  
                                            ${g.gerenciaId == requerimiento.getGerencia().getGerenciaId() ? ' selected ' : ' '}>
                                        
                                            
                                            ${g.descripcionGerencia}
                                        </option>
                                    
                                    </c:forEach>
                                    
                                </select>			
                            </div>
                            <div class="form-group">
                                Departamento
                                
                                <select name="cboDepartamento" class="form-control" required  >
                                    
                                    <option value=""></option>
                                    <c:forEach  var="d"  items="${departamentos}" >
                                        
                                        <option value="${departamentoId}"
                                            ${d.departamentoId == requerimiento.getDepartamento().getDepartamentoId() ? ' selected ' : ' '  } >
                                            ${d.descripcionDepartamento}
                                        </option>
                                    
                                    </c:forEach>
                                    
                                </select>
                            </div>                           
                            
                            <div class="form-group">
                                Area Resolutora
                                
                                <select name="cboAreaResolutora" class="form-control" required  onchange="submit()">
                                    
                                    <option value=""></option>
                                    <c:forEach  var="ar"  items="${areaResolutoras}" >
                                        
                                        <option value="${areaResolutoraId}"
                                            ${ar.areaResolutoraId == requerimiento.getAreaResolutora().getAreaResolutoraId() ? ' selected ' : ' '  } >
                                            ${ar.descripcionArea}
                                        </option>
                                    
                                    </c:forEach>
                                    
                                </select>
                            </div>   

                            <div class="form-group">
                                Resolutor
                                
                                <select name="cboResolutor" class="form-control" required  >
                                    
                                    <option value=""></option>
                                    <c:forEach  var="r"  items="${resolutores}" >
                                        
                                        <option value="${resolutorId}"
                                            ${r.resolutorId == requerimiento.getResolutor().getResolutorId() ? ' selected ' : ' '  } >
                                            ${r.nombreResolutor}
                                        </option>
                                    
                                    </c:forEach>
                                    
                                </select>
                            </div>                              
                            
                            <div class="form-group">
                                Requerimiento
                                <input type="text" name="txtRequerimiento" value="${requerimiento.requerimiento}" class="form-control" maxlength="150" required>
                            </div>   
                            
                           
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            <hr>
                            
                            <div class="form-group text-center row">
                                
                                <div class="col-6">                                
                                    <input type="submit" value="Grabar" name="action" class="btn btn-primary w-100"/>
                                </div>
                                <div class="col-6">                                
                                    <a class="btn btn-warning w-100" href="empleadoController.do?action=listar" >Volver a Clientes</a> 
                                </div>                                
                            </div>
                            
                            <div class="${estiloMensaje}" role="alert">
                                ${mensaje}                                
                            </div>
                            
                        </div>
                    </div>    
                </div>                   

            </form>

             <%@include file="/part/footer.jsp" %>
        </div>
    </body>
</html>


