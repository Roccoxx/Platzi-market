package com.platzi.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;

@Service // anotacion de spring (permite el autowired y es mas especifica que componnent)
public class ProductService {
	@Autowired // a pesar de no ser un componente de spring productorepository que es su implementacion lo es.
	private ProductRepository productRepository;
	
	public List<Product>getAll(){
		return productRepository.getAll();
	}
	
	public Optional<Product> getProduct(int productId){
		return productRepository.getProduct(productId);
	}
	
	public Optional<List<Product>> getByCategory(int categoryId){
		return productRepository.getByCategory(categoryId);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public boolean delete(int productId) {
		return getProduct(productId).map(product -> {
			productRepository.delete(productId);
			return true;
			}
		).orElse(false);
		
		/* Otra forma (para mi es mas legible pero con el map nos ahorramos el llamado al if y al else)
		 	if(getProduct(productId).isPresent()) {
			productRepository.delete(productId);
			return true;
		}
		else return false;
		 */
	}
}
