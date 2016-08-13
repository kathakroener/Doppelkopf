/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var webSocket;
var serverURL = "ws://localhost:8080/Doppelkopf/websocket/chat";

function sendMessage() {
    var msg = '{"text":"' + $(inputChatEingabe).val() + '", "sender":"'
                + $username + '", "received":""}';
    webSocket.send(msg);
    $(inputChatEingabe).val('').focus();
}

function onMessageReceived(evt) {
    var msg = JSON.parse(evt.data);
    var $messageLine = $('<tr style=\"width:100%\"><td>' + msg.empfangen
				+ ' </td><td> ' + msg.sender
				+ ': </td><td> ' + msg.text
				+ '</td></tr>');
    $('#chatVerlauf').append($messageLine);
}

$(document).ready(function() {
    $username = $('#senderUsername').text();
    webSocket = new WebSocket(serverURL);
    webSocket.onmessage = onMessageReceived;
    
    $('#buttonSendMessage').click(function(evt) {
        sendMessage();
    }); 
    
})
