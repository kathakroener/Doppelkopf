/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var webSocketChat;
var serverURLChat = "ws://" + window.location.hostname + ":8080/Doppelkopf/websocket/chat";

function sendMessage() {
    var msg = '{"text":"' + $(inputChatEingabe).val() + '", "sender":"'
                + $username + '", "received":""}';
    webSocketChat.send(msg);
    $(inputChatEingabe).val('').focus();
}

function onChatMessageReceived(evt) {
    var msg = JSON.parse(evt.data);
    var $messageLine = $('<tr style=\"width:100%\"><td>' + msg.empfangen
				+ ' </td><td> ' + msg.sender
				+ ': </td><td> ' + msg.text
				+ '</td></tr>');
    $('#chatVerlauf').append($messageLine);
}

$(document).ready(function() {
    $username = $('#senderUsername').text();
    webSocketChat = new WebSocket(serverURLChat);
    webSocketChat.onmessage = onChatMessageReceived;
    
    $('#buttonSendMessage').click(function(evt) {
        sendMessage();
    }); 
    
})
