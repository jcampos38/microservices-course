package jcampos.training.microservices.serviceproduct.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import jcampos.training.microservices.serviceproduct.entity.Category;
import jcampos.training.microservices.serviceproduct.entity.Product;
import jcampos.training.microservices.serviceproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	@Override
	public List<Product> listAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		product.setStatus("Created");
		product.setCreateAt(new Date());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product productDb = getProduct(product.getId());
		
		if (null == productDb)
			return null;
		
		productDb.setName(productDb.getName());
		productDb.setDescription(productDb.getDescription());
		productDb.setCategory(productDb.getCategory());
		productDb.setPrice(productDb.getPrice());
		return productRepository.save(productDb);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product productDb = getProduct(id);
		
		if (null == productDb)
			return null;
		
		productDb.setStatus("DELETED");
		
		return productRepository.save(productDb);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public Product updateStock(Long id, Double quantity) {
		Product productDb = getProduct(id);
		
		if (null == productDb)
			return null;
		
		productDb.setStock(productDb.getStock() + quantity);
		return productRepository.save(productDb);
	}

}
