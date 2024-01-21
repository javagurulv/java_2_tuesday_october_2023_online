package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.*;
import lv.javaguru.java2.lessoncode.book.app.core.responses.ReturnBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchReadersResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.ReturnBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchBooksService;
import lv.javaguru.java2.lessoncode.book.app.core.services.SearchReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReturnBookByReaderController {

	@Autowired private ReturnBookService returnBookService;

	@Autowired private SearchReadersService searchReadersService;
	@Autowired private SearchBooksService searchBooksService;

	@GetMapping(value = "/returnBookByReader")
	public String showReturnBookByReaderPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new ReturnBookRequest());
		modelMap.addAttribute("searchRequest", new SearchReadersAndBooksRequest());
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

	@PostMapping("/returnBookByReader/search")
	public String processSearchReadersRequest(@ModelAttribute(value = "searchRequest") SearchReadersAndBooksRequest searchRequest,
											  ModelMap modelMap) {
		SearchReadersRequest searchReaderRequest = new SearchReadersRequest(
				searchRequest.getReaderFirstName(), searchRequest.getReaderLastName()
		);
		SearchReadersResponse searchReadersResponse = searchReadersService.execute(searchReaderRequest);
		modelMap.addAttribute("readers", searchReadersResponse.getReaders());

		SearchBooksRequest searchBooksRequest = new SearchBooksRequest(
				searchRequest.getBookTitle(), searchRequest.getBookAuthor()
		);
		SearchBooksResponse searchBooksResponse = searchBooksService.execute(searchBooksRequest);
		modelMap.addAttribute("books", searchBooksResponse.getBooks());

		modelMap.addAttribute("request", new ReturnBookRequest());

		return "returnBookByReader";
	}

}
