<%@page import="negocio.*" %>

        <form id="registro" method="post" autocomplete="off">
            <div><input type="text" name="documento" id="documento" placeholder="Documento Usuario" > 
                <input type="text" name="reserva" id="reserva" placeholder="Numero Reserva" > 
                <input type="button" value ="Registrar" id ="registrar" name="registrar">
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
            }else{
                out.println("No puede hospedar.");
            }
        }catch(Exception e){
            out.println("El usuario no esta registrado");
        }       
    }
    
  %>          

