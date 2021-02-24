<%@page import="negocio.Reserva"%>
<%@page import="negocio.Controlador"%>
<nav class="menu">
    <a class="menu__link">Consultas</a>
    <a class="menu__link" href="checkOut.jsp">Check-out</a>
    <a class="menu__link">Reporte</a>
    adf
</nav>

<div class="image">
    
</div>
<<<<<<< HEAD
=======

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
</div>
<<<<<<< HEAD

<div class='checkOut'>
    
</div>
=======
    <%
        Controlador c = new Controlador();
        Reserva r = c.getReserva();
        r.setNumeroReserva(request.getParameter("idreserva"));
        
        //Cambiar estado de pagado de cuenta

    %>
>>>>>>> f91db62d9fbea5f19abd44bd8aa1bf94d5c90ffa
>>>>>>> f22487b73de0ab8f604340ff377b8e81bdec621a
