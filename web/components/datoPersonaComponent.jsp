<form>
	<div>
		<label>Primer Nombre</label>
		<input type="text" name="primerNombre">
		<label>Segundo Nombre</label>
		<input type="text" name="segundoNombre">
		<label>Primer apellido</label>
		<input type="text" name="primerApellido">
		<label>Segundo apelido</label>
		<input type="text" name="segundoApellido">
	</div>
	<div>
		<label for="tipo">Tipo de documento</label>
		<select name="tipo" id="tipo">
			<option value="CC">Cédula de ciudadanía</option>
			<option value="TI">Tarjeta de indentidad</option>
			<option value="CE">Cédula de extranjería</option>
			<option value="PAP">Pasaporte</option>
			<option value="RG">Registro civil</option>
		</select>
		<label>Número de documento</label>
		<input type="number" name="numDoc">
	</div>
	<div>
		<label>Fecha de nacimiento</label>
		<input type="date" name="fNacimiento">
	</div>
	<div>
		<label>Telefono</label>
		<input type="number" name="tel">
	</div>
	<div>
		<h3>Dirección</h3>
		<label>Calle</label>
		<input type="text" name="calle">
		<label>Avenida</label>
		<input type="text" name="avenida">
		<label>Ciudad</label>
		<input type="text" name="ciudad">
		<label>(Torre, apartemento, conjunto,...)</label>
		<input type="text" name="dirAdicional">
	</div>

	<button type="submit">Siguiente</button>
</form>