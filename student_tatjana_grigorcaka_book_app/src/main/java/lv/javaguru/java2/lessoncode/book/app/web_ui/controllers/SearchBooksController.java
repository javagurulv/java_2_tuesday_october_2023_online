package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchBooksController {

	@Autowired private SearchBooksService searchBooksService;


	@GetMapping(value = "/searchBooks")
	public String showSearchBooksPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new SearchBooksRequest());
		return "searchBooks";
	}

	@PostMapping("/searchBooks")
	public String processSearchBooksRequest(@ModelAttribute(value = "request") SearchBooksRequest request, ModelMap modelMap) {
		SearchBooksResponse response = searchBooksService.execute(request);
		modelMap.addAttribute("books", response.getBooks());
		if (response.containsErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
		}
		return "searchBooks";
	}

}
