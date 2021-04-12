package com.platzi.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://localhost:8090/platzi-market/api/products/all

// fix a Field mapper in com.platzi.market.persistence.ProductoRepository required a bean of type 'com.platzi.market.persistence.mapper.ProductMapper' that could not be found.
//@SpringBootApplication(scanBasePackages={"com.platzimarket.persistence.mapper.ProductMapper"})
@SpringBootApplication
public class PlatziMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatziMarketApplication.class, args);
	}

}
