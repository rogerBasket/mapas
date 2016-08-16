<%@page language="java" contentType="text/html"%>
<%@page import="model.Usuarios" %>
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
		
		<!-- add scripts -->
		<script src="calendario-js/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/slider.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		
		<!--  google maps -->
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<script>
			window.onload = function() {
				//(19.4326077, -99.13320799999997)
				var coord = {lat: 19.432607, lng: -99.133207};
				document.getElementById("latitud1").value = coord.lat;
				document.getElementById("longitud1").value = coord.lng;
				document.getElementById("latitud2").value = coord.lat;
				document.getElementById("longitud2").value = coord.lng;
				
			    var options = {
			        zoom: 13
			        , center: coord
			        , mapTypeId: google.maps.MapTypeId.ROADMAP
			        , streetViewControl: false
			        , mapTypeControlOptions: {
			            mapTypeIds: []
			          }
			    };
			    
			    var map = new google.maps.Map(document.getElementById('map'), options);
			    var marcadores = 0;
			    
			    google.maps.event.addListener(map,"click",function(evento) {
					if(marcadores < 2) {
						var latitud = evento.latLng.lat();
						var longitud = evento.latLng.lng();
				
						var coordenadas = new google.maps.LatLng(latitud,longitud); 
						
						var marcador = new google.maps.Marker({
										position: coordenadas,
										map: map,
										draggable: true,	
										animation: google.maps.Animation.DROP, 
										title:"Mueve el marcador"
									});
						
						if(marcadores < 1) {		
							google.maps.event.addListener(marcador,'dragend',function() {
								var posicion1 = marcador.getPosition();
								document.getElementById("latitud1").value = posicion1.lat();
								document.getElementById("longitud1").value = posicion1.lng();
							});	
							
							var posicion1 = marcador.getPosition();
							document.getElementById("latitud1").value = posicion1.lat();
							document.getElementById("longitud1").value = posicion1.lng();
						} else {
							google.maps.event.addListener(marcador,'dragend',function() {
								var posicion2 = marcador.getPosition();
								document.getElementById("latitud2").value = posicion2.lat();
								document.getElementById("longitud2").value = posicion2.lng();
							});	
							
							var posicion2 = marcador.getPosition();
							document.getElementById("latitud2").value = posicion2.lat();
							document.getElementById("longitud2").value = posicion2.lng();
						}
						
						marcadores++;
					}
				}); 
			};
		</script>
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
					<ul id="salir">
						<li><a href="SalirAction">Salir</a></li>
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
				<div id="map"></div>
				<div class="caja">
					<form action="GuardarMapaAction">
						<input type="hidden" id="latitud1" name="latitud1"/>
						<input type="hidden" id="longitud1" name="longitud1"/>
						<input type="hidden" id="latitud2" name="latitud2"/>
						<input type="hidden" id="longitud2" name="longitud2"/>
						<input type="submit" class="formbutton" value="Guardar"/>
					</form>
				</div>
			</div>
		</div>	
	</body>
</html>