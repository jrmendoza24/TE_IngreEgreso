<%
    if(session.getAttribute("login") != "OK"){
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="inicio.jsp" />
       <section class="bg-light py-3">
            <div class="container">
                <div class="row">
                    <div class="col-lg-9 col-md-8">
                        <h1 class="font-weight-bold mb-0">Formulario de egresos</h1>                            
                    </div>
                </div>
            </div> 
        </section>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 my-3">
                        <div class="card rounded-0">
                            <div class="card-body">
                                <form action="ProcesaCategoriaEgreso" method="post">
                                    <div>
                                        <input type="hidden" class="form-control" id="exampleInputEmail1" value="${categoria_egresos_get.id}" name="id">
                                    </div> 
                                    <div class="mb-3">
                                        <label for="exampleInputEmail1" class="form-label">Nombre</label>
                                        <input type="text" class="form-control" id="exampleInputEmail1" value="${categoria_egresos_get.nombre}" name="nombre">
                                        
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Fecha</label>
                                        <input type="date" class="form-control" id="exampleInputPassword1" name="fecha" value="${categoria_egresos_get.fecha}">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Ingrese datos</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>
<jsp:include page="final.jsp" />