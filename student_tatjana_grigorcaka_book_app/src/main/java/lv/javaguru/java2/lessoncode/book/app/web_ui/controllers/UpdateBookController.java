package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.UpdateBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.UpdateBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateBookController {

	@Autowired private UpdateBookService updateBookService;


	@GetMapping(value = "/updateBook")
	public String showUpdateBookPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new UpdateBookRequest());
		return "updateBook";
	}

	@PostMapping("/updateBook")
	public String processUpdateBookRequest(@ModelAttribute(value = "request") UpdateBookRequest request, ModelMap modelMap) {
		UpdateBookResponse response = updateBookService.execute(request);
		if (response.containsErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "updateBook";
		} else {
			return "redirect:/";
		}
	}

}
