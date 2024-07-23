package com.coderdot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.coderdott.handler.BroadcastHandler;

/*@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
public class WebSocketMessageBrokerConfiguration implements WebSocketMessageBrokerConfigurer {

	@Bean
	public BroadcastHandler createBroadcastHandler() {
		return new BroadcastHandler();
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/trends-stomp").setAllowedOrigins("*");
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app");
		config.enableSimpleBroker("/queue");
	}

}*/
