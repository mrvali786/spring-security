package com.coderdot.controllers;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderdot.dto.ProductDto;
import com.coderdot.services.ProductService;
import com.coderdott.handler.BroadcastHandler;

@RestController
@RequestMapping("/product")
//@RequiredArgsConstructor
public class ProductController {
	@Autowired
	private   ProductService productService;
//	 private final SimpMessagingTemplate messagingTemp;
	@Autowired
	private  BroadcastHandler broadcastHandler;

	@GetMapping("/list")
	public ResponseEntity<List<ProductDto>> list() {
		return ResponseEntity.ok(productService.list());
	}
	
	

   
	@Scheduled(fixedRate = 1000)
	public void broadcast() throws JSONException {
		 JSONObject responseDetailsJson = new JSONObject();
		    JSONArray jsonArray = new JSONArray();

		    List<ProductDto> cartList =productService.list();
		    for(ProductDto p : cartList) {
		    
		        JSONObject formDetailsJson = new JSONObject();
		        formDetailsJson.put("id", p.getId());
		        formDetailsJson.put("name", p.getName());
		        formDetailsJson.put("price", p.getPrice());
		        formDetailsJson.put("orderDate", p.getOrderDate());
		       jsonArray.put(formDetailsJson);
		    }
		    responseDetailsJson.put("data", jsonArray);
		    String s = responseDetailsJson.toString();

		broadcastHandler.broadcast(s);
		//messagingTemp.convertAndSend(s);
	}
}
