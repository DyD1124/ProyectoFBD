<%@page import="java.sql.ResultSet"%>
<%@page import="negocio.Reserva"%>
<%@page import="datos.Reserva_HabitacionDAO"%>
<%@page import="negocio.Tipo"%>
<%@page import="negocio.Habitacion"%>
<%@page import="negocio.Controlador"%>
<div class="menu">
    
</div>
<form action="components/reservaComponent.jsp">
    <div>
        <h3>Fechas de estadía</h3>
        <label>Fecha de entrada</label>
        <input type="date" name="f_entrada" required>
        <label>Fecha de salida</label>
        <input type="date" name="f_salida" required>
    </div>
    <div>
        <label>¿Cuántas personas van a ir?</label>
        <input type="number" name="nPersonas">

    </div>
    <button type="submit" class="btnSubmit">Verificar disponibilidad</button>
    <div>
        <form>
        <%
            if (!request.getParameterMap().isEmpty()) {
                try {
                    Reserva_HabitacionDAO rh = new Reserva_HabitacionDAO();
                    Reserva r = rh.getR();
                    r.setFechaInicio(request.getParameter("f_entrada"));
                    r.setFechaFinal(request.getParameter("f_salida"));

                    ResultSet rs = rh.Habitaciones_diponibles();
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
                  <%

                    }
                } catch (Exception e) {
                    out.print("No hay más habitaciones disponibles");
                }

            }
        %>   
         <%
            if (!request.getParameterMap().isEmpty()) {
          %>
        <button type="submit">Continuar reserva</button>
         <%}%>
        </form>
        <script>
            (() => {
                
                console.log("Funciona")
                const d = document;
                const getHTML = (options) => {
                    let {url, success, error} = options
                    const xhr = new XMLHttpRequest();

                    xhr.addEventListener('readystatechange', (e) => {
                        if (xhr.readyState !== 4)
                            return;

                        if (xhr.status >= 200 && xhr.status <= 300) {
                            let html = xhr.responseText;
                            success(html)
                            console.log("Sigue funcionando")
                        } else {
                            let message = xhr.statusText || "Ocurrio un error";
                            error(`Error ${xhr.status}: ${message}`)
                        }
                    });

                    xhr.open("GET", url);
                    // El content type es de tipo text/html
                    xhr.setRequestHeader("Content-type", "text/html; charset=utf-8");
                    xhr.send()
                }

                const getHTMLS = () => {
                    getHTML({
                        url: `userComponent.jsp`,
                        success: (html) => {

                            document.querySelector(`.menu`).innerHTML = html
                        },
                        error: (err) => {
                            // Aqui introduciriamos el error en la pagina.
                        }
                    });

                }


                getHTMLS();
            })()

        </script>

    </div>
</form>