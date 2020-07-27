<%-- 
    Document   : loginvista
    Created on : 26-07-2020, 22:42:51
    Author     : aeherrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/part/head.jsp"%>

    <title>Acceso</title>

    <body>

        <div class="container">

            <form action="requerimientoController.do" method="POST">
                <div class="card shadow w-50 mx-auto">

                    <div class="card-header">
                        <h4>Acceso al sistema</h4>

                    </div>

                    <div class="card-body">
                        <div class="form-group">
                            Usuario
                            <input type="text" name="txtNick" value="${usuario.usuario}" class="form-control">

                        </div>
                        <div class="form-group">
                            Password
                            <input type="password" name="txtPassword" class="form-control">

                        </div>

                        <div class="form-group">
                            
                            <input type="checkbox" name="chkRecordar" value="Recordar" class="form-control">

                        </div>



                        <div class="${estiloMensaje}" role="alert">
                            ${mensaje}                                
                        </div>



                    </div>

                    <div class="card-footer" >
                        <input type="submit" name="action" value="Acceder" class="btn btn-primary">
                    </div>
                </div>


            </form>



        </div>

    </body>
</html>
