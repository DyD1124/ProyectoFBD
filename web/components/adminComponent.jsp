<%@page import="negocio.Reserva"%>
<%@page import="negocio.Controlador"%>
<nav class="menu">
    <a class="menu__link">Consultas</a>
<<<<<<< HEAD
    <a class="menu__link" href="CheckInComponent.jsp">Check-in</a> 
    <a class="menu__link">Check-out</a>
    <a class="menu__link">Reporte</a>

=======
    <a class="menu__link" href="checkOut.jsp">Check-out</a>
    <a class="menu__link">Reporte</a>
>>>>>>> 993af919f74002361eba7c38470ba825c3f5d0cf
</nav>

<div class="image">
    
</div>
<<<<<<< HEAD

=======
<<<<<<< HEAD
    <%       
    %>

=======
>>>>>>> c5a44fd93b30898aa4036e813c889d2290f92d9b

<div class="consult">
    <div class="consult__content disable">
        <label for="selectOption">Consultar por:</label>
        <select class="consult__select groupOne" name="selectOption">
            <option value=""></option>
            <option value="Habitaciones libres Uno" class="OptionOne">Habitaciones libres</option>
            <option value="Habitaciones ocupadas Uno" class="OptionOne">Habitaciones ocupadas</option>
            <option value="Habitaciones reservadas Uno" class="OptionOne">Habitaciones reservadas</option>
            <option value="Numero reserva" class="OptionTwo">Numero reserva</option>
            <option value="Nombre huesped" class="OptionTwo">Nombre huesped</option>
        </select>
    </div>
<<<<<<< HEAD
</div>

=======
</div>  
>>>>>>> c5a44fd93b30898aa4036e813c889d2290f92d9b

<div class='checkOut'>
    
</div>
<<<<<<< HEAD

=======
    <%
        Controlador c = new Controlador();
        Reserva r = c.getReserva();
        r.setNumeroReserva(request.getParameter("idreserva"));
        
        //Cambiar estado de pagado de cuenta

    %>
>>>>>>> 993af919f74002361eba7c38470ba825c3f5d0cf
>>>>>>> c5a44fd93b30898aa4036e813c889d2290f92d9b
