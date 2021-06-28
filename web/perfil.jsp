<%
    if(session.getAttribute("login") != "OK"){
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="inicio.jsp" />
<section class="content-header">
    <h1>
        Perfil
    </h1>    
</section>
<!-- Main content -->
<section class="content">
    <div class="row"><!-- .row -->
        <!-- <div class="col-md-1"></div> -->
        <div class="col-md-4">
            <!-- Profile Image -->
            <div class="box box-success">
                <div class="box-body box-profile">
                    <div id="load_img">
                        <img class="mb-4" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/1200px-User_icon_2.svg.png" alt="" width="300">
                    </div>
                    <h3 class="profile-username text-center">${usuarios.nombre_apellido}</h3>
                    <p class="text-muted text-center mail-text">${usuarios.email}</p>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
            <br>
        </div> 
        <!-- <div class="col-md-1"></div> -->
        <div class="col-md-8">
            <div id="result"></div>
            <div class="box box-success"><!-- general form elements -->
                <div class="box-header with-border">
                    <h3 class="box-title">Datos Personales: </h3>
                </div> <!-- /.box-header -->
                <form role="form" method="post" name="upd" id="upd"><!-- form start -->
                    <div class="box-body">
                        <div class="form-group">
                            <label for="name">Nombre:</label>
                            <input name="name" type="text" class="form-control" id="name" value="${usuarios.nombre_apellido}" required disabled>
                        </div>
                        <div class="form-group">
                            <label for="ci">C.I.:</label>
                            <input name="ci" type="text" class="form-control" id="email" value="${usuarios.ci}" required disabled>
                        </div>
                        <div class="form-group">
                            <label for="celular">Celular:</label>
                            <input name="celular" type="text" class="form-control" id="email" value="${usuarios.celular}" required disabled>
                        </div>
                        <div class="form-group">
                            <label for="fecha_nac">Fecha de Nacimiento:</label>
                            <input name="fecha_nac" type="text" class="form-control" id="email" value="${usuarios.fecha_nac}" required disabled>
                        </div>
                        <div class="form-group">
                            <label for="email">Correo Electronico:</label>
                            <input name="email" type="text" class="form-control" id="email" value="${usuarios.email}" required disabled>
                        </div>                        
                        <div class="form-group">
                            <label for="password">Contrase&ntilde;a:</label>
                            <input name="password" type="password" class="form-control" id="password" value="${usuarios.ci}" disabled>
                        </div>                                   
                    </div><!-- /.box-body -->
                    <div class="box-footer text-right">
                        
                        <a href="ProcesaPerfil?action=edit&id=${usuarios.id}" class="btn btn-success">Actualizar Datos</a>
                    </div>
                </form>
            </div><!-- /.box -->
        </div>
        <!-- <div class="col-md-1"></div> -->
    </div><!-- /.row -->
</section>
<jsp:include page="final.jsp" />