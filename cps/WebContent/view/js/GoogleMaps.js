var G_INCOMPAT = false;
function GScript(src) {
	document.write('<' + 'script src="' + src + '"'
			+ ' type="text/javascript"><' + '/script>');
}
function GBrowserIsCompatible() {
	if (G_INCOMPAT)
		return false;
	return true;
}
function GApiInit() {
	if (GApiInit.called)
		return;
	GApiInit.called = true;
	window.GAddMessages
			&& GAddMessages( {
				160 : '\x3cH1\x3eErro no servidor\x3c/H1\x3eOcorreu um erro tempor�rio no servidor e n�o � poss�vel concluir sua solicita��o. \x3cp\x3ePor favor, tente novamente em um minuto.\x3c/p\x3e',
				1415 : '.',
				1416 : '.',
				1547 : 'mi',
				1616 : 'km',
				4100 : 'm',
				4101 : 'p�s',
				10018 : 'Carregando...',
				10021 : 'Mais zoom',
				10022 : 'Menos zoom',
				10024 : 'Arraste para dar zoom',
				10029 : 'Voltar ao �ltimo resultado',
				10049 : 'Mapa',
				10050 : 'Sat�lite',
				10093 : 'Termos de Uso',
				10111 : 'Mapa',
				10112 : 'Sat',
				10116 : 'H�brido',
				10117 : 'H�b',
				10120 : 'Infelizmente, n�o temos mapas dessa regi�o com esse n�vel de detalhamento.\x3cp\x3eTente aplicar menos zoom para ver essa regi�o.\x3c/p\x3e',
				10121 : 'Infelizmente n�o temos imagens dessa regi�o com esse n�vel de detalhamento.\x3cp\x3eTente aplicar menos zoom para ver essa regi�o de mais longe.\x3c/p\x3e',
				10507 : 'Mover para a esquerda',
				10508 : 'Mover para a direita',
				10509 : 'Mover para cima',
				10510 : 'Mover para baixo',
				10511 : 'Mostrar mapa de ruas',
				10512 : 'Mostrar imagens de sat�lite',
				10513 : 'Mostrar imagens com nomes de rua',
				10806 : 'Clique para ver esta �rea no Google Maps',
				10807 : 'Tr�nsito',
				10808 : 'Mostrar tr�nsito',
				10809 : 'Ocultar tr�nsito',
				12150 : '%1$s na %2$s',
				12151 : '%1$s na %2$s na %3$s',
				12152 : '%1$s na %2$s entre %3$s e %4$s',
				10985 : 'Ampliar',
				10986 : 'Reduzir',
				11047 : 'Centralizar mapa aqui',
				11089 : '\x3ca href\x3d\x22javascript:void(0);\x22\x3eAmpliar\x3c/a\x3e para ver o tr�nsito nesta regi�o',
				11259 : 'Tela cheia',
				11751 : 'Mostrar mapa da rua com terreno',
				11752 : 'Estilo:',
				11757 : 'Alterar estilo de mapa',
				11758 : 'Terreno',
				11759 : 'Ter',
				11794 : 'Mostrar nomes',
				11303 : 'Ajuda do Street View',
				11274 : 'Para usar a vista da rua, voc� precisa da vers�o %1$d ou mais recente do Adobe Flash Player.',
				11382 : 'Obtenha o Flash Player mais recente',
				11314 : '\x3cbr\x3eInfelizmente, a vista da rua est� indispon�vel no momento devido � grande demanda. Tente novamente mais tarde!',
				1559 : 'N',
				1560 : 'S',
				1561 : 'O',
				1562 : 'L',
				1608 : 'NO',
				1591 : 'NE',
				1605 : 'SO',
				1606 : 'SE',
				11907 : 'Esta imagem n�o est� mais dispon�vel',
				10041 : 'Ajuda',
				12471 : 'Local atual',
				12492 : 'Earth',
				12823 : 'O Google desativou o uso da API do Google Maps para este aplicativo. Consulte os Termos de Servi�o para obter mais informa��es: %1$s.',
				12822 : 'http://code.google.com/apis/maps/terms.html',
				12915 : 'Aperfei�oar o mapa',
				12916 : 'Google, Europa Technologies',
				13171 : '3D H�brido',
				0 : ''
			});
}
var GLoad;
(function() {
	var jslinker = {
		version : "182",
		jsbinary : [
				{
					id : "maps2",
					url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/250a/maps2/main.js"
				},
				{
					id : "maps2.api",
					url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/250a/maps2.api/main.js"
				},
				{
					id : "gc",
					url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/250a/gc.js"
				},
				{
					id : "suggest",
					url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/250a/suggest/main.js"
				},
				{
					id : "pphov",
					url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/250a/pphov.js"
				} ]
	};
	GLoad = function(callback) {
		var callee = arguments.callee;
		var apiCallback = callback;
		GApiInit();
		var opts = {
			public_api : true,
			export_legacy_names : true,
			tile_override : [
					{
						maptype : 0,
						min_zoom : 7,
						max_zoom : 7,
						rect : [ {
							lo : {
								lat_e7 : 330000000,
								lng_e7 : 1246050000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1293600000
							}
						}, {
							lo : {
								lat_e7 : 366500000,
								lng_e7 : 1297000000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1320034790
							}
						} ],
						uris : [
								"http://mt0.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt1.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt2.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt3.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26" ]
					},
					{
						maptype : 0,
						min_zoom : 8,
						max_zoom : 9,
						rect : [ {
							lo : {
								lat_e7 : 330000000,
								lng_e7 : 1246050000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1279600000
							}
						}, {
							lo : {
								lat_e7 : 345000000,
								lng_e7 : 1279600000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1286700000
							}
						}, {
							lo : {
								lat_e7 : 348900000,
								lng_e7 : 1286700000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1293600000
							}
						}, {
							lo : {
								lat_e7 : 354690000,
								lng_e7 : 1293600000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1320034790
							}
						} ],
						uris : [
								"http://mt0.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt1.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt2.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt3.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26" ]
					},
					{
						maptype : 0,
						min_zoom : 10,
						max_zoom : 19,
						rect : [ {
							lo : {
								lat_e7 : 329890840,
								lng_e7 : 1246055600
							},
							hi : {
								lat_e7 : 386930130,
								lng_e7 : 1284960940
							}
						}, {
							lo : {
								lat_e7 : 344646740,
								lng_e7 : 1284960940
							},
							hi : {
								lat_e7 : 386930130,
								lng_e7 : 1288476560
							}
						}, {
							lo : {
								lat_e7 : 350277470,
								lng_e7 : 1288476560
							},
							hi : {
								lat_e7 : 386930130,
								lng_e7 : 1310531620
							}
						}, {
							lo : {
								lat_e7 : 370277730,
								lng_e7 : 1310531620
							},
							hi : {
								lat_e7 : 386930130,
								lng_e7 : 1320034790
							}
						} ],
						uris : [
								"http://mt0.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt1.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt2.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt3.gmaptiles.co.kr/mt/v=kr1.12\x26hl=pt-BR\x26src=api\x26" ]
					},
					{
						maptype : 3,
						min_zoom : 7,
						max_zoom : 7,
						rect : [ {
							lo : {
								lat_e7 : 330000000,
								lng_e7 : 1246050000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1293600000
							}
						}, {
							lo : {
								lat_e7 : 366500000,
								lng_e7 : 1297000000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1320034790
							}
						} ],
						uris : [
								"http://mt0.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt1.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt2.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt3.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26" ]
					},
					{
						maptype : 3,
						min_zoom : 8,
						max_zoom : 9,
						rect : [ {
							lo : {
								lat_e7 : 330000000,
								lng_e7 : 1246050000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1279600000
							}
						}, {
							lo : {
								lat_e7 : 345000000,
								lng_e7 : 1279600000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1286700000
							}
						}, {
							lo : {
								lat_e7 : 348900000,
								lng_e7 : 1286700000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1293600000
							}
						}, {
							lo : {
								lat_e7 : 354690000,
								lng_e7 : 1293600000
							},
							hi : {
								lat_e7 : 386200000,
								lng_e7 : 1320034790
							}
						} ],
						uris : [
								"http://mt0.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt1.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt2.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt3.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26" ]
					},
					{
						maptype : 3,
						min_zoom : 10,
						rect : [ {
							lo : {
								lat_e7 : 329890840,
								lng_e7 : 1246055600
							},
							hi : {
								lat_e7 : 386930130,
								lng_e7 : 1284960940
							}
						}, {
							lo : {
								lat_e7 : 344646740,
								lng_e7 : 1284960940
							},
							hi : {
								lat_e7 : 386930130,
								lng_e7 : 1288476560
							}
						}, {
							lo : {
								lat_e7 : 350277470,
								lng_e7 : 1288476560
							},
							hi : {
								lat_e7 : 386930130,
								lng_e7 : 1310531620
							}
						}, {
							lo : {
								lat_e7 : 370277730,
								lng_e7 : 1310531620
							},
							hi : {
								lat_e7 : 386930130,
								lng_e7 : 1320034790
							}
						} ],
						uris : [
								"http://mt0.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt1.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt2.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26",
								"http://mt3.gmaptiles.co.kr/mt/v=kr1p.12\x26hl=pt-BR\x26src=api\x26" ]
					} ],
			jsmain : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/250a/maps2.api/main.js",
			bcp47_language_code : "pt-BR",
			log_info_window_ratio : 0.0099999997764825821,
			log_fragment_count : 10,
			log_fragment_seed : 5,
			obliques_urls : [ "http://khmdb0.google.com/kh?v=29\x26",
					"http://khmdb1.google.com/kh?v=29\x26" ],
			token : 741952879,
			jsmodule_base_url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/250a/maps2.api",
			generic_tile_urls : [
					"http://mt0.google.com/vt?hl=pt-BR\x26src=api\x26",
					"http://mt1.google.com/vt?hl=pt-BR\x26src=api\x26" ]
		};
		var pageArgs = {};
		apiCallback(
				[
						"http://mt0.google.com/vt/lyrs\x3dm@130\x26hl\x3dpt-BR\x26src\x3dapi\x26",
						"http://mt1.google.com/vt/lyrs\x3dm@130\x26hl\x3dpt-BR\x26src\x3dapi\x26" ],
				[ "http://khm0.google.com/kh/v\x3d65\x26",
						"http://khm1.google.com/kh/v\x3d65\x26" ],
				[
						"http://mt0.google.com/vt/lyrs\x3dh@130\x26hl\x3dpt-BR\x26src\x3dapi\x26",
						"http://mt1.google.com/vt/lyrs\x3dh@130\x26hl\x3dpt-BR\x26src\x3dapi\x26" ],
				"ABQIAAAA7j_Q-rshuWkc8HyFI4V2HxQYPm-xtd00hTQOC0OXpAMO40FHAxT29dNBGfxqMPq5zwdeiDSHEPL89A",
				"",
				"",
				true,
				"google.maps.",
				opts,
				[
						"http://mt0.google.com/vt/lyrs\x3dt@125,r@130\x26hl\x3dpt-BR\x26src\x3dapi\x26",
						"http://mt1.google.com/vt/lyrs\x3dt@125,r@130\x26hl\x3dpt-BR\x26src\x3dapi\x26" ],
				jslinker, pageArgs);
		if (!callee.called) {
			callee.called = true;
		}
	}
})();
function GUnload() {
	if (window.GUnloadApi) {
		GUnloadApi();
	}
}
var _mIsRtl = false;
var _mF = [
		,
		,
		,
		,
		,
		20,
		4096,
		"bounds_cippppt.txt",
		"cities_cippppt.txt",
		"local/add/flagStreetView",
		true,
		,
		400,
		,
		,
		,
		,
		,
		,
		"/maps/c/ui/HovercardLauncher/dommanifest.js",
		,
		,
		,
		false,
		,
		,
		,
		,
		,
		,
		true,
		,
		,
		,
		,
		,
		,
		,
		"http://maps.google.com/maps/stk/fetch",
		0,
		,
		true,
		,
		,
		,
		true,
		,
		,
		,
		"http://maps.google.com/maps/stk/style",
		,
		"107485602240773805043.00043dadc95ca3874f1fa",
		,
		,
		false,
		1000,
		,
		"http://cbk0.google.com",
		false,
		,
		"ar,iw",
		,
		,
		,
		,
		,
		,
		,
		,
		"http://pagead2.googlesyndication.com/pagead/imgad?id\x3dCMKp3NaV5_mE1AEQEBgQMgieroCd6vHEKA",
		,
		,
		,
		,
		,
		false,
		,
		,
		,
		,
		"SS",
		"en,fr,ja",
		,
		,
		,
		,
		,
		,
		true,
		,
		,
		,
		,
		,
		true,
		,
		,
		,
		,
		"",
		"1",
		,
		false,
		false,
		,
		true,
		,
		,
		,
		"AU,BE,FR,NZ,US",
		,
		,
		,
		true,
		500,
		"http://chart.apis.google.com/chart?cht\x3dqr\x26chs\x3d80x80\x26chld\x3d|0\x26chl\x3d",
		,
		,
		,
		true,
		,
		,
		,
		,
		false,
		,
		,
		false,
		,
		true,
		,
		,
		true,
		,
		,
		,
		,
		,
		,
		,
		10,
		,
		true,
		true,
		,
		,
		,
		30,
		"infowindow_v1",
		"",
		false,
		true,
		22,
		'http://khm.google.com/vt/lbw/lyrs\x3dm\x26hl\x3dpt-BR\x26',
		'http://khm.google.com/vt/lbw/lyrs\x3ds\x26hl\x3dpt-BR\x26',
		'http://khm.google.com/vt/lbw/lyrs\x3dy\x26hl\x3dpt-BR\x26',
		'http://khm.google.com/vt/lbw/lyrs\x3dp\x26hl\x3dpt-BR\x26',
		,
		,
		false,
		"US,AU,NZ,FR,DK,MX,BE,CA,DE,GB,IE,PR,PT,RU,SG,JM,HK,TW,MY,TH,AT,CZ,CN,IN,KR",
		,
		,
		"windows-ie,windows-firefox,windows-chrome,macos-safari,macos-firefox,macos-chrome",
		true,
		false,
		20000,
		600,
		30,
		,
		,
		,
		,
		,
		false,
		false,
		,
		,
		"maps.google.com",
		,
		,
		,
		,
		"",
		true,
		,
		,
		,
		true,
		"4:http://gt%1$d.google.com/mt?v\x3dgwm.fresh\x26",
		"4:http://gt%1$d.google.com/mt?v\x3dgwh.fresh\x26",
		true,
		false,
		,
		,
		0.25,
		,
		"107485602240773805043.0004561b22ebdc3750300",
		,
		,
		,
		,
		false,
		,
		,
		true,
		,
		8,
		,
		,
		,
		,
		false,
		"https://cbks0.google.com",
		,
		true,
		,
		,
		,
		,
		,
		false,
		,
		,
		,
		,
		,
		,
		,
		false,
		,
		,
		true,
		true,
		false,
		,
		,
		,
		true,
		"http://mt0.google.com/vt/ft",
		false,
		,
		"http://chart.apis.google.com/chart",
		,
		,
		,
		,
		,
		,
		'0.25',
		false,
		,
		,
		,
		,
		false,
		,
		2,
		160,
		,
		,
		,
		true,
		false,
		,
		,
		,
		,
		,
		,
		45,
		true,
		,
		false,
		true,
		true,
		,
		,
		,
		true,
		false,
		false,
		,
		false,
		false,
		,
		false,
		,
		false,
		false,
		,
		,
		,
		,
		false,
		,
		,
		,
		,
		true,
		,
		"DE,CH,LI,AT,BE,PL,NL,HU,GR,HR,CZ,SK,TR,BR,EE,ES,AD,SE,NO,DK,FI,IT,VA,SM,IL,CL,MX,AR,BG,PT",
		false,
		,
		"25",
		true,
		25,
		"Home for sale",
		,
		false,
		,
		true,
		false,
		,
		false,
		"4:https://gt%1$d.google.com/mt?v\x3dgwm.fresh\x26",
		"4:https://gt%1$d.google.com/mt?v\x3dgwh.fresh\x26",
		,
		,
		,
		,
		"",
		,
		,
		false,
		true,
		,
		,
		,
		false,
		"1.x",
		,
		false,
		false,
		,
		,
		3000,
		false,
		true,
		,
		,
		,
		,
		false,
		,
		true,
		,
		,
		24,
		6,
		2,
		,
		,
		0,
		true,
		,
		,
		true,
		true,
		false,
		true,
		,
		,
		,
		false,
		,
		,
		false,
		,
		"/maps/c",
		true,
		100,
		1000,
		100,
		50,
		2,
		,
		,
		true,
		true,
		,
		false,
		,
		false,
		false,
		,
		5,
		5,
		true,
		"windows-firefox,windows-ie,windows-chrome,macos-firefox,macos-safari,macos-chrome",
		true, true, false, false, false, true, true, false, false, false,
		false, true, false, , false, false, false, false, false, false, false,
		false, false, false, false, false ];
