package snmaddula.quicktricks.redis.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import snmaddula.quicktricks.redis.entity.Product;
import snmaddula.quicktricks.redis.service.ProductService;

/**
 * A simple Product entity
 * 
 * @author snmaddula
 *
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService service;

	@GetMapping("{id}")
	@Cacheable(value = "product-single", key = "#id")
	public Product getProductById(@PathVariable Long id) {
		return service.getProductById(id);
	}
	
	@PostMapping
	@CachePut(value = "product-single", key = "#product.id")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@PutMapping
	@CachePut(value = "product-single", key = "#product.id")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("{id}")
	@CacheEvict(value = "product-single", key = "#id")
	public void deleteProductById(@PathVariable Long id) {
		service.deleteProductById(id);
	}
	
	@DeleteMapping
	@CacheEvict(value = "product-single", allEntries = true)
	public void deleteAllProducts() {
		service.deleteAllProducts();
	}
}
