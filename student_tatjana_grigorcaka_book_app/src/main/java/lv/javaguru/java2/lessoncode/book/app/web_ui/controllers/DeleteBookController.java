package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.DeleteBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.DeleteBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.DeleteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteBookController {

	@Autowired private DeleteBookService deleteBookService;


	@GetMapping(value = "/deleteBookFromList")
	public String showDeleteBookPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new DeleteBookRequest());
		return "deleteBookFromList";
	}

	@PostMapping("/deleteBookFromList")
	public String processDeleteBookRequest(@ModelAttribute(value = "request") DeleteBookRequest request, ModelMap modelMap) {
		DeleteBookResponse response = deleteBookService.execute(request);
		if (response.containsErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "deleteBookFromList";
		} else {
			return "redirect:/";
		}
	}

}
