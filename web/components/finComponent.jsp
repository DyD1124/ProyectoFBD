<%@page import="negocio.Reserva"%>
<%@page import="datos.ReservaDAO"%>
<%@page import="datos.PersonaDAO"%>
<%@ include file="/components/header.jsp" %>
<%
    try {
        String[] pn = request.getParameterValues("primerNombre");
        String[] sn = request.getParameterValues("segundoNombre");
        String[] pa = request.getParameterValues("primerApellido");
        String[] sa = request.getParameterValues("segundoApellido");
        String[] t = request.getParameterValues("tipo");
        String[] nd = request.getParameterValues("numDoc");
        String[] f = request.getParameterValues("fNacimiento");
        String[] cll = request.getParameterValues("calle");
        String[] av = request.getParameterValues("avenida");
        String[] c = request.getParameterValues("ciudad");
        String[] da = request.getParameterValues("dirAdicional");
        String[] tel = request.getParameterValues("tel");
        for (int i = 0; i < pn.length; i++) {
            PersonaDAO pd = new PersonaDAO();
            Persona p = pd.getPersona();
            p.setPrimerNombre(pn[i]);
            p.setSegundoNombre(sn[i]);
            p.setPrimerApellido(pa[i]);
            p.setSegundoApellido(sa[i]);
            p.setTipoDocumento(t[i]);
            p.setDocumentoIdentidad(nd[i]);
            p.setFechaNacimiento(f[i]);
            p.setCalle(cll[i]);
            p.setAvenida(av[i]);
            p.setCiudad(c[i]);
            p.setAdicional(da[i]);
            p.setTelefono(tel[i]);
            pd.Insertar();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<h1>Reserva realizada</h1>
<h2>Tu número de reserva es : <%= request.getParameter("numreser")%></h2>

<%@ include file="/components/footer.jsp" %>
