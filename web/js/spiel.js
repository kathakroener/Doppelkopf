/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var tmpImgIdGelegteKarte;
var webSocketKartelegen;
var kommtRaus;
var serverURLKartelegen = "ws://" + window.location.hostname + ":8080/Doppelkopf/websocket/kartelegen";
var istRe;
var istKontra;

function serverNachricht(event) {
    var jsonObjectServer = JSON.parse(event.data);
    if(jsonObjectServer.rundenAuswertung == true){
        rundenAuswertung(jsonObjectServer);
    }else{
        karteWurdeGelegt(jsonObjectServer);
    }
}

$(document).ready(function() {
    webSocketKartelegen = new WebSocket(serverURLKartelegen);
    webSocketKartelegen.onmessage = serverNachricht;  
    istKontra = false;
    istRe = false;
})

function legeKarte(kartenId, bildpfad, imgIdGelegteKarte){
    var aktuellesBild = $('#imgKarteUnten')[0].src.substring($('#imgKarteUnten')[0].src.length-10,$('#imgKarteUnten')[0].src.length); 
    var aktuellesBildRechts = $('#imgKarteRechts')[0].src.substring($('#imgKarteRechts')[0].src.length-10,$('#imgKarteRechts')[0].src.length);
    
    var aktuellesBildOben = $('#imgKarteOben')[0].src.substring($('#imgKarteOben')[0].src.length-10,$('#imgKarteOben')[0].src.length);
    var aktuellesBildLinks = $('#imgKarteLinks')[0].src.substring($('#imgKarteLinks')[0].src.length-10,$('#imgKarteLinks')[0].src.length);
    
    if(aktuellesBildRechts != "rahmen.jpg" || kommtRaus == $('#senderUsername').text()){
        if(aktuellesBild == "rahmen.jpg" 
        || (aktuellesBild != "rahmen.jpg" 
            && aktuellesBildLinks != "rahmen.jpg" 
            && aktuellesBildRechts != "rahmen.jpg"
            && aktuellesBildOben != "rahmen.jpg"
            && kommtRaus == $('#senderUsername').text()
        )){
            var socketMsg = '{"user":"' + $('#senderUsername').text() +'", "kartenId":"' + kartenId + '", "bildpfad":"'+ bildpfad +'"}';
            webSocketKartelegen.send(socketMsg);
            tmpImgIdGelegteKarte = imgIdGelegteKarte;
            }
    }
}

function rundenAuswertung(jsonObject){
    var punkteRe = jsonObject.auswertungRunde.punkteRe;
    $('#modalTableZellePunkteRe')[0].innerHTML = punkteRe;
    var punkteContra = jsonObject.auswertungRunde.punkteContra;
    $('#modalTableZellePunkteContra')[0].innerHTML = punkteContra;
    
    var reKeine120 = jsonObject.auswertungRunde.reKeine120;
    $('#modalTableZelleKeine120Re')[0].innerHTML = reKeine120;
    var contraKeine120 = jsonObject.auswertungRunde.contraKeine120;
    $('#modalTableZelleKeine120Contra')[0].innerHTML = contraKeine120;
    
    var reKeine90 = jsonObject.auswertungRunde.reKeine90;
    $('#modalTableZelleKeine90Re')[0].innerHTML = reKeine90;
    var contraKeine90 = jsonObject.auswertungRunde.contraKeine90;
    $('#modalTableZelleKeine90Contra')[0].innerHTML = contraKeine90;
    
    var reKeine60 = jsonObject.auswertungRunde.reKeine60;
    $('#modalTableZelleKeine60Re')[0].innerHTML = reKeine60;
    var contraKeine60 = jsonObject.auswertungRunde.contraKeine60;
    $('#modalTableZelleKeine60Contra')[0].innerHTML = contraKeine60;
    
    var reKeine30 = jsonObject.auswertungRunde.reKeine30;
    $('#modalTableZelleKeine30Re')[0].innerHTML = reKeine30;
    var contraKeine30 = jsonObject.auswertungRunde.contraKeine30;
    $('#modalTableZelleKeine30Contra')[0].innerHTML = contraKeine30;
    
    var reSchwarz = jsonObject.auswertungRunde.reSchwarz;
    $('#modalTableZelleSchwarzRe')[0].innerHTML = reSchwarz;
    var contraSchwarz = jsonObject.auswertungRunde.contraSchwarz;
    $('#modalTableZelleSchwarzContra')[0].innerHTML = contraSchwarz;
    
    var reCharlieAmEnde = jsonObject.auswertungRunde.reCharlieAmEnde;
    $('#modalTableZelleCharlieAmEndeRe')[0].innerHTML = reCharlieAmEnde;
    var contraCharlieAmEnde = jsonObject.auswertungRunde.contraCharlieAmEnde;
    $('#modalTableZelleCharlieAmEndeContra')[0].innerHTML = contraCharlieAmEnde;
    
    var reDoppelKopf = jsonObject.auswertungRunde.reDoppelKopf;
    $('#modalTableZelleDoppelkopfRe')[0].innerHTML = reDoppelKopf;
    var contraDoppelkopf = jsonObject.auswertungRunde.contraDoppelkopf;
    $('#modalTableZelleDoppelkopfContra')[0].innerHTML = contraDoppelkopf;
    
    var reFuchsGefangen = jsonObject.auswertungRunde.reFuchsGefangen;
    $('#modalTableZelleFuchsGefangenRe')[0].innerHTML = reFuchsGefangen;
    var contraFuchsGefangen = jsonObject.auswertungRunde.contraFuchsGefangen;
    $('#modalTableZelleFuchsGefangenContra')[0].innerHTML = contraFuchsGefangen;
    
    var reGesamt = jsonObject.auswertungRunde.reGesamt;
    $('#modalTableZelleGesamtTackenRe')[0].innerHTML = reGesamt;
    var contraGesamt = jsonObject.auswertungRunde.contraGesamt;
    $('#modalTableZelleGesamtTackenContra')[0].innerHTML = contraGesamt;
    
    $('#modalRundenErgebnis').modal({
        backdrop: 'static',
        keyboard: false
    })
    $('#modalRundenErgebnis').modal('show');
}

function karteWurdeGelegt(jsonSpielerKarte){
    if(jsonSpielerKarte.user == kommtRaus){
        $('#imgKarteOben')[0].src = "bilder/rahmen.jpg";
        $('#imgKarteRechts')[0].src = "bilder/rahmen.jpg";
        $('#imgKarteUnten')[0].src = "bilder/rahmen.jpg";
        $('#imgKarteLinks')[0].src = "bilder/rahmen.jpg";
    } 
    if(jsonSpielerKarte.user == $('#senderUsername').text()){
        $('#imgKarteUnten')[0].src = jsonSpielerKarte.bildpfad;
        $('#'+tmpImgIdGelegteKarte)[0].src = "bilder/rahmen.jpg";
        $('#'+tmpImgIdGelegteKarte)[0].href = "#";
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
    if(jsonSpielerKarte.stichGehoert != ""){   
        kommtRaus = jsonSpielerKarte.stichGehoert;
        noty({text: 'Der Stich geht an ' + kommtRaus + '. Nun kommt ' + kommtRaus + ' raus!', type: 'information'});
    }
}


