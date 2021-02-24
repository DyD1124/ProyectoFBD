<%-- 
    Document   : recibirHuespedComponent
    Created on : 24-feb-2021, 7:53:23
    Author     : johan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="negocio.*" %>
<%@page import="java.sql.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Huesped</title>
    </head>
    <body>
        <label id="REGISTRO COMPLETADO"><h3>REGISTRO COMPLETADO</h3></label>
        
   <%
        Controlador c = new Controlador();      
        Persona p = c.getPersona();
        Reserva r = c.getReserva();                 
        p.setDocumentoIdentidad(request.getParameter("documento"));
        r.setNumeroDocumento(request.getParameter("documento"));
        r.setNumeroReserva(request.getParameter("reserva"));          
        Registro rg = c.getRegistro();
        Huesped h = c.getHuesped();                                                                     
                rg.setIdRegistro(r.randon());                
                rg.setF_entrada(r.annio+"-"+r.mes+"-"+r.dia);
                rg.setF_salida(null);                
                rg.setDocumentoIdentidad(request.getParameter("documento"));
                rg.setNumeroReserva(r.getNumeroReserva());
                h.setDocumentoIdentidad(p.getDocumentoIdentidad());
                h.setIdHuesped(r.randon());
                c.InsertarHuesped();
                c.InsertarRegistro(); 
    %>
    <form action="inicioAdmin.jsp">
        <button type="submit" name="Inicio">Inicio</button>
    </form>
    </body>
</html>
