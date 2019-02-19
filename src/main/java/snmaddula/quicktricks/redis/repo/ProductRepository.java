package snmaddula.quicktricks.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import snmaddula.quicktricks.redis.entity.Product;

/**
 * 
 * @author snmaddula
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
