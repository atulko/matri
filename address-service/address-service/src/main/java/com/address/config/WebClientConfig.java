package com.address.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Autowired
	private LoadBalancedExchangeFilterFunction filterFuntion;

	@Bean
	public WebClient brideWebClient() {
		return WebClient.builder().baseUrl("http://bride-service").filter(filterFuntion).build();
	}


}
