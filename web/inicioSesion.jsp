<%@page import="negocio.Persona"%>
<%@page import="negocio.Controlador"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" type ="text/css" href="CSS/inicioSesion.css">
  <title>InicioPersona</title>
</head>
<body>
<<<<<<< HEAD
    <form id="inicio" method="post" autocomplete="off" action="Session">
    <div class="datos-ingreso" id="datos_ingreso">
      <h3>Su contraseña es su numero de cedula</h3>
      <div><input class="usuario" type="text" name="usuario" id="usuario" placeholder="Usuario"></div>
      <br>
      <h3>Su contraseña es su primer nombre y su primer apellido (Sin espacio)</h3>
      <div><input type="password" name="contrasena" id="contrasena" placeholder="Contraseña">
      </div>
      <br>
      <div><button type="submit" name="button">Iniciar Sesión</div></button>
      <input type="hidden" name="opcion" value="ingreso">
    </div>
  </form>
  
=======
  <div class="container">
    <img src="RECURSOS/Logo.png" class="logo" lt="Logo">
    <form id="inicio" method="post" autocomplete="off">
      <div class="datos-ingreso" id="datos_ingreso">
        <h3>Su usuario es su documento de identidad</h3>
        <div><input class="usuario" type="text" name="usuario" id="usuario" placeholder="Usuario"></div>
        <br>
        <h3>Su contraseña es su primer nombre y su primer apellido (Sin espacio)</h3>
        <div><input type="password" name="contrasena" id="contrasena" placeholder="Contraseña">
        </div>
        <br>
        <div class"boton-registro"><button type="submit" name="button" class="boton">Iniciar Sesión</button></div>
        <input type="hidden" name="opcion" value="ingreso">
      </div>
    </form>
  </div>
  <%//Parte del anterior boton: <a href="indexUsuario.jsp" class="button">Iniciar Sesión</a>
    if (!request.getParameterMap().isEmpty()) {
        Controlador c = new Controlador();
        Persona p = c.getPersona();
        p.setDocumentoIdentidad(request.getParameter("usuario"));
        try{
            c.BuscarPersona();  
            String contra = p.getPrimerNombre()+p.getPrimerApellido();
            if(request.getParameter("contrasena").equals(contra)){
                response.sendRedirect("new.jsp");
            }else{
                out.println("Contraseña Incorrecta");
            }
        }catch(Exception e){
            out.println("Usted no se encuentra registrado");
        }
    }
  %>    
>>>>>>> f91db62d9fbea5f19abd44bd8aa1bf94d5c90ffa
</body>
</html>