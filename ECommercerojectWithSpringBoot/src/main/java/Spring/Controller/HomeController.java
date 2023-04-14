package Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Spring.Service.CategoryService;
import Spring.Service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping({"/","/home"})
	public String home(Model model)
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String register(Model model)
	{
		return "register";
	}
	
//	@GetMapping("/shop/viewProduct/{id}")
//	public String view(@PathVariable int id,Model model )
//	{
//		model.addAttribute("product", productService.getaAllProductByCategoryId(id).get(id));
//		return "viewProduct";
//	}
	
	
	
	@GetMapping("/shop")
	public String shop(Model model)
	{
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProduct());
		return "shop";
	}

}
