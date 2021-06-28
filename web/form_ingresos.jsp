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
                        <h1 class="font-weight-bold mb-0">Formulario de ingresos</h1>                            
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
                                <form action="ProcesaIngresos" method="post">
                                    <div>
                                        <input type="hidden" class="form-control" id="exampleInputEmail1" value="${ingresos.id}" name="id">
                                    </div> 
                                    <div class="mb-3">
                                        <label for="exampleInputEmail1" class="form-label">Descripcion</label>
                                        <input type="text" class="form-control" id="exampleInputEmail1" value="${ingresos.descripcion}" name="descripcion">
                                        
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Cantidad</label>
                                        <input type="number" class="form-control" value="${ingresos.cantidad}" name="cantidad">
                                    </div>  
                                    <div class="mb-3">
                                        <label class="form-label">Precio</label>
                                        <input type="number" class="form-control" value="${ingresos.precio}" name="precio">
                                    </div>                                    
                                    <div class="mb-3">
                                        <label class="form-label">Fecha</label>
                                        <input type="date" class="form-control"  name="fecha" value="${ingresos.fecha}">
                                    </div>      
                                    <div>
                                        <label class="form-label">Categoria </label>
                                        <select name="id_ingreso" class="form-control">
                                            <option value="">-- Seleccione--</option>
                                            <c:forEach var="item" items="${lista_ingresos}">
                                                <option value="${item.id_cat_ing}" 
                                                        <c:if test="${ingresos.id_cat_ing == item.id_cat_ing}">
                                                            selected
                                                        </c:if>
                                                        >${item.nombre}
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