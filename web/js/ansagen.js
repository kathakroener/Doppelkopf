/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var webSocketAnsage;
var kommtRaus;
var serverURLAnsagen = "ws://" + window.location.hostname + ":8080/Doppelkopf/websocket/ansage";

function empfangeAnsage(jsonAnsage) {
    var ansageObject = JSON.parse(jsonAnsage.data);

    $('#chatVerlauf').append('<tr style=\"width:100%, font-color:green;\"><td>'+ansageObject.ansage+'</td></tr>');
    
    if(ansageObject.ansage == $('#buttonAnsage')[0].innerHTML){
        if(ansageObject.ansage == "Re"){
            $('#buttonAnsage')[0].innerHTML = "Re Keine 90";
        }
        if(ansageObject.ansage == "Re Keine 90"){
            $('#buttonAnsage')[0].innerHTML = "Re Keine 60";
        }
        if(ansageObject.ansage == "Re Keine 60"){
            $('#buttonAnsage')[0].innerHTML = "Re Keine 30";
        }
        if(ansageObject.ansage == "Re Keine 30"){
            $('#buttonAnsage')[0].innerHTML = "Re Schwarz";
        }
        if(ansageObject.ansage == "Re Schwarz"){
            $('#buttonAnsage')[0].disabled = true;
        }
        if(ansageObject.ansage == "Contra"){
            $('#buttonAnsage')[0].innerHTML = "Contra Keine 90";
        }
        if(ansageObject.ansage == "Contra Keine 90"){
            $('#buttonAnsage')[0].innerHTML = "Contra Keine 60";
        }
        if(ansageObject.ansage == "Contra Keine 60"){
            $('#buttonAnsage')[0].innerHTML = "Contra Keine 30";
        }
        if(ansageObject.ansage == "Contra Keine 30"){
            $('#buttonAnsage')[0].innerHTML = "Contra Schwarz";
        }
        if(ansageObject.ansage == "Contra Schwarz"){
            $('#buttonAnsage')[0].disabled = true;
        }
    }
}

$(document).ready(function() {
    webSocketAnsage = new WebSocket(serverURLAnsagen);
    webSocketAnsage.onmessage = empfangeAnsage;    

    $('#buttonAnsage').click(function(evt) {
        sendeAnsage(evt);
    });
})

function sendeAnsage(evt){
    var jsonAnsage = '{"ansage":"' + evt.target.innerHTML + '", "username":"'+ username +'"}';
    webSocketAnsage.send(jsonAnsage);
}