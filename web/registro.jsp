<%@page import="negocio.Persona"%>
<%@page import="negocio.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="CSS/registro.css">
  <title>RegistroPersona</title>
</head>
<body>
  <div>
    <h1>Registro de usuario</h1>
    <div class="p-registro">
            <div><img class="img-logo" src="RECURSOS/Logo.png"></div>
            <div><p>¡Bienvenido, registrese para reservar en los mejores hoteles.!
            </div>
    <div class="msj-campo-obl" id="campos_obligatorios">(*) Campos obligatorios</div>

    <form id="usuarioRegistrado" method="post" autocomplete="off">
      <div class="etiquetas">
        <div class="etiqueta">
          <label>Doc. de identidad: <span id="valDocumento" class="campo-obligatorio">(*)</span></label>
          <input type="string" name="dni" id="dni" placeholder="123456789">
        </div>
        <div class="etiqueta">
          <label>Primer Nombre: <span id="valNombre" class="campo-obligatorio">(*)</span></label>
          <div><input type="text" name="primernombre" id="primernombre" placeholder="Daniel"></div>
        </div>
        <div class="etiqueta">
          <label>Segundo Nombre: <span id="valNombre"></span></label>
          <div><input type="text" name="segundonombre" id="segundonombre" placeholder="David"></div>
        </div>
        <div class="etiqueta">
          <label>Primer Apellido: <span id="valNombre" class="campo-obligatorio">(*)</span></label>
          <div><input type="text" name="primerApellido" id="primerApellido" placeholder="Garay"></div>
        </div>
        <div class="etiqueta">
          <label>Segundo Apellido: <span id="valNombre"></span></label>
          <div><input type="text" name="segundApellido" id="segundApellido" placeholder="Palacios"></div>
        </div>
        <div class="etiqueta">
          <label>Correo electrónico: <span id="valCorreo" class="campo-obligatorio">(*)</span></label>
          <div><input type="text" name="correo" id="correo" placeholder="daniel.garay@correo.com"></div>
        </div>
        <div class="etiqueta">
          <label>Dir. de residencia-Calle: <span id="valDireccion" class="campo-obligatorio">(*)</span></label>
          <div><input type="text" name="direccion-Calle" id="direccionCll" placeholder="5ta"></div>
        </div>
        <div class="etiqueta">
          <label>Dir. de residencia-Avenida: <span id="valDireccion" class="campo-obligatorio">(*)</span></label>
          <div><input type="text" name="direccion-Avenida" id="direccionAv" placeholder="Av Cali"></div>
        </div>
        <div class="etiqueta">
          <label>Dir. de residencia-Ciudad: <span id="valDireccion" class="campo-obligatorio">(*)</span></label>
          <div><input type="text" name="direccion-Ciudad" id="direccionCiu" placeholder="Los santos"></div>
        </div>
        <div class="etiqueta">
          <label>Dirección adicional: <span id="valDireccion"></span></label>
          <div><input type="text" name="direccion-Adicional" id="direccionAdd" placeholder="26b - 30"></div>
        </div>
        <div class="etiqueta">
          <label>Tipo de documento <span id="TipoDocumento" class="campo-obligatorio">(*)</span></label>
          <div><select class="TipoDocumento" name="Documento" required><option value="">Seleccione</option>
                <option value="CC">Cédula</option>
                <option value="TI">Tarjeta de Identidad</option>
                <option value="CE">Cédula de extranjeria</option>
                <option value="PA">Pasaporte</option>
          </select></div>
        </div>
        <div class="etiqueta">
          <label>Fecha de nacimiento: <span class="campo-obligatorio">(*)</span></label>
          <div><input type="date" name="fecha_nacimiento" id="fecha_nacimiento" value="2000-01-01"></div>
        </div>
        <div class="etiqueta">
          <label>Número de celular: <span id="valCelular" class="campo-obligatorio">(*)</span></label>
          <div><input type="string" name="celular" id="celular" placeholder="3101110000"></div>
        </div>
      </div>
      <div>
        <input type="hidden" name="opcion" value="registrarse">
      </div>
      <div class="añadirPersona"><INPUT type="submit" value="Añadir" class="btnEspecial"></div>
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
