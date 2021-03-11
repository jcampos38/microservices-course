package jcampos.training.microservices.serviceproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jcampos.training.microservices.serviceproduct.entity.Category;
import jcampos.training.microservices.serviceproduct.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findByCategory(Category category);
	
}
