/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var spielerLinks;
var spielerOben;
var spielerRechts;
var eigenerPlatz;

var webSocketSpielerverwaltung;
var serverURLSpielerverwaltung = "ws://" + window.location.hostname + ":8080/Doppelkopf/websocket/spielerverwaltung";

function serverUpdateSpieler(event) {
    var msg = JSON.parse(event.data);
    spielerUpdate(msg.Spieler0, msg.Spieler1, msg.Spieler2, msg.Spieler3);
}

$(document).ready(function() {
    $username = $('#senderUsername').text();
    $platz = $('#eigenerPlatz').text();
    webSocketSpielerverwaltung = new WebSocket(serverURLSpielerverwaltung);
    webSocketSpielerverwaltung.onmessage = serverUpdateSpieler;    
})

function spielerUpdate(spieler0, spieler1, spieler2, spieler3){
    if($platz==0){
        spielerLinks = spieler1;
        spielerOben = spieler2;
        spielerRechts = spieler3;
    }
    if($platz==1){
        spielerLinks = spieler2;
        spielerOben = spieler3;
        spielerRechts = spieler0;
    }
    if($platz==2){
        spielerLinks = spieler3;
        spielerOben = spieler0;
        spielerRechts = spieler1;
    }
    if($platz==3){
        spielerLinks = spieler0;
        spielerOben = spieler1;
        spielerRechts = spieler2;
    }
    if(spielerOben != ""){
       document.getElementById('pSpielerOben').innerHTML = spielerOben;
    }
    if(spielerLinks != ""){
        document.getElementById('pSpielerLinks').innerHTML = spielerLinks;
    }
    if(spielerRechts != ""){
        document.getElementById('pSpielerRechts').innerHTML = spielerRechts;
    }
}
