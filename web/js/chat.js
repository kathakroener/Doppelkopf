/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var webSocketChat;
var serverURLChat = "ws://" + window.location.hostname + ":8080/Doppelkopf/websocket/chat";

function sendeNachricht() {
    var msg = '{"text":"' + $('#inputChatEingabe').val() + '", "sender":"'
                + username + '", "received":""}';
    webSocketChat.send(msg);
    $('#inputChatEingabe').val('').focus();
}

function empfangeNachricht(evt) {
    var msg = JSON.parse(evt.data);
    var chatNachricht = $('<tr style=\"width:100%\"><td style:\"align:left\">' + msg.empfangen
				+ ' </td><td style:\"align:center\"> ' + msg.sender
				+ ': </td><td style:\"align:right\"> ' + msg.text
				+ '</td></tr>');
    var chatVerlauf = $('#chatVerlauf');
    $('#chatVerlauf').append(chatNachricht);
    if(chatVerlauf.length){
        chatVerlauf.scrollTop(chatVerlauf[0].scrollHeight - chatVerlauf.height());
    }
}

$(document).ready(function() {
    username = $('#senderUsername').text();
    webSocketChat = new WebSocket(serverURLChat);
    webSocketChat.onmessage = empfangeNachricht;  
})
