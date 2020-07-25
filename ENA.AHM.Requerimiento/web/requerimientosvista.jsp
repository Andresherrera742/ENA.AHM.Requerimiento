<%-- 
    Document   : requerimiento
    Created on : 22-07-2020, 23:17:08
    Author     : Andres
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<title>Requerimientos</title>
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
                            

                        </tbody>

                    </table>  
                    <a class="btn btn-primary" href="requerimientoController.do?action=nuevo">Nuevo</a>
                </div>
                <div>
                    
                </div>

            </div>          
        </div>
    </body>
</html>
