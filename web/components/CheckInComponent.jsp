<%-- 
    Document   : Prueba
    Created on : 23-feb-2021, 16:23:49
    Author     : johan
--%>
<%@page import="negocio.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type ="text/css" href="CSS/checkIn.css">
    </head>
    <body>
        <div class="p-registro">
            <div><img class="img-logo" src="Logo.png"></div>
            <div><p>Digite los datos para el Check-in</div>
        </div>
           <form id="buscar" method="post" autocomplete="off" >
            <div class="etiquetas">
                <div class="etiqueta">
                    <label id="numReserva"><h3>Numero de reserva</h3></label>
                    <div><input type="text" name="documento" id="documento" placeholder="Documento Usuario" > </div> 
                    <input type="text" name="reserva" id="reserva" placeholder="Numero Reserva" > 
                 <button type="submit" name="button">Buscar</button>            
                </div>
            </div>        
           
        
 <%     
    if (!request.getParameterMap().isEmpty()) {        
        Controlador c = new Controlador();      
        Persona p = c.getPersona();
        Reserva r = c.getReserva();                 
        p.setDocumentoIdentidad(request.getParameter("documento"));
        r.setNumeroDocumento(request.getParameter("documento"));
        r.setNumeroReserva(request.getParameter("reserva"));                   
        try{
            c.BuscarPersona();            
            c.BuscarReserva();
            out.println("Nombre:" + p.getPrimerNombre()+" "+p.getSegundoNombre() + " " 
                    + p.getPrimerApellido() +" "+ p.getSegundoApellido());                  
            out.println("Tipo Documento: "+p.getTipoDocumento()+ " N°: "+ p.getDocumentoIdentidad());
            out.println("Fecha Nacimiento: " + p.getFechaNacimiento());
            out.println("Telefono Contacto: " + p.getTelefono());
            out.println("Fecha Reserva:" + r.getFechaInicio() + " --- " + r.getFechaFinal());    
            if (r.ValidarFechas()){    
                out.println("Se puede hospedar.");            
%>
           </form>
<form action="recibirHuespedComponent.jsp"> 
    <input type="hidden" name="documento" id="documento" value=<%=p.getDocumentoIdentidad()%>>
    <input type="hidden" name="reserva" id="reserva" value=<%=r.getNumeroReserva()%>> 
        <button type="submit" name="Registrar">Registrar</button>
  

        <%
            }else{
           out.println("No puede hospedar.");
            }
        }catch(Exception e){
            out.println("El usuario no esta registrado");
        }       
    }
    
  %>       
           </form>
    </body>
</html>
