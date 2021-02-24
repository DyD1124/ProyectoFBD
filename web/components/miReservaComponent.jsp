<%@page import="datos.Reserva_HabitacionDAO"%>
<%@page import="negocio.Reserva_Habitacion"%>
<%@page import="negocio.Persona"%>
<%@page import="datos.PersonaDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="negocio.Reserva"%>
<%@page import="datos.ReservaDAO"%>
<!DOCTYPE html>
<html>
<head>
	<title>Mi reserva</title>
</head>
<body>
	<main>
          
		<div>
                    <form >
                            <p>Para consultas, ingresa tu número de reserva aquí:</p>
                            <input type="text" name="numReserva">
                            <button type="submit">Buscar</button>

			</form>
			
		</div>
                <%
                      if (!request.getParameterMap().isEmpty()) {
                          ReservaDAO rd = new ReservaDAO();
                          Reserva r = rd.getReserva();
                          r.setNumeroDocumento((String) request.getSession().getAttribute("documento"));
                          r.setNumeroReserva(request.getParameter("numReserva"));
                          rd.BuscarReservaIdPersona();

                          PersonaDAO pd = new PersonaDAO();
                          Persona p = new Persona();
                          p = pd.getPersona();
                          p.setDocumentoIdentidad((String) request.getSession().getAttribute("documento"));
                          pd.Buscar();
                          
                
            %>
		<div>
			<h2>La reserva esta a nombre de:</h2>
			<label>Primer Nombre</label>
			<p><%= p.getPrimerNombre() %></p>
			<label>Segundo Nombre</label>
			<p><%= p.getSegundoNombre()%></p>
			<label>Primer apellido</label>
			<p><%= p.getPrimerApellido()%></p>
			<label>Segundo apelido</label>
			<p><%= p.getSegundoApellido()%></p>
		</div>
		<h2>Tu reserva</h2>
		<div>
			<h3>Fechas de estadía</h3>
			<label>Fecha de entrada</label>
			<p><%= r.getFechaInicio()%></p>
			<label>Fecha de salida</label>
			<p><%= r.getFechaFinal()%></p>
			<label>Noches</label>
			<p><%= r.getNumeroDias()%></p>
		</div>
		<div>
			
			<label>Estado:</label>
			<p><%= r.getEstado()%></p>
			
		</div>
		<h3>Habitaciones</h3>
                <% 
                    Reserva_HabitacionDAO rdao = new Reserva_HabitacionDAO();
                    Reserva r1 = rdao.getR();
                    r1.setNumeroReserva(request.getParameter("numReserva"));
                    ResultSet rs =rdao.Habitaciones_por_reserva();
                    while(rs.next()){
                        try{
                %>
		<div>
			<div>
				<label>Número habitación</label>
				<p><%=rs.getString(1)%></p>
				<label>Número camas</label>
				<p><%=rs.getString(2)%></p>
				<label>Descripción</label>
				<p><%=rs.getString(3)%></p>
			</div>
		</div>
                                <% } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (r.getEstado().equals("A")) {
                                %>

                <form action="cancelarReservaComponent.jsp">
                    <input type="hidden" name="numreser" value="<%=request.getParameter("numReserva")%>">
                    <button type="submit"> Cancelar Reserva</button>
                </form>
                    <%              }
                    }%>
	</main>

</body>
</html>