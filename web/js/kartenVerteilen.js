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
    zeigeAnsagenButton(karten.spielerRe, karten.spielerContra)
    kommtRaus = karten.kommtRaus;
    noty({text: 'Die Runde geht los. ' + kommtRaus + ' kommt raus!', type: 'information'});
}

$(document).ready(function() {
    webSocketKartenverteilen = new WebSocket(serverURLKartenverteilen);
    webSocketKartenverteilen.onmessage = kartenverteilen;  
    
    $('#buttonModalNaechsteRunde').click(function(evt) {
        bereitZumSpielen();
    }); 
    $('#buttonModalLogout').click(function(evt) {
       $('#buttonLogout').click();
    }); 
})

function bereitZumSpielen(){
    if(bereit == false){
        bereit = true;
        var msg = 'bereit';
        webSocketKartenverteilen.send(msg);
    }
}

function zeigeKarten(listKarten){
    $('#imgKarteOben')[0].src = "bilder/rahmen.jpg";
    $('#imgKarteRechts')[0].src = "bilder/rahmen.jpg";
    $('#imgKarteUnten')[0].src = "bilder/rahmen.jpg";
    $('#imgKarteLinks')[0].src = "bilder/rahmen.jpg";
    for(var i = 0; i < 10; i++){
        var linkLegeKarte = "javascript:legeKarte('" + listKarten[i].id +"','"+ listKarten[i].bildpfad + "','"+ "eigeneKarte"+i +"');";
        document.getElementById("linkEigeneKarte"+i).href = linkLegeKarte;
        document.getElementById("eigeneKarte"+i).src = listKarten[i].bildpfad;
    }
}

function zeigeAnsagenButton(listSpielerRe, listSpielerContra){
    for(var i = 0; i < listSpielerRe.length; i++){
        if(listSpielerRe[i].name == username){
            $('#buttonAnsage')[0].innerHTML = "Re";
            $('#buttonAnsage')[0].disabled = false;
        }
    }
    for(var i = 0; i < listSpielerContra.length; i++){
        if(listSpielerContra[i].name == username){
            $('#buttonAnsage')[0].innerHTML = "Contra";
            $('#buttonAnsage')[0].disabled = false;
        }
    }
}