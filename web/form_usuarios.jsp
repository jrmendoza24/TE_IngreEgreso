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
                        <h1 class="font-weight-bold mb-0">Formulario de usuarios</h1>                            
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
                                <form action="ProcesaUsuarios" method="post">
                                    <div>
                                        <input type="hidden" class="form-control" id="exampleInputEmail1" value="${usuarios.id}" name="id">
                                    </div> 
                                    <div class="mb-3">
                                        <label for="exampleInputEmail1" class="form-label">Nombre y Apellido</label>
                                        <input type="text" class="form-control" id="exampleInputEmail1" value="${usuarios.nombre_apellido}" name="nombre_apellido">                                        
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">C.I.</label>
                                        <input type="number" class="form-control" value="${usuarios.ci}" name="ci">
                                    </div>  
                                    <div class="mb-3">
                                        <label class="form-label">Celular</label>
                                        <input type="number" class="form-control" value="${usuarios.celular}" name="celular">
                                    </div>                                    
                                    <div class="mb-3">
                                        <label class="form-label">Fecha de Nacimiento</label>
                                        <input type="date" class="form-control"  name="fecha_nac" value="${usuarios.fecha_nac}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleInputEmail1" class="form-label">Email</label>
                                        <input type="text" class="form-control" id="exampleInputEmail1" value="${usuarios.email}" name="email">                                        
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleInputEmail1" class="form-label">Contraseña</label>
                                        <input type="text" class="form-control" id="exampleInputEmail1" value="${usuarios.password}" name="password">                                        
                                    </div>
                                    <div>
                                        <label class="form-label">Tipo de Usuario</label>
                                        <select name="id_user" class="form-control">
                                            <option value="">-- Seleccione--</option>
                                            <c:forEach var="item" items="${lista_usuarios}">
                                                <option value="${item.id_user}" 
                                                        <c:if test="${usuarios.id_user == item.id_user}">
                                                            selected
                                                        </c:if>
                                                        >${item.tipo_usuario}
                                                </option> 
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div>
                                    <br>    
                                    <button type="submit" class="btn btn-primary">Ingrese datos</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>
<jsp:include page="final.jsp" />