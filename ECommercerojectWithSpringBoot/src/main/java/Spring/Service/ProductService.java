package Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Spring.Model.Category;
import Spring.Model.Product;
import Spring.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct(){
		return productRepository .findAll();
	}

	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void removeProductById(Long id) {
		productRepository.deleteById(id);
	}
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
	}

//	public List<Category> getaAllProductByCategoryId(int id) {
//		
//		return productRepository.findAllById(id);
//	}
	
	
}
