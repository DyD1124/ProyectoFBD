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

  <div class="container">
    <img src="RECURSOS/Logo.png" class="logo" lt="Logo">
    <form id="inicio" method="post" autocomplete="off" action="Session">
      <div class="datos-ingreso" id="datos_ingreso">
        <h3>Su usuario es su documento de identidad</h3>
        <div><input class="usuario" type="text" name="usuario" id="usuario" placeholder="Usuario"></div>
        <br>
        <h3>Su contrase�a es su primer nombre y su primer apellido (Sin espacio)</h3>
        <div><input type="password" name="contrasena" id="contrasena" placeholder="Contrase�a">
        </div>
        <br>
        <div class="boton-registro"><button type="submit" name="button" class="boton">Iniciar Sesi�n</button></div>
        <input type="hidden" name="opcion" value="ingreso">
      </div>
    </form>
  </div>
  <%//Parte del anterior boton: <a href="indexUsuario.jsp" class="button">Iniciar Sesi�n</a>
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
                out.println("Contrase�a Incorrecta");
            }
        }catch(Exception e){
            out.println("Usted no se encuentra registrado");
        }
    }
  %>    

</body>
</html>