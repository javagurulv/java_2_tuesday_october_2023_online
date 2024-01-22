package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.DeleteReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.DeleteReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.DeleteReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteReaderController {

	@Autowired private DeleteReaderService deleteReaderService;


	@GetMapping(value = "/deleteReader")
	public String showDeleteReaderPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new DeleteReaderRequest());
		return "deleteReader";
	}

	@PostMapping("/deleteReader")
	public String processDeleteReaderRequest(@ModelAttribute(value = "request") DeleteReaderRequest request, ModelMap modelMap) {
		DeleteReaderResponse response = deleteReaderService.execute(request);
		if (response.containsErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "deleteReader";
		} else {
			return "redirect:/";
		}
	}

}
