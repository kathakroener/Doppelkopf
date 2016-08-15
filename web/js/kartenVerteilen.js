/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var bereit = false;
var webSocketKartenverteilen;
var serverURLKartenverteilen = "ws://" + window.location.hostname + ":8080/Doppelkopf/websocket/kartenverteilen";

function kartenverteilen(event) {
    bereit = false;
    var karten = JSON.parse(event.data);
    zeigeKarten(karten[eigenerPlatz]);
    kommtRaus = karten.kommtRaus;
}

$(document).ready(function() {
    webSocketKartenverteilen = new WebSocket(serverURLKartenverteilen);
    webSocketKartenverteilen.onmessage = kartenverteilen;    
})

function bereitZumSpielen(){
    if(bereit == false){
        breit = true;
        var msg = 'bereit';
        webSocketKartenverteilen.send(msg);
    }
}

function zeigeKarten(listKarten){
    for(var i = 0; i < 10; i++){
        var linkLegeKarte = "javascript:legeKarte('" + listKarten[i].id +"','"+ listKarten[i].bildpfad + "','"+ "eigeneKarte"+i +"');";
        document.getElementById("linkEigeneKarte"+i).href = linkLegeKarte;
        document.getElementById("eigeneKarte"+i).src = listKarten[i].bildpfad;
    }
}