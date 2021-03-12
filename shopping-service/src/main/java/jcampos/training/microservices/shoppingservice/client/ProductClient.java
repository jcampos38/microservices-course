package jcampos.training.microservices.shoppingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jcampos.training.microservices.shoppingservice.model.Product;

@FeignClient(name = "product-service")
@RequestMapping(value = "/products")
public interface ProductClient {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);
	
	@PutMapping(value = "/{id}/stock" )
	public ResponseEntity<Product> updateStock(@PathVariable("id") Long id, @RequestParam(name = "quantity") Double quantity);

}
