<%
    if(session.getAttribute("login") != "OK"){
        response.sendRedirect("login.jsp");
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
                <h1 class="font-weight-bold mb-0">Categoria de ingresos</h1>                            
            </div>
            <div class="col-lg-3 col-md-4 d-flex">
                <a class="btn btn-primary w-100 align-self-center " href="ProcesaCategoriaIngreso?action=add" role="button">Nuevo</a>
            </div>
        </div>
    </div>
</section>
<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre</th>
            <th scope="col">Fecha</th>
            <th scope="col">Editar</th>
            <th scope="col">Eliminar</th>
        </tr>
    </thead>
    <tbody>       
    <c:forEach var="item" items="${categoria_ingresos}">
        <tr>
            <%dato = dato + 1;%> 
            <th><%=dato%></th>
            <td>${item.nombre}</td>
            <td>${item.fecha}</td>
            <td><a href="ProcesaCategoriaIngreso?action=edit&id=${item.id_cat_ing}"><i class="icon ion-md-paper lead mr-2"></i></a></td>
            <td><a href="ProcesaCategoriaIngreso?action=delete&id=${item.id_cat_ing}" onclick="return(confirm('Esta seguro ???'))"><i class="icon ion-md-trash lead "></i></a></td>
        </tr>
    </c:forEach>
    </tbody>
<jsp:include page="final.jsp" />