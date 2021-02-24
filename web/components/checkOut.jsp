<%@page import="java.util.Calendar"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="negocio.*"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="checkOut.css">
    <meta charset="utf-8">
    <title>CheckOut</title>
  </head>
  <body>
    <div class="p-registro">
        <div><img class="img-logo" src="Logo.png"></div>
        <div><p>Digite los datos para el check out</div>
    </div>
    <form>  
      <div class="etiquetas">
        <div class="etiqueta">
          <label id="NumReserva"><h3>Numero de reserva</h3></label>
          <div><input type="text" name="numReserva" id="numReserva" placeholder="9874563215" required value="<% if(request.getParameter("numReserva")!=null){ out.print(request.getParameter("numReserva")); }%>"></div>
        </div>
      </div>  
        <div><button type="submit" class="btnEspecial1">Factura</button></div>
            <table>
                <thead>
                    <th>Insumo</th>
                    <th>Valor</th>
                </thead> 
                <%
                if (!request.getParameterMap().isEmpty()) {
                    Controlador c = new Controlador();
                    Reserva r = c.getReserva();
                    r.setNumeroReserva(request.getParameter("numReserva"));
                    c.BuscarReserva();
                    Reserva_Habitacion rh = c.getReserva_Habitacion();
                    rh.setNumeroReserva(request.getParameter("numReserva"));
                    c.BuscarReserva_Habitacion();
                    Habitacion h = c.getHabitacion();
                    h.setIdHabitacion(rh.getIdHabitacion());
                    c.BuscarHabitacion();
                    Tipo t = c.getTipo();
                    t.setIdTipo(h.getIdTipo());
                    System.out.println("");
                    ResultSet rs = c.BuscarResultTipo();
                    while(rs.next()){
                        float precio = (rs.getInt(1))*(r.getNumeroDias()); 
                %>
                <tr>
                    <th><p><%="Estadia"%></p></th>
                    <th><p><%=precio%></p></th>
                </tr>   
                <%
                    }
                    Cuenta ct = c.getCuenta();
                    ct.setNumeroReserva(request.getParameter("numReserva"));
                    c.BuscarCuentaPorReserva();
                    ProductoServicio_Cuenta psc = c.getProductoServicio_Cuenta();
                    psc.setIdCuenta(ct.getIdCuenta());
                    rs = c.BuscarResultProductoServicio_CuentaPorIdcuenta();
                    while(rs.next()){
                        ProductoServicio ps = c.getProductoServicio();
                        ps.setCodigo(rs.getString(1));
                        c.BuscarProductoServicio();
                %>
                <tr>
                    <th><%=ps.getNombreProducto()%></th>
                    <th><%=ps.getPrecio()%></th>
                </tr>   
                <%
                    }
                %>
                <tr>
                    <th>Total</th>
                    <th><%=ct.getValor()%></th>
                </tr>
                <%
                    Hotel ht = c.getHotel();
                    ht.setIdDescuento(r.getIdDescuento());
                    c.BuscarHotel();
                    float descPorcentaje = ht.getDescuento();
                    float desc = ht.getDescuento()/100;
                    float totalFinal = ct.getValor()-(ct.getValor()*(desc));
                %>
                <tr>
                    <th>Descuento</th>
                    <th><%=descPorcentaje%></th>
                </tr>
                <tr>
                    <th>Total Final</th>
                    <th><%=totalFinal%></th>
                </tr>
                <%
                    ct.setEstadoCuenta("SP");
                    c.ModificarCuenta();
                %>
            </table>
            <select name="formapago" id="formapago" required>
                <option value="Tarjeta">Tarjeta</option>
                <option value="Efectivo">Efectivo</option>
                <option value="Cheque">Cheque</option>
            </select>
            <div><INPUT type="submit" value="Check Out" class="btnEspecial2"></div>
    </form>

            <%  //LLENADO DE PAGO
                if(request.getParameter("formapago")!=null){
                    Calendar calendario = Calendar.getInstance();
                    String fecha = calendario.get(Calendar.YEAR)+"-"+calendario.get(Calendar.MONTH)+"-"+calendario.get(Calendar.DATE);
                    Pago p = c.getPago();
                    p.setIdCuenta(ct.getIdCuenta());
                    p.setFromaPago(request.getParameter("formapago"));
                    p.setFechaPago(fecha);
                    p.setValorPagado(totalFinal);
                        int aux1 = (int)(Math.random()*99998+1);  
                        int aux2 = (int)(Math.random()*99998+1);
                        String aux = String.valueOf(aux1)+String.valueOf(aux2);        
                        p.setIdPago(aux);
                        try{
                            c.InsertarPago();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                %>
                <%  //MODIFICACIONES REGISTRO, RESERVA
                    Registro rt = c.getRegistro();
                    rt.setNumeroReserva(request.getParameter("numReserva"));
                    c.BuscarRegistroPorReserva();
                    rt.setF_salida(fecha);
                    c.ModificarRegistro();
                    r.setEstado("f");
                    c.ModificarReserva();
                }
            }

            %>
  </body>
</html>
