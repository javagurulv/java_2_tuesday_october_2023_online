package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddProductController {

	@Autowired private AddProductService addProductService;


	@GetMapping(value = "/addProductToList")
	public String showAddProductPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new AddProductRequest());
		return "addProductToList";
	}

	@PostMapping("/addProductToList")
	public String processAddProductRequest(@ModelAttribute(value = "request") AddProductRequest request, ModelMap modelMap) {
		AddProductResponse response = addProductService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "addBookToList";
		} else {
			return "redirect:/";
		}
	}

}
