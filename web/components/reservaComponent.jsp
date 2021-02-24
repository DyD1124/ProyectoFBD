<%@page import="datos.ReservaDAO"%>
<%@page import="negocio.Hotel"%>
<%@page import="datos.HotelDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="negocio.Reserva"%>
<%@page import="datos.Reserva_HabitacionDAO"%>
<%@page import="negocio.Tipo"%>
<%@page import="negocio.Habitacion"%>
<%@page import="negocio.Controlador"%>

<%@ include file="/components/header.jsp" %>
<input type="hidden" name="" class="type" value="user">
<form action="reservaComponent.jsp" class="">
    <div>
        <h3>Fechas de estadía</h3>
        <label>Fecha de entrada</label>
        <input type="date" name="f_entrada" required <%if (request.getParameter("f_entrada")!=null){ out.println("value='"+request.getParameter("f_entrada")+"'"); } %>>
        <label>Fecha de salida</label>
        <input type="date" name="f_salida" required <%if (request.getParameter("f_salida")!=null){ out.println("value='"+request.getParameter("f_salida")+"'"); } %>>
    </div>
    <div>
    </div>
    <button type="submit" class="btnSubmit">Verificar disponibilidad</button>
</form>
<div>
    <form action="datoPersonaComponent.jsp" id="dataForm">
        <%
            if (!request.getParameterMap().isEmpty()) {
                try {
                        Reserva_HabitacionDAO rh = new Reserva_HabitacionDAO();
                        Reserva r = rh.getR();
                        r.setFechaInicio(request.getParameter("f_entrada"));
                        r.setFechaFinal(request.getParameter("f_salida"));
                        Calendar c = Calendar.getInstance();
                        String dia = Integer.toString(c.get(Calendar.DATE));
                        String mes = Integer.toString(c.get(Calendar.MONTH)+1);
                        String annio = Integer.toString(c.get(Calendar.YEAR));

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaHoy = dateFormat.parse(annio+"-"+mes+"-"+dia);
                        Date fechaInicial = dateFormat.parse(r.getFechaInicio());
                        Date fechaFinal = dateFormat.parse(r.getFechaFinal());
                        System.out.println(fechaInicial.before(fechaHoy));
                        System.out.println(fechaFinal.before(fechaHoy));
                        if (!fechaInicial.before(fechaHoy) && !fechaFinal.before(fechaHoy)) {

                            int dias = Math.round((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
                            HotelDAO hd = new HotelDAO();
                            Hotel h = hd.getHotel();
                            h.setDias(dias);
                            hd.Buscar();

                            ReservaDAO rd = new ReservaDAO();
                            Reserva r2 = rd.getReserva();
                            r2.setFechaFinal(r.getFechaFinal());
                            r2.setFechaInicio(r.getFechaInicio());
                            r2.setEstado("A");
                            r2.setIdDescuento(h.getIdDescuento());
                            r2.setNumeroDias(dias);
                            r2.setNumeroDocumento((String)request.getSession().getAttribute("documento"));




        %>
        <label>¿Cuántas personas van a ir?</label>
        <input type="number" name="nPersonas" required>
        <br>
        <%
                    ResultSet rs = rh.Habitaciones_diponibles();
                    if(rs.isBeforeFirst()){
                        int num = (int)(Math.random()*1000000000+1);
                        String numReser = String.valueOf(num);
                        r2.setNumeroReserva(numReser);
                        rd.Insertar();

                    }
                    while (rs.next()) {


        %> 
        <input type="checkbox" name="hab" value="<%=rs.getString(1)%>">

        <div>
            <label for="hab">
                <label>Número habitación</label>
                <p><%=rs.getString(1)%></p>
                <label>Número camas</label>
                <p><%=rs.getInt(2)%></p>
                <label>Descripción</label>
                <p><%=rs.getString(3)%></p>
                <label>Precio</label>
                <p><%=rs.getFloat(4)%></p>
            </label>
        </div>
            <input type="hidden" name="precio" value="<%=rs.getFloat(4)%>">

        <%

            } %>
        <input type="hidden" name="numreser" value="<%=r2.getNumeroReserva()%>">
        <input type="hidden" name="dias" value="<%=h.getDias()%>">
        <button type="submit" class="btnContinuar">Continuar reserva</button>
        <%
        } else {
            response.sendRedirect("reservaComponent.jsp");
        }
    } catch (Exception e) {
        out.print("No hay más habitaciones disponibles");
        e.printStackTrace();
    }

}
        %>   

    </form>
</div>
<%@ include file="/components/footer.jsp" %>
