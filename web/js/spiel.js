/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var tmpImgIdGelegteKarte;
var webSocketKartelegen;
var kommtRaus;
var serverURLKartelegen = "ws://" + window.location.hostname + ":8080/Doppelkopf/websocket/kartelegen";

function karteWurdeGelegt(event) {
    var jsonSpielerKarte = JSON.parse(event.data);
    if(jsonSpielerKarte.user == $('#senderUsername').text()){
        $('#imgKarteUnten')[0].src = jsonSpielerKarte.bildpfad;
        $('#'+tmpImgIdGelegteKarte)[0].src = "bilder/rahmen.jpg";
    }
    if(jsonSpielerKarte.user == spielerLinks){
        $('#imgKarteLinks')[0].src = jsonSpielerKarte.bildpfad;
    }
    if(jsonSpielerKarte.user == spielerRechts){
        $('#imgKarteRechts')[0].src = jsonSpielerKarte.bildpfad;
    }
    if(jsonSpielerKarte.user == spielerOben){
        $('#imgKarteOben')[0].src = jsonSpielerKarte.bildpfad;
    }
}

$(document).ready(function() {
    webSocketKartelegen = new WebSocket(serverURLKartelegen);
    webSocketKartelegen.onmessage = karteWurdeGelegt;    
})

function legeKarte(kartenId, bildpfad, imgIdGelegteKarte){
    var aktuellesBild = $('#imgKarteUnten')[0].src.substring($('#imgKarteUnten')[0].src.length-10,$('#imgKarteUnten')[0].src.length); 
    var aktuellesBildRechts = $('#imgKarteRechts')[0].src.substring($('#imgKarteRechts')[0].src.length-10,$('#imgKarteRechts')[0].src.length);
    if(aktuellesBildRechts != "rahmen.jpg" || kommtRaus == $('#senderUsername').text()){
        if(aktuellesBild == "rahmen.jpg"){
            var socketMsg = '{"user":"' + $('#senderUsername').text() +'", "kartenId":"' + kartenId + '", "bildpfad":"'+ bildpfad +'"}';
            webSocketKartelegen.send(socketMsg);
            tmpImgIdGelegteKarte = imgIdGelegteKarte;
        }
    }
    
}


