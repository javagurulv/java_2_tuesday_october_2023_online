package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.GetAllBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllBooksController {

	@Autowired private GetAllBooksService getAllBooksService;


	@GetMapping(value = "/showAllBooks")
	public String showAllBooks(ModelMap modelMap) {
		GetAllBooksResponse response = getAllBooksService.execute(
				new GetAllBooksRequest()
		);
		modelMap.addAttribute("books", response.getBooks());
		return "/showAllBooks";
	}

}
