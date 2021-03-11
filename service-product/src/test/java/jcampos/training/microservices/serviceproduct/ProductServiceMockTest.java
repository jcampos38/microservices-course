package jcampos.training.microservices.serviceproduct;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import jcampos.training.microservices.serviceproduct.entity.Category;
import jcampos.training.microservices.serviceproduct.entity.Product;
import jcampos.training.microservices.serviceproduct.repository.ProductRepository;
import jcampos.training.microservices.serviceproduct.service.ProductService;
import jcampos.training.microservices.serviceproduct.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceMockTest {
	
	@Mock
	private ProductRepository productRepository;
	
	private ProductService productService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		productService = new ProductServiceImpl(productRepository);
		
		Product computer = Product.builder()
				.id(1L)
				.name("computer")
				.category(Category.builder().id(1L).build())
				.price(Double.parseDouble("12.5"))
				.stock(Double.parseDouble("5")).build();
		
		Mockito.when(productRepository.findById(1L))
				.thenReturn(Optional.of(computer));
		
		Mockito.when(productRepository.save(computer))
				.thenReturn(computer);
				
	}

	@Test
	public void whenValidGetId_ThenReturnProduct() {
		Product found = productService.getProduct(1L);
		Assertions.assertThat(found.getName()).isEqualTo("computer");
	}
	
	@Test
	public void whenValidUpdateStock_ThenReturnNewStock() {
		Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
		
		Assertions.assertThat(newStock.getStock()).isEqualTo(Double.parseDouble("13"));
		
	}
}
