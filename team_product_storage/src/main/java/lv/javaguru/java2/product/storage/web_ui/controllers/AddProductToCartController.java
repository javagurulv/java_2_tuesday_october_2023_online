package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.AddProductToCartRequest;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductToCartResponse;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductToCartService;
import lv.javaguru.java2.product.storage.core.services.SearchProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddProductToCartController {

	@Autowired private AddProductToCartService addProductToCartService;
	@Autowired private SearchProductsService searchProductsService;


	@GetMapping(value = "/addProductToCart")
	public String showAddProductToCartPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new AddProductToCartRequest());
		modelMap.addAttribute("searchRequest", new SearchProductsRequest());
		return "addProductToCart";
	}

	@PostMapping("/addProductToCart")
	public String processAddProductToCartRequest(@ModelAttribute(value = "request") AddProductToCartRequest request, ModelMap modelMap) {
		AddProductToCartResponse response = addProductToCartService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "addProductToCart";
		} else {
			return "redirect:/";
		}
	}

	@PostMapping("/addProductToCart/search")
	public String processSearchProductsRequest(@ModelAttribute(value = "searchRequest") SearchProductsRequest searchRequest,
											  ModelMap modelMap) {
		SearchProductsRequest searchProductsRequest = new SearchProductsRequest(
		searchRequest.getProductBrand(), searchRequest.getProductModel()
		);
		SearchProductsResponse searchProductsResponse = searchProductsService.execute(searchProductsRequest);
		modelMap.addAttribute("products", searchProductsResponse.getProducts());


		modelMap.addAttribute("request", new AddProductToCartRequest());

		return "addProductToCart";
	}


}
