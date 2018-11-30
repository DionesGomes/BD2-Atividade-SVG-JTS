<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<!--Import Google Icon Font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	<!--Let browser know website is optimized for mobile-->
	<link rel="stylesheet" type="text/css" href="arquivo.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<div class="container">
		<!-- Escolha das cidades -->
		<div class="row" id="esquerdo">
			<h1> Cidade 1</h1>
			<hr></br></br>

			<div class="input-field col s5">
				<select>
					<option value="" disabled selected>Escolha um Estado</option>
					<option value="1">Option 1</option>
					<option value="2">Option 2</option>
					<option value="3">Option 3</option>
				</select>
				<label>Estado</label>
			</div>

			<div class="input-field col s5">
				<select>
					<option value="" disabled selected>Escolha uma cidade</option>
					<option value="1">Option 1</option>
					<option value="2">Option 2</option>
					<option value="3">Option 3</option>
				</select>
				<label>Cidade</label>
			</div>
		</div>

		<div class="row" id="direito">
			<h1>Cidade 2</h1>
			<hr></br></br>

			<div class="input-field col s5">
				<select>
					<option value="" disabled selected>Escolha um Estado</option>
					<option value="1">Option 1</option>
					<option value="2">Option 2</option>
					<option value="3">Option 3</option>
				</select>
				<label>Estado</label>
			</div>
			<div class="input-field col s5">
				<select>
					<option value="" disabled selected>Escolha uma cidade</option>
					<option value="1">Option 1</option>
					<option value="2">Option 2</option>
					<option value="3">Option 3</option>
				</select>
				<label>Cidade</label>
			</div>

		</div>

		<!-- Mostrar os dados -->
		<div class="row" id="esquerdo">
			<div class="row">
				<div class="input-field col s5">
					<input disabled value="0" id="populacao" type="text" class="validate">
					<label for="disabled">População</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s5">
					<input disabled value="0" id="densidade" type="text" class="validate">
					<label for="disabled">Densidade demográfica</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s5">
					<input disabled value="0" id="area" type="text" class="validate">
					<label for="disabled">Área</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s5">
					<input disabled value="0" id="perimetro" type="text" class="validate">
					<label for="disabled">Perímetro</label>
				</div>
			</div>
		</div>

		<div class="row" id="direito">
			<div class="row">
				<div class="input-field col s5">
					<input disabled value="0" id="populacao" type="text" class="validate">
					<label for="disabled">População</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s5">
					<input disabled value="0" id="densidade" type="text" class="validate">
					<label for="disabled">Densidade demográfica</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s5">
					<input disabled value="0" id="area" type="text" class="validate">
					<label for="disabled">Área</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s5">
					<input disabled value="0" id="perimetro" type="text" class="validate">
					<label for="disabled">Perímetro</label>
				</div>
			</div>
		</div>
		<!-- Imagem do mapa -->
		<div id="esquerdo">
			<img src="" alt="nome da cidade">
		</div>

		<div id="direito">
			<img src="" alt="nome da cidade">
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	 crossorigin="anonymous"></script>

	<!--JavaScript at end of body for optimized loading-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('select').formSelect();
		});
	</script>
</body>

</html>