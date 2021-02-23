<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="negocio.Pago"%>
<%@page import="negocio.Hotel"%>
<%@page import="negocio.Cuenta"%>
<%@page import="negocio.Reserva"%>
<%@page import="negocio.Controlador"%>
<nav class="menu">
    <a class="menu__link">Consultas</a>
    <a class="menu__link">Check-in / Check - out</a>
    <a class="menu__link">Reporte</a>
</nav>

<div class="image">
    
</div>

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
    <%
        Controlador c = new Controlador();
        Reserva r = c.getReserva();
        r.setNumeroDocumento(request.getParameter("documento"));
        c.BuscarReservaPorPersona();
        Cuenta ct = c.getCuenta();
        c.BuscarCuentaPorReserva();
        Hotel h = c.getHotel();
        h.setIdDescuento(r.getIdDescuento());
        c.BuscarHotel();
        float nuevoValor = ct.getValor()-(ct.getValor()*(h.getDescuento()/100));
        out.println("Esto es lo q debes pagar (Descuento aplicado): "+nuevoValor);
        
        //Una vez realizado el pago...
        
        Calendar fecha = Calendar.getInstance();
        Pago p = c.getPago();
        p.setFechaPago(fecha.get(Calendar.YEAR)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.DATE));
        p.setValorPagado(nuevoValor);
        p.setIdCuenta(ct.getIdCuenta());
        p.setIdPago("");//String de 10
        p.setFromaPago(request.getParameter("formaPago"));
        c.InsertarPago();
    %>