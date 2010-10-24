/**
 * Classe javascript que permite manipular o mapa da API V3 do Google Maps,
 * com fun��es necess�rias ao escopo do TG.
 * @author Andr� 
 */

var directionsDisplay;
var map;

/**
 * Inicializa o mapa do google maps
 * @param lat - latitude 
 * @param lng - longitude
 * @param contentString - Conteudo da janela de informa��es
 * @return Mapa
 */
function initialize(lat,lng,contentString) {
	//adiciona latitude e longitude ao mapa
	var myLatlng = new google.maps.LatLng(lat,lng);

	//instancia um objeto direction dislpay para ser usado na rota
	directionsDisplay = new google.maps.DirectionsRenderer();
	
	//op��es basicas do mapa
	var myOptions = {
	  zoom: 17,
	  center: myLatlng,
	  mapTypeId: google.maps.MapTypeId.HYBRID
	};
	
	//instancia o mapa
	map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

	//janela de informa��es basica
	var infowindow = new google.maps.InfoWindow({
	    content: contentString
	});
	
	//marca no mapa
	var marker = new google.maps.Marker({
	      position: myLatlng, 
	      map: map, 
	      title:"Clique para informa��es"
	  });   
	
	//adiciona a janela de informa��es
	google.maps.event.addListener(marker, 'click', function() {
		  infowindow.open(map,marker);
		});
	
	//seta o mapa da pagina no direction display
	directionsDisplay.setMap(map);
	directionsDisplay.setPanel(document.getElementById("directionsPanel"));
}

/**
 * Fun��o que calcula a rota do usu�rio at� a unidade de venda
 * @param latOrg - latitude da origem (Usu�rio)
 * @param lgnOrg - longitude da origem (Usu�rio)
 * @param latDest - latitude do destino (Unidade de venda)
 * @param lgnDest - longitude do destino (Unidade de venda)
 * @return Mapa calculado
 */
function calcRoute(latOrg, lgnOrg, latDest, lgnDest) {

	var origem = new google.maps.LatLng(latOrg, lgnOrg);
	var destino = new google.maps.LatLng(latDest, lgnDest);
	
	//Servi�o de rotas.
	var directionsService = new google.maps.DirectionsService();

	//Objeto com origem,destino e tipo de viagem (Carro)
	var request = {
		origin : origem,
		destination : destino,
		travelMode : google.maps.DirectionsTravelMode.DRIVING
	};

	//Obt�m a rota!
	directionsService.route(request, function(response, status) {
		if (status == google.maps.DirectionsStatus.OK) {
			directionsDisplay.setDirections(response);
		}
	});
}
