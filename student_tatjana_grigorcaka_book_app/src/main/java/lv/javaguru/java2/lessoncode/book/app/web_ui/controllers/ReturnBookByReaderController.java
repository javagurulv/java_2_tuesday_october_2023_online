package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.*;
import lv.javaguru.java2.lessoncode.book.app.core.responses.ReturnBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReturnBookByReaderController {

	@Autowired private ReturnBookService returnBookService;


	@GetMapping(value = "/returnBookByReader")
	public String showReturnBookByReaderPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new ReturnBookRequest());
		return "returnBookByReader";
	}

	@PostMapping("/returnBookByReader")
	public String processReturnBookByReaderRequest(@ModelAttribute(value = "request") ReturnBookRequest request, ModelMap modelMap) {
		ReturnBookResponse response = returnBookService.execute(request);
		if (response.containsErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "returnBookByReader";
		} else {
			return "redirect:/";
		}
	}

}
