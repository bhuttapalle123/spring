package Spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring.Model.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

	
}