var _mHost = "http://maps.google.com";
var _mUri = "/maps";
var _mDomain = "google.com";
var _mStaticPath = "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/";
var _mRelativeStaticPath = "/intl/pt-BR_ALL/mapfiles/";
var _mJavascriptVersion = G_API_VERSION = "250a";
var _mTermsUrl = "http://www.google.com/intl/pt-BR_ALL/help/terms_maps.html";
var _mLocalSearchUrl = "http://www.google.com/uds/solutions/localsearch/gmlocalsearch.js";
var _mHL = "pt-BR";
var _mGL = "";
var _mTrafficEnableApi = true;
var _mTrafficTileServerUrls = [ "http://mt0.google.com/mapstt",
		"http://mt1.google.com/mapstt", "http://mt2.google.com/mapstt",
		"http://mt3.google.com/mapstt" ];
var _mTrafficCameraLayerIds = [
		"msid:103669521412303283270.000470c7965f9af525967",
		"msid:111496436295867409379.00047329600bf6daab897" ];
var _mCityblockLatestFlashUrl = "http://maps.google.com/local_url?q=http://www.adobe.com/shockwave/download/download.cgi%3FP1_Prod_Version%3DShockwaveFlash&amp;dq=&amp;file=api&amp;v=2&amp;key=ABQIAAAA7j_Q-rshuWkc8HyFI4V2HxQYPm-xtd00hTQOC0OXpAMO40FHAxT29dNBGfxqMPq5zwdeiDSHEPL89A&amp;s=ANYYN7manSNIV_th6k0SFvGB4jz36is1Gg";
var _mCityblockFrogLogUsage = false;
var _mCityblockInfowindowLogUsage = false;
var _mCityblockDrivingDirectionsLogUsage = false;
var _mCityblockPrintwindowLogUsage = false;
var _mCityblockPrintwindowImpressionLogUsage = false;
var _mCityblockUseSsl = false;
var _mWizActions = {
	hyphenSep : 1,
	breakSep : 2,
	dir : 3,
	searchNear : 6,
	savePlace : 9
};
var _mIGoogleUseXSS = false;
var _mIGoogleEt = "4c46571dwIXC1EmM";
var _mIGoogleServerTrustedUrl = "";
var _mMMEnablePanelTab = true;
var _mIdcRouterPath = true;
var _mIGoogleServerUntrustedUrl = "http://maps.gmodules.com";
var _mMplGGeoXml = 100;
var _mMplGPoly = 100;
var _mMplMapViews = 100;
var _mMplGeocoding = 100;
var _mMplDirections = 100;
var _mMplEnableGoogleLinks = true;
var _mMSEnablePublicView = true;
var _mMSSurveyUrl = "";
var _mMMLogPanelLoad = true;
var _mSatelliteToken = "fzwq2uv-eBkjR-MAH3TbaguGMMHr1930a1i5JQ";
var _mMapCopy = "Dados cartogr�ficos \x26#169;2010";
var _mSatelliteCopy = "Imagens \x26#169;2010";
var _mGoogleCopy = "\x26#169;2010 Google";
var _mPreferMetric = false;
var _mMapPrintUrl = 'http://www.google.com/mapprint';
var _mSvgForced = true;
var _mLogPanZoomClks = false;
var _mSXBmwAssistUrl = '';
var _mSXCarEnabled = true;
var _mSXServices = {};
var _mSXPhoneEnabled = true;
var _mSXQRCodeEnabled = false;
var _mLyrcItems = [
		{
			label : "12102",
			layer_id : "com.panoramio.all",
			featurelet : {
				feature_id : "layers.panoramio",
				feature_url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/ftr/layers/panoramio.4.js"
			},
			available_in_3d : true
		},
		{
			label : "12103",
			layer_id : "com.youtube.all",
			featurelet : {
				feature_id : "layers.youtube",
				feature_url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/ftr/layers/youtube.0.js"
			},
			available_in_3d : true
		},
		{
			label : "12210",
			layer_id : "org.wikipedia.pt",
			available_in_3d : true
		},
		{
			label : "12953",
			layer_id : "com.google.webcams",
			featurelet : {
				feature_id : "layers.webcams",
				feature_url : "http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/ftr/layers/webcams.0.js"
			}
		}, {
			label : "13606",
			layer_id : "com.google.latitudepublicupdates",
			disable_hover : true
		} ];
