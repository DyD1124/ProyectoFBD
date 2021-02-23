<%@page import="negocio.Persona"%>
<%@page import="negocio.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
      <form id="usuarioRegistrado" method="post" autocomplete="on">
      <div class="entrada-info">
        <input type="number" name="dni" id="dni" value="123456789">
        <div> <input type="text" name="primernombre" id="Primernombre" value="Daniel"></div>
        <div> <input type="text" name="segundonombre" id="Segundonombre" value="David"></div>
        <div> <input type="text" name="primerapellido" id="PrimerApellido" value="Garay"></div>
        <div> <input type="text" name="segundapellido" id="SegundoApellido" value="Palacios"></div>
        <div> <input type="text" name="correo" id="correo" value="daniel.garay@correo.com"></div>
        <div> <input type="text" name="direccion-Calle" id="direccion-Calle" value="5ta"></div>
        <div> <input type="text" name="direccion-Avenida" id="direccion-Avenida" value="Av Cali"></div>
        <div> <input type="text" name="direccion-Ciudad" id="direccion-Ciudad" value="Los santos"></div>
        <div> <input type="text" name="direccion-Adicional" id="direccion-Adicional" value="26b - 30"></div>
        <div><select class="TipoDocumento" name="tipodocumento" required><option value="">Seleccione</option>
              <option value="CC">Cédula</option>
              <option value="TI">Tarjeta de Identidad</option>
              <option value="CE">Cédula de extranjeria</option>
              <option value="PA">Pasaporte</option>
        </select></div>
        <div> <input type="date" name="fecha_nacimiento" id="fecha_nacimiento" value="2000-01-01"></div>
        <div> <input type="number" name="celular" id="celular" value="3101110000"></div>
        </div> 
        <div>
        <input type="hidden" name="opcion" value="registrarse">
        </div>
        <div><INPUT type="submit" value="Añadir"></div>
        <a href="inicioSesion.jsp">Inicio</a>
    </form>
    <%
        if (!request.getParameterMap().isEmpty()) {
            try{
            Controlador c = new Controlador();
            Persona p = c.getPersona();
            p.setDocumentoIdentidad(request.getParameter("dni"));
            p.setTipoDocumento(request.getParameter("tipodocumento"));
            p.setPrimerNombre(request.getParameter("primernombre"));
            p.setSegundoNombre(request.getParameter("segundonombre"));
            p.setPrimerApellido(request.getParameter("primerapellido"));
            p.setSegundoApellido(request.getParameter("segundapellido"));
            p.setFechaNacimiento(request.getParameter("fecha_nacimiento"));
            p.setTelefono(request.getParameter("celular"));
            p.setCalle(request.getParameter("direccion-Calle"));
            p.setAvenida(request.getParameter("direccion-Avenida"));
            p.setAdicional(request.getParameter("direccion-Adicional"));
            p.setCiudad(request.getParameter("direccion-Ciudad"));
            c.InsertarPersona();
            }catch(Exception e){
                out.print("mal");
            }
        }
    %>     
</body>
</html>
