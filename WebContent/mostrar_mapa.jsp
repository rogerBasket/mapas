<%@ page language="java" contentType="text/html"%>
<%@page import="model.Mapas" %>
<%@page import="model.Usuarios" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mapbici</title>
		<link rel="stylesheet" href="estilos/estilo.css" type="text/css"/>
		
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
				<%
					Mapas m = (Mapas)request.getAttribute("mapa");
				%>
				
				var options = {
			        zoom: 13
			        , mapTypeId: google.maps.MapTypeId.ROADMAP
			        , streetViewControl: false
			        , mapTypeControlOptions: {
			            mapTypeIds: []
			          }
			    };
				
			    // The map's center and zoom will be set by the DirectionsRenderer.
				var map = new google.maps.Map(document.getElementById('ruta'),options);
				var directionsRenderer = new google.maps.DirectionsRenderer();
				var directionsService = new google.maps.DirectionsService();

			    directionsRenderer.setMap(map);
			    directionsRenderer.setPanel(document.getElementById('panel'));

			    var request = {
					origin: new google.maps.LatLng(<%=m.getLatitud1()%>,<%=m.getLongitud1()%>),
					destination: new google.maps.LatLng(<%=m.getLatitud2()%>,<%=m.getLongitud2()%>),
					travelMode: google.maps.TravelMode.BICYCLING,
					provideRouteAlternatives: true
			    };

			    directionsService.route(request, function(result, status) {
					if (status == google.maps.DirectionsStatus.OK) {
					  	directionsRenderer.setDirections(result);
					} else {
					 	window.console.log('failed to get directions: '  + status);
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
					<%
						HttpSession hs = request.getSession(false);
						Usuarios u = (Usuarios)hs.getAttribute("usuario");
						if(u != null) {
					%>
						<ul id="salir">
							<li><a href="SalirAction">Salir</a></li>
						</ul>
					<%
						}
					%>
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
				<div id="ruta"></div>
				<div id="panel"></div>
				<div id="disqus_thread"></div>
		        <script>
		            /* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
		            var disqus_config = function () {
				        this.page.url = 'http://localhost:8080/mapbici/VerMapaAction?idMapa=<%=request.getParameter("idMapa") %>';
				        this.page.identifier = <%=request.getParameter("idMapa")%>;
				    };
				    
		            var disqus_shortname = 'mapbici'; // required: replace example with your forum shortname
		
		            /* * * DON'T EDIT BELOW THIS LINE * * */
		            (function() {
		                var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
		                dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
		                (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
		            })();
		        </script>
			</div>	
		</div>	
	</body>
</html>