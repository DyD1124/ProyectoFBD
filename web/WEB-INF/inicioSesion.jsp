<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>InicioPersona</title>
</head>
<body>
  <form id="inicio" method="post" autocomplete="off">
    <div class="datos-ingreso" id="datos_ingreso">
      <h3>Su usuario es su primer nombre y su primer apellido</h3>
      <div><input class="usuario" type="text" name="usuario" id="usuario" placeholder="Usuario"></div>
      <br>
      <h3>Su contrase�a es su numero de cedula</h3>
      <div><input type="password" name="contrasena" id="contrasena" placeholder="Contrase�a">
      </div>
      <br>
      <div><button type="button" name="button"><a href="indexUsuario.jsp" class="button">Iniciar Sesi�n</a></div></button>
      <input type="hidden" name="opcion" value="ingreso">
    </div>
  </form>
</body>
</html>