var _mAttrInpNumMap = {
	'centena' : 100,
	'mil' : 1000,
	'k' : 1000,
	'dez mil' : 10000,
	'milh�o' : 1000000,
	'm' : 1000000,
	'bilh�o' : 1000000000,
	'b' : 1000000000
};
var _mMSMarker = 'Marcador de lugar';
var _mMSLine = 'Linha';
var _mMSPolygon = 'Pol�gono';
var _mMSImage = 'Imagem';
var _mDirectionsDragging = true;
var _mDirectionsEnableCityblock = true;
var _mDirectionsEnableApi = true;
var _mAdSenseForMapsEnable = "true";
var _mAdSenseForMapsFeedUrl = "http://pagead2.googlesyndication.com/afmaps/ads";
var _mReviewsWidgetUrl = "http://www.google.com/reviews/scripts/annotations_bootstrap.js?hl\x3dpt-BR\x26amp;gl\x3d";
var _mLayersTileBaseUrls = [ 'http://mt0.google.com/mapslt',
		'http://mt1.google.com/mapslt', 'http://mt2.google.com/mapslt',
		'http://mt3.google.com/mapslt' ];
var _mLayersFeaturesBaseUrl = "http://mt0.google.com/mapslt/ft";
var _mPerTileBase = "http://mt0.google.com/vt/pt";
function GLoadMapsScript() {
	if (!GLoadMapsScript.called && GBrowserIsCompatible()) {
		GLoadMapsScript.called = true;
		GScript("http://maps.gstatic.com/intl/pt-BR_ALL/mapfiles/250a/maps2.api/main.js");
	}
}
(function() {
	if (!window.google)
		window.google = {};
	if (!window.google.maps)
		window.google.maps = {};
	var ns = window.google.maps;
	ns.BrowserIsCompatible = GBrowserIsCompatible;
	ns.Unload = GUnload;
})();
GLoadMapsScript();
var _mObfuscatedGaiaId = "102663781752975665783";