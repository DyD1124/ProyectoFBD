<%@page import="negocio.Persona"%>
<%@page import="negocio.Controlador"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>InicioPersona</title>
</head>
<body>
  <form id="inicio" method="post" autocomplete="off">
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
</body>
</html>