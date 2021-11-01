package com.abc.buoi2.controller.manager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abc.buoi2.controller.user.BaseController;


@Controller
public class ManagerHomeController extends BaseController{
	@RequestMapping(value = { "/manager/ad_index" }, method = RequestMethod.GET) // --> action
	public String ManagerHome(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		return "manager/ad_index"; // duong dan toi view
	}
}
