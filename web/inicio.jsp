<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% int id=(Integer)session.getAttribute("id"); %>
<% int iduser=(Integer)session.getAttribute("iduser"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Styles -->
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- Google fonts -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,700&display=swap" rel="stylesheet">

    <!-- Ionic icons -->
    <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">

    <title>Dashboard - Templune</title>
</head>

<body>
    <div class="d-flex" id="content-wrapper">

        <!-- Sidebar -->
        <div id="sidebar-container" class="bg-primary">
            <div class="logo">
                <h4 class="text-light font-weight-bold mb-0">The Electric Point</h4>
            </div>
            
                <a href="ProcesaIngresos" class="d-block text-light p-3 border-0"><i class="icon ion-logo-usd lead mr-2"></i>Ingresos
                    </a>
                <a href="ProcesaEgreso" class="d-block text-light p-3 border-0"><i class="icon ion-md-people lead mr-2"></i>
                    Egresos</a>  
                <a href="ProcesaCategoriaIngreso" class="d-block text-light p-3 border-0"><i class="icon ion-logo-usd lead mr-2"></i>Categoria Ingreso
                    </a>
                <a href="ProcesaCategoriaEgreso" class="d-block text-light p-3 border-0"><i class="icon ion-logo-usd lead mr-2"></i>Categoria Egreso
                    </a>
                <a href="ProcesaPaginaPrincipal" class="d-block text-light p-3 border-0"><i class="icon ion-md-stats lead mr-2"></i>
                    Estadísticas</a>
                <c:set var="a" value="${iduser}" />
                <c:if test="${a == 1}">
                    <a href="ProcesaUsuarios" class="d-block text-light p-3 border-0"><i class="icon ion-md-people lead mr-2"></i>
                    Usuarios</a>
                </c:if>                
                <a href="ProcesaPerfil?action=view&id=${id}" class="d-block text-light p-3 border-0"><i class="icon ion-md-person lead mr-2"></i>
                    Perfil</a>
            
        </div>
        <!-- Fin sidebar -->
        
           <div class="w-100">
     
                 <!-- Navbar -->
         <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
            <div class="container">
    
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
    
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                  <li class="nav-item dropdown">
                    <a class="nav-link text-dark dropdown-toggle" href="#" id="navbarDropdown" role="button"
                      data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <img src="assets/img/logo_upea.png" class="img-fluid rounded-circle avatar mr-2"
                      alt="https://generated.photos/" />
                    GRUPO 21
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="ProcesaPerfil?action=view&id=${id}">Mi perfil</a>
                      <div class="dropdown-divider"></div>
                      <a href="Logout" class="dropdown-item" href="#">Cerrar sesión</a>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <!-- Fin Navbar -->         
                 <!-- Page Content -->
        <div id="content" class="bg-grey w-100">
