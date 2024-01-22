package lv.javaguru.java2.product.storage.web_ui.controllers;

import lv.javaguru.java2.product.storage.core.requests.UpdateProductRequest;
import lv.javaguru.java2.product.storage.core.responses.UpdateProductResponse;
import lv.javaguru.java2.product.storage.core.services.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateProductController {

	@Autowired private UpdateProductService updateProductService;


	@GetMapping(value = "/updateProduct")
	public String showUpdateProductPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new UpdateProductRequest());
		return "updateProduct";
	}

	@PostMapping("/updateProduct")
	public String processUpdateProductRequest(@ModelAttribute(value = "request") UpdateProductRequest request, ModelMap modelMap) {
		UpdateProductResponse response = updateProductService.execute(request);
		if (response.hasErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "updateProduct";
		} else {
			return "redirect:/";
		}
	}

}
