<%@page import="negocio.Persona"%>
<%@page import="negocio.Controlador"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>RegistroPersona</title>
</head>
<body>
  <div>
    <div class="etiquetas">
      <div class="etiqueta">Doc. de identidad: <span id="valDocumento" class="campo-obligatorio">(*)</span></div>
      <div class="etiqueta">Primer Nombre: <span id="valNombre" class="campo-obligatorio">(*)</span></div>
      <div class="etiqueta">Segundo Nombre: <span id="valNombre"></span></div>
      <div class="etiqueta">Primer Apellido: <span id="valNombre" class="campo-obligatorio">(*)</span></div>
      <div class="etiqueta">Segundo Apellido: <span id="valNombre"></span></div>
      <div class="etiqueta">Correo electrónico: <span id="valCorreo" class="campo-obligatorio">(*)</span></div>
      <div class="etiqueta">Dir. de residencia-Calle: <span id="valDireccion" class="campo-obligatorio">(*)</span></div>
      <div class="etiqueta">Dir. de residencia-Avenida: <span id="valDireccion" class="campo-obligatorio">(*)</span></div>
      <div class="etiqueta">Dir. de residencia-Ciudad: <span id="valDireccion" class="campo-obligatorio">(*)</span></div>
      <div class="etiqueta">Dirección adicional: <span id="valDireccion"></span></div>
      <div class="etiqueta">Tipo de documento <span id="TipoDocumento">(*)</span></div>
      <div class="etiqueta">Fecha de nacimiento: <span class="campo-obligatorio">(*)</span></div>
      <div class="etiqueta">Número de celular: <span id="valCelular" class="campo-obligatorio">(*)NO SE COMO HACER PARA QUE COLOQUE VARIOS</span></div>
    </div>
    <form id="usuarioRegistrado" method="post" autocomplete="off">
      <div class="entrada-info">
        <input type="number" name="dni" id="dni" placeholder="123456789">
        <div> <input type="text" name="Primernombre" id="nombre" placeholder="Daniel"></div>
        <div> <input type="text" name="Segundonombre" id="nombre" placeholder="David"></div>
        <div> <input type="text" name="PrimerApellido" id="nombre" placeholder="Garay"></div>
        <div> <input type="text" name="SegundApellido" id="nombre" placeholder="Palacios"></div>
        <div> <input type="text" name="correo" id="correo" placeholder="daniel.garay@correo.com"></div>
        <div> <input type="text" name="direccion-Calle" id="direccionCll" placeholder="5ta"></div>
        <div> <input type="text" name="direccion-Avenida" id="direccionAv" placeholder="Av Cali"></div>
        <div> <input type="text" name="direccion-Ciudad" id="direccionCiu" placeholder="Los santos"></div>
        <div> <input type="text" name="direccion-Adicional" id="direccionAdd" placeholder="26b - 30"></div>
        <div><select class="TipoDocumento" name="Documento" required><option value="">Seleccione</option>
              <option value="CC">Cédula</option>
              <option value="TI">Tarjeta de Identidad</option>
              <option value="CE">Cédula de extranjeria</option>
              <option value="PA">Pasaporte</option>
        </select></div>
        <div> <input type="date" name="fecha_nacimiento" id="fecha_nacimiento" value="2000-01-01"></div>
        <div> <input type="number" name="celular" id="celular" placeholder="3101110000"></div>
        </div>
        <div>
        <input type="hidden" name="opcion" value="registrarse">
        </div>
        <div><button type="button" name="button"><a href="inicioSesion.jsp" class="button">Registrarse</a></div></button>
    </form>
    <%  if(!request.getParameterMap().isEmpty()){
            
            try{
                Controlador c = new Controlador();
                Persona p = c.getPersona();
                p.setDocumentoIdentidad(request.getParameter("dni"));
                p.setTipoDocumento(request.getParameter("TipoDocumento"));
                p.setPrimerNombre(request.getParameter("PrimerNombre"));
                p.setSegundoNombre(request.getParameter("SegundoNombre"));
                p.setPrimerApellido(request.getParameter("PrimerApellido"));
                p.setSegundoApellido(request.getParameter("SegundoAPellido"));
                p.setFechaNacimiento(request.getParameter("fecha_nacimiento"));
                p.setTelefono(request.getParameter("celular"));
                p.setCalle(request.getParameter("direccion-Calle"));
                p.setAvenida(request.getParameter("direccion-Avenida"));
                p.setAdicional(request.getParameter("direccion-Adicional"));
                p.setCiudad(request.getParameter("direccion-Ciudad"));
                c.InsertarPersona();
                out.print("WENNNA!");
            }
            catch(Exception e){
                out.print("REVISA PELOTUDO");
            }
        }
    %>     
</body>
</html>
