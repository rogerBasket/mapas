<%@page language="java" contentType="text/html" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>MapBici</title>
		<link rel="stylesheet" href="estilos/estilo.css" type="text/css"/>
		<link rel="stylesheet" href="estilos/formulario.css" type="text/css"/>

		<!-- slides -->
		<!-- add styles -->
		<link rel="stylesheet" href="estilos/slides.css" type="text/css"/>
		
		<!-- calendario -->
		<!-- add styles -->
		<link href="calendario-js/css/base/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" type="text/css"/>

		<!-- calendario -->
		<!-- add scripts -->
		<script src="calendario-js/js/jquery-1.8.3.js"></script>
		<script src="calendario-js/js/jquery-ui-1.9.2.custom.min.js"></script>
		<script src="calendario-js/js/jquery-ui-i18n.js"></script>
		<script>
			$(function(){
				$.datepicker.setDefaults(
					$.extend($.datepicker.regional[''])
				);
				$('#datepicker').datepicker();
				$('#datepicker').datepicker('option',$.datepicker.regional['es']);
			});
		</script>

		<!-- slides -->		
		<!-- add scripts -->
		<script type="text/javascript" src="js/slider.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
	</head>
	<body>
		<div id="contiene">
			<div id="datos">
				<div id="titulo">
					<h1>MapBici</h1>
					<a href="HomeAction"><img class="logo" src="images/logo.png"/></a>
				</div>
				<div id="menu">
					<ul id="navega">
						<li><a href="HomeAction">Home</a></li>
					</ul>
				</div>
			</div>
			
			<div id="slides-container">
		        <div id="slides">
					<div>
						<div class="slide-image"><img src="images/bici1.png"/></div>
						<div class="slide-text">
						    <h2>Costo de la bicicleta</h2>
						    <p>El precio de una bici es accesible para la poblacion, no consume nada, no tienes que pagar un seguro, no hay que hacerle ningun arreglo, no te ponen multas de aparcamiento ni de velocidad.</p>
						</div>
					</div>
					 
					<div>
						<div class="slide-image"><img src="images/bici2.png"/></div>
						<div class="slide-text">
						    <h2>La Bici no contamina</h2>
						    <p>Contribuye con el planeta, la bici es el medio de transporte mas ecologico que puedes utilizar en la ciudad. Ahorra emisiones de CO2 innecesarias. Por cada 3 kilometros en bici, se ahorra 1 kilo de CO2.</p>
						</div>
					</div>
					 
					<div>
						<div class="slide-image"><img src="images/bici3.png"/></div>
						<div class="slide-text">
						    <h2>Ir en bici es rapido</h2>
						    <p>Para distancias de 7 kilometros o menos, es mas rapido ir en bici que en cualquier otro transporte. No tardaras en esperar al transporte publico ni en estacionarla.</p>
						</div>
					</div>		         
				</div>
		        <div class="controls"><span class="jFlowNext"><span>Next</span></span><span class="jFlowPrev"><span>Prev</span></span></div>        
		        <div id="myController" class="hidden"><span class="jFlowControl">Slide 1</span><span class="jFlowControl">Slide 1</span><span class="jFlowControl">Slide 1</span></div>
		    </div>
			
			<div id="texto">
				<div id="paginas">
					<div class="caja">
						<h4>Registro Usuario</h4>
						<form action="RegistroAction" method="post">
							<label for="user">Usuario:</label>
							<input type="text" name="user"/>
							<label for="pass">Password:</label>
							<input type="password" name="pass"/>
							<label for="confirmar">Confirmar Password:</label>
							<input type="password" name="confirmar"/>
							<label for="cumple">Fecha Nacimiento:</label>
							<input type="text" name="cumple" id="datepicker"/>
							<label for="mail">Mail:</label>
							<input type="text" name="mail"/>
							<input type="submit" class="formbutton" value="Aceptar"/>
						</form>
					</div>	
				</div>	
			</div>
		</div>	
	</body>
</html>