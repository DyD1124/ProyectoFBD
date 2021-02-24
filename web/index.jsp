<%-- 
    Document   : index
    Created on : 21/02/2021, 09:51:24 AM
    Author     : Familia Garay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>HotelBD</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
  <link rel="stylesheet" type ="text/css" href="CSS/index.css">
</head>
<body>
  <form id="ingreso" method="post" autocomplete="off">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
      <a class="navbar-brand">
        <img src="RECURSOS/Logo.png" class="logo" lt="Logo">
      </a>
      <li class="nav-item active">
        <a class="nav-link" href="inicioSesion.jsp">Inicio de Sesión</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="registro.jsp">Registrarse</a>
      </li>
    </ul>
  </nav>
  <div class="container">
    <h1>BIENVENIDO TURISTA</h1>
    <h3>Reserve con nosotros!!!</h3>
    <div class="bd-example">
      <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="RECURSOS/hotel1.jpg" class="d-block w-100">
            <div class="carousel-caption d-none d-md-block">
              <h5>Cancún</h5>
              <p>Disfruta tu instancia en nuestros hoteles</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="RECURSOS/hotel2.jpg" class="d-block w-100" >
            <div class="carousel-caption d-none d-md-block">
              <h5>Cartagena</h5>
              <p>Con los mejores precios en las mejores ciudades</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="RECURSOS/hotel3.jpg" class="d-block w-100">
            <div class="carousel-caption d-none d-md-block">
              <h5>Riviera Maya</h5>
              <p>Viaja con tu familia y amigos</p>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
  </div>
  </form>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</html>
