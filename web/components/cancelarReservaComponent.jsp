<%-- 
    Document   : cancelarReservaComponent
    Created on : 24/02/2021, 06:04:58 AM
    Author     : mile1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="negocio.Reserva"%>
<%@page import="datos.ReservaDAO"%>
<%@page import="datos.PersonaDAO"%>
<%@ include file="/components/header.jsp" %>
<%
    try {
    ReservaDAO rd = new ReservaDAO();
    Reserva r = rd.getReserva();
    r.setNumeroReserva(request.getParameter("numreser"));
    r.setEstado("C");
    rd.CancelarReserva();
    
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<h1>Reserva cancelada</h1>
<h2>La reserva cancelada tenia el siguiente número : <%= request.getParameter("numreser")%></h2>

<%@ include file="/components/footer.jsp" %>
