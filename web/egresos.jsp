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
                <h1 class="font-weight-bold mb-0">Egresos</h1>                            
            </div>
            <div class="col-lg-3 col-md-4 d-flex">
                <a class="btn btn-primary w-100 align-self-center " href="ProcesaEgreso?action=add" role="button">Nuevo</a>
            </div>
        </div>
    </div>
</section>
<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Fecha</th>
            <th scope="col">Categoria</th>
            <th scope="col">Descripcion</th>
            <th scope="col">Cantidad</th>
            <th scope="col">Precio</th>
            <th scope="col">Total</th>
            <th scope="col">Editar</th>
            <th scope="col">Eliminar</th>
        </tr>
    </thead>
    <tbody>       
    <c:forEach var="item" items="${egresos}">
        <tr>
            <%dato = dato + 1;%> 
            <th><%=dato%></th>
            <td>${item.fecha}</td>
            <td>${item.categoria}</td>            
            <td>${item.descripcion}</td>
            <td>${item.cantidad}</td>
            <td>${item.precio}</td>
            <td>${item.total}</td>
            <td><a href="ProcesaEgreso?action=edit&id=${item.id}"><i class="icon ion-md-paper lead mr-2"></i></a></td>
            <td><a href="ProcesaEgreso?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro ???'))"><i class="icon ion-md-trash lead "></i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="final.jsp" />