package com.coderdott.handler;

import java.io.IOException;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.RequiredArgsConstructor;



@Component
@RequiredArgsConstructor
public class AlarmWebSocketHandler extends TextWebSocketHandler {
	
    private final BroadcastHandler broadcastHandler;
    
   
   

   

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	broadcastHandler.add(session);
        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        broadcastHandler.remove(session);
        super.afterConnectionClosed(session, status);
    }

   
    @Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {

    	System.out.println("1111111111111111111");
	//	String payload = message.getPayload();
	//	JSONObject jsonObject = new JSONObject(payload);
	//	session.sendMessage(new TextMessage("Hi " + jsonObject.get("user") + " how may we help you?"));
	}
}
