package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.product.storage.core.services.GetAllProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllProductsController {

	@Autowired private GetAllProductsService getAllProductsService;


	@GetMapping(value = "/showAllProducts")
	public String showAllProducts(ModelMap modelMap) {
		GetAllProductsResponse response = getAllProductsService.execute(
				new GetAllProductsRequest()
		);
		modelMap.addAttribute("products", response.getProducts());
		return "/showAllProducts";
	}

}
