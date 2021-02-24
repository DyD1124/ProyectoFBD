<%@page import="negocio.Persona"%>
<%@page import="datos.PersonaDAO"%>
<%@page import="negocio.Reserva_Habitacion"%>
<%@page import="datos.Reserva_HabitacionDAO"%>
<%@page import="java.util.Enumeration"%>
<%@ include file="/components/header.jsp" %>
<form action="finComponent.jsp" id="">
    <h2>�Qui�n va a hospedarse con nosotros?</h2>
    <% 
        int personas = Integer.parseInt(request.getParameter("nPersonas"));
        boolean error = false;
        String reserva = request.getParameter("numreser");

        for (Enumeration<String> nombres = request.getParameterNames(); nombres.hasMoreElements();) {
            if (request.getParameter(nombres.nextElement()).trim().isEmpty()) {
                error = true;
            }
        }   
        if (!error) {
            String[] values = request.getParameterValues("hab");
            for (int i = 0; i < values.length; i++) {
                try {
                    String numHab = values[i];
                    Reserva_HabitacionDAO rh = new Reserva_HabitacionDAO();
                    Reserva_Habitacion rh_actual = rh.getReserva_Habitacion();
                    rh_actual.setNumeroReserva(reserva);
                    rh_actual.setIdHabitacion(numHab);
                    rh.Insertar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            out.print("No hay datos");
        }
    for (int i = 0; i < personas; i++) { %>
    <div>
        <label>Primer Nombre</label>
        <input type="text" name="primerNombre" required>
        <label>Segundo Nombre</label>
        <input type="text" name="segundoNombre">
        <label>Primer apellido</label>
        <input type="text" name="primerApellido" required>
        <label>Segundo apelido</label>
        <input type="text" name="segundoApellido">
    </div>
    <div>
        <label for="tipo">Tipo de documento</label>
        <select name="tipo" id="tipo"required>
            <option value="CC">C�dula de ciudadan�a</option>
            <option value="TI">Tarjeta de indentidad</option>
            <option value="CE">C�dula de extranjer�a</option>
            <option value="PA">Pasaporte</option>
        </select>
        <label>N�mero de documento</label>
        <input type="number" name="numDoc" required>
    </div>
    <div>
        <label>Fecha de nacimiento</label>
        <input type="date" name="fNacimiento" required>
    </div>
    <div>
        <label>Telefono</label>
        <input type="number" name="tel" required>
    </div>
    <div>
        <h3>Direcci�n</h3>
        <label>Calle</label>
        <input type="text" name="calle" required>
        <label>Avenida</label>
        <input type="text" name="avenida" required>
        <label>Ciudad</label>
        <input type="text" name="ciudad" required>
        <label>(Torre, apartemento, conjunto,...)</label>
        <input type="text" name="dirAdicional">
    </div>
    <% }%>

    
    <button type="submit">Terminar reserva</button>
</form>
    <%@ include file="/components/footer.jsp" %>
