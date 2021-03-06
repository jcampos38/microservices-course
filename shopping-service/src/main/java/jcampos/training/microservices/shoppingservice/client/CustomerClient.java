package jcampos.training.microservices.shoppingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jcampos.training.microservices.shoppingservice.model.Customer;

@FeignClient(name = "customer-service", fallback = CustomerFallbackFactory.class)
//@RequestMapping("/customers")
public interface CustomerClient {
	
	@GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

}
