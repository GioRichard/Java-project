package com.abc.buoi2.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.abc.buoi2.controller.user.BaseController;
import com.abc.buoi2.dto.ProductSearch;
import com.abc.buoi2.entities.Categories;
import com.abc.buoi2.entities.Product;
import com.abc.buoi2.services.CategoriesService;
import com.abc.buoi2.services.ProductService;

@Controller
public class managerProductController extends BaseController {
	
	//inject mot bean(service) vao trong 1 bean khac (controller)
		@Autowired
		private CategoriesService categoriesService;
		
		@Autowired
		private  ProductService productService;

		@RequestMapping(value = { "/manager/list_products" }, method = RequestMethod.GET) // --> action
		public String listProduct(final Model model, final HttpServletRequest request, final HttpServletResponse response)
				throws IOException {
			
			int page = getCurrentPage(request);
			
			
			String keyword = request.getParameter("keyword");
			ProductSearch ps = new ProductSearch();
			ps.setKeyword(keyword);
			ps.setPage(getCurrentPage(request));
			
			model.addAttribute("products",productService.search(ps));
			return "manager/list_products"; // duong dan toi view
		}
		
		
		
	@RequestMapping(value = { "/manager/ad_product" }, method = RequestMethod.GET) // --> action
	public String AddProduct(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		
		//can lay danh sach categories tu db va tra ve view qua model
		List<Categories> categories = categoriesService.findAllActive();
		//day xuong view de xu ly
		model.addAttribute("categories",categories);
		model.addAttribute("product",new Product());
		
		
		return "manager/ad_product"; // duong dan toi view
	}
	
	@RequestMapping(value = { "/manager/ad_product" }, method = RequestMethod.POST) // --> action
	public String AddProduct(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("product") Product product,
			@RequestParam("productAvatar") MultipartFile productAvatar,
			@RequestParam("productPictures") MultipartFile[] productPictures)
			//@RequestParam dung cho the input co type="file" 
	
			throws Exception {
		
//		luu product vao database
		productService.save(product, productAvatar, productPictures);
		
		
		return "/manager/ad_product"; // duong dan toi view
	}
}
