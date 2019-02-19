package snmaddula.quicktricks.redis.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import snmaddula.quicktricks.redis.entity.Product;
import snmaddula.quicktricks.redis.repo.ProductRepository;

/**
 * 
 * @author snmaddula
 *
 */
@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepo;

	public Product getProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	public Product updateProduct(Product product) {
		if(productRepo.existsById(product.getId())) {
			return productRepo.save(product);
		}
		return null;
	}

	public void deleteProductById(Long id) {
		productRepo.deleteById(id);
	}

	public void deleteAllProducts() {
		productRepo.deleteAllInBatch();
	}
}
