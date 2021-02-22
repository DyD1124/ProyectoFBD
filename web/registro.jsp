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
      <form id="usuarioRegistrado" method="post" autocomplete="off">
      <div class="entrada-info">
        <input type="number" name="dni" id="dni" placeholder="123456789">
        <div> <input type="text" name="primernombre" id="Primernombre" placeholder="Daniel"></div>
        <div> <input type="text" name="segundonombre" id="Segundonombre" placeholder="David"></div>
        <div> <input type="text" name="primerapellido" id="PrimerApellido" placeholder="Garay"></div>
        <div> <input type="text" name="segundapellido" id="SegundoApellido" placeholder="Palacios"></div>
        <div> <input type="text" name="correo" id="correo" placeholder="daniel.garay@correo.com"></div>
        <div> <input type="text" name="direccion-Calle" id="direccion-Calle" placeholder="5ta"></div>
        <div> <input type="text" name="direccion-Avenida" id="direccion-Avenida" placeholder="Av Cali"></div>
        <div> <input type="text" name="direccion-Ciudad" id="direccion-Ciudad" placeholder="Los santos"></div>
        <div> <input type="text" name="direccion-Adicional" id="direccion-Adicional" placeholder="26b - 30"></div>
        <div><select class="TipoDocumento" name="tipodocumento" required><option placeholder="">Seleccione</option>
              <option placeholder="CC">Cédula</option>
              <option placeholder="TI">Tarjeta de Identidad</option>
              <option placeholder="CE">Cédula de extranjeria</option>
              <option placeholder="PA">Pasaporte</option>
        </select></div>
        <div> <input type="date" name="fecha_nacimiento" id="fecha_nacimiento" placeholder="2000-01-01"></div>
        <div> <input type="number" name="celular" id="celular" placeholder="3101110000"></div>
        </div> 
        <div>
        <input type="hidden" name="opcion" placeholder="registrarse">
        </div>
        <div><INPUT type="submit" placeholder="Añadir"></div>
        <a href="inicioSesion.jsp">Inicio</a>
    </form>
    <%
        if (!request.getParameterMap().isEmpty()) {
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
        }
    %>     
</body>
</html>
