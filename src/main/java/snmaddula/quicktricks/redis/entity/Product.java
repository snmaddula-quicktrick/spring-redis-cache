package snmaddula.quicktricks.redis.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 * @author snmaddula
 *
 */
@Data
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String title;
	private String description;
	private Double price;
}
