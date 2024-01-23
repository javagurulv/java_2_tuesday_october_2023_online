package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.DeleteProductRequest;
import lv.javaguru.java2.product.storage.core.responses.DeleteProductResponse;
import lv.javaguru.java2.product.storage.core.services.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteProductController {

	@Autowired private DeleteProductService deleteProductService;


	@GetMapping(value = "/deleteProductFromList")
	public String showDeleteProductPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new DeleteProductRequest());
		return "deleteProductFromList";
	}

	@PostMapping("/deleteProductFromList")
	public String processDeleteProductRequest(@ModelAttribute(value = "request") DeleteProductRequest request, ModelMap modelMap) {
		DeleteProductResponse response = deleteProductService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "deleteProductFromList";
		} else {
			return "redirect:/";
		}
	}

}
