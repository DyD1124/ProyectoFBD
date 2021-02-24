<%@ include file="headerAdmin.jsp" %>
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
<%@ include file="footerAdmin.jsp" %>