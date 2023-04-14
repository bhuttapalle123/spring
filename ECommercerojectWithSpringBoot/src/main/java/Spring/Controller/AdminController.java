package Spring.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import Spring.Model.Category;
import Spring.Model.Product;
import Spring.Service.CategoryService;
import Spring.Service.ProductService;
import Spring.dto.productDTO;





@Controller
public class AdminController {
	
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/admin")
	public String adminhome()
	{
		return "adminHome";
	}
	
	@GetMapping("/admin/categories")
	public String cat( Model model)
	{
	
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String catadd(Model model)
	{
		model.addAttribute("category", new Category( ) );
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postcatadd(@ModelAttribute("category") Category category)
	{
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deletcat(@PathVariable int id)
	{
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
		
	}
	
	
	
	@GetMapping("/admin/categories/update/{id}") 
	  public String updatecat(@PathVariable int id, Model model) 
		{
		  Optional<Category> category=categoryService.getCategoryById(id);
		  if(category.isPresent()) 
		  {
			  model.addAttribute("category",category.get());  
		  }
		  else 
		  {
			return "404";
		  }
		  return "categoriesAdd";
		}
	
	//product section start
	
	@GetMapping("/admin/products")
	public String deletcat(Model model)
	{
		model.addAttribute("products",productService.getAllProduct() );
		return "products";
	}

	@GetMapping("/admin/products/add")
	public String prductadd(Model model)
	{
		System.out.println("hii");
		model.addAttribute("productDTO", new  productDTO()) ;
		model.addAttribute("categories", categoryService.getAllCategory());
		return "productsAdd";
	}
	
	@PostMapping("/admin/products/add")
	public String postSave(@ModelAttribute("products") Product products)
	{
		productService.addProduct(products);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String deletproduct(@PathVariable Long id)
	{
		productService.removeProductById(id);
		return "redirect:/admin/products";
		
	}
	
	@GetMapping("/admin/product/update/{id}") 
	  public String updateProduct(@PathVariable Long id, Model model) 
		{
		Optional<Product> product=productService.getProductById(id);
		  if(product.isPresent()) 
		  {
			  model.addAttribute("product",product.get());  
		  }
		  else 
		  {
			return "404";
		  }
		  return "productsAdd";
		}
	
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	}


