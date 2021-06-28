<%
    if(session.getAttribute("login") != "OK"){        
        response.sendRedirect("login.jsp");
    }
    if(session.getAttribute("id_user") != "1"){
        response.sendRedirect("ProcesaPaginaPrincipal");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  int dato = 0; %>
<jsp:include page="inicio.jsp" />
<section class="bg-light py-3">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-8">
                <h1 class="font-weight-bold mb-0">Usuarios</h1>                            
            </div>
            <div class="col-lg-3 col-md-4 d-flex">
                <a class="btn btn-primary w-100 align-self-center " href="ProcesaUsuarios?action=add" role="button">Nuevo</a>
            </div>
        </div>
    </div>
</section>
<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre y Apellido</th>
            <th scope="col">CI</th>
            <th scope="col">Celular</th>
            <th scope="col">Fecha de Nacimiento</th>
            <th scope="col">Email</th>
            <th scope="col">Tipo de Usuario</th>
            <th scope="col">Editar</th>
            <th scope="col">Eliminar</th>
        </tr>
    </thead>
    <tbody>       
    <c:forEach var="item" items="${usuarios}">
        <tr>
            <%dato = dato + 1;%> 
            <th><%=dato%></th>
            <td>${item.nombre_apellido}</td>
            <td>${item.ci}</td>            
            <td>${item.celular}</td>
            <td>${item.fecha_nac}</td>
            <td>${item.email}</td>
            <td>${item.tipo_usuario}</td>
            <td><a href="ProcesaUsuarios?action=edit&id=${item.id}"><i class="icon ion-md-paper lead mr-2"></i></a></td>
            <td><a href="ProcesaUsuarios?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro ???'))"><i class="icon ion-md-trash lead "></i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="final.jsp" />