package com.memoire.benapay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@SpringBootApplication
public class BenapayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenapayApplication.class, args);
	}


    @Bean
    public WebClient webClient() {
		final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();
		WebClient webClient = WebClient
		.builder()
		.baseUrl("http://10.201.10.28:8280/MerchantPaymentUAT/1.0")
		.exchangeStrategies(strategies)
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.build();
		return webClient;
    }

}
