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
    </head>
    <body>
               <form id="registro" method="post" autocomplete="off">
            <div><input type="text" name="documento" id="documento" placeholder="Documento Usuario" > 
                <input type="text" name="reserva" id="reserva" placeholder="Numero Reserva" > 
                 <button name="button">Chek-in</button>
            </div>  
        </form>
 <%     
    if (!request.getParameterMap().isEmpty()) {
        Controlador c = new Controlador();
        Persona p = c.getPersona();
        Reserva r = c.getReserva();                 
        p.setDocumentoIdentidad(request.getParameter("documento"));        
        r.setNumeroDocumento(request.getParameter("documento"));
        r.setNumeroReserva(request.getParameter("reserva"));                
        Registro rg = c.getRegistro();
        Huesped h = c.getHuesped();                 
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
                rg.setIdRegistro(r.randon());                
                rg.setF_entrada(r.annio+"-"+r.mes+"-"+r.dia);
                rg.setF_salida(null);                
                rg.setDocumentoIdentidad(request.getParameter("documento"));
                rg.setNumeroReserva(r.getNumeroReserva());
                h.setDocumentoIdentidad(p.getDocumentoIdentidad());
                h.setIdHuesped(r.randon());
                out.println(rg.getDocumentoIdentidad()+" "+rg.getF_entrada()+" "
                        +" "+rg.getF_salida()+" "+rg.getIdRegistro()+" "+rg.getNumeroReserva());                              
                c.InsertarRegistro();
                c.InsertarHuesped();
            }else{
           out.println("No puede hospedar.");
            }
        }catch(Exception e){
            out.println("El usuario no esta registrado");
        }       
    }
    
  %>          
    </body>
</html>
