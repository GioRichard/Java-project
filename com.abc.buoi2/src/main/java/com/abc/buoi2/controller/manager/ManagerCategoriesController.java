package com.abc.buoi2.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abc.buoi2.controller.user.BaseController;
import com.abc.buoi2.entities.Categories;
import com.abc.buoi2.services.CategoriesService;


@Controller
public class ManagerCategoriesController extends BaseController {
	
	//inject mot bean(service) vao trong 1 bean khac (controller)
	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping(value = { "/manager/categories" }, method = RequestMethod.GET) // --> action
	public String home(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		
		//can lay danh sach categories tu db va tra ve view qua model
		List<Categories> categories = categoriesService.findAllActive();
		
		//day xuong view de xu ly
		model.addAttribute("categories",categories);
		
		return "manager/categories"; // duong dan toi view
	}
}
