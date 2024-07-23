package com.coderdot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;

import com.coderdott.handler.AlarmWebSocketHandler;
import com.coderdott.handler.BroadcastHandler;


@Configuration
@EnableWebSocket

@EnableScheduling
public class WebSocketConfiguration   implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler(), "/dashboard").setAllowedOriginPatterns("*")

				 .setAllowedOrigins("http://localhost:4200")

				.withSockJS();

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}


	@Bean
	public WebSocketHandler webSocketHandler() {
		return new PerConnectionWebSocketHandler(AlarmWebSocketHandler.class);

	}

	@Bean
	public BroadcastHandler createBroadcastHandler() {
		return new BroadcastHandler();
	}

}
