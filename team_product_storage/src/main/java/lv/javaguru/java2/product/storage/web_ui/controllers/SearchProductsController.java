package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;
import lv.javaguru.java2.product.storage.core.services.SearchProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchProductsController {

	@Autowired private SearchProductsService searchProductsService;


	@GetMapping(value = "/searchProducts")
	public String showSearchProductsPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new SearchProductsRequest());
		return "searchProducts";
	}

	@PostMapping("/searchProducts")
	public String processSearchProductsRequest(@ModelAttribute(value = "request") SearchProductsRequest request, ModelMap modelMap) {
		SearchProductsResponse response = searchProductsService.execute(request);
		modelMap.addAttribute("products", response.getProducts());
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
		}
		return "searchProducts";
	}

}
