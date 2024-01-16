package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers.rest;

import lv.javaguru.java2.lessoncode.book.app.core.requests.*;
import lv.javaguru.java2.lessoncode.book.app.core.responses.*;
import lv.javaguru.java2.lessoncode.book.app.core.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired private GetBookService getBookService;
	@Autowired private AddBookService addBookService;
	@Autowired private UpdateBookService updateBookService;
	@Autowired private DeleteBookService deleteBookService;
	@Autowired private SearchBooksService searchBookService;

	@GetMapping(path = "/{id}", produces = "application/json")
	public GetBookResponse getBook(@PathVariable Long id) {
		GetBookRequest request = new GetBookRequest(id);
		return getBookService.execute(request);
	}

	@PostMapping(path = "/",
			consumes = "application/json",
			produces = "application/json")
	public AddBookResponse addBook(@RequestBody AddBookRequest request) {
		return addBookService.execute(request);
	}

	@PutMapping(path = "/{id}",
			consumes = "application/json",
			produces = "application/json")
	public UpdateBookResponse updateBook(@RequestBody UpdateBookRequest request) {
		return updateBookService.execute(request);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public DeleteBookResponse deleteBook(@PathVariable Long id) {
		DeleteBookRequest request = new DeleteBookRequest(id);
		return deleteBookService.execute(request);
	}

	@PostMapping(path = "/search",
			consumes = "application/json",
			produces = "application/json")
	public SearchBooksResponse searchBooksPost(@RequestBody SearchBooksRequest request) {
		return searchBookService.execute(request);
	}

	@GetMapping(path = "/search", produces = "application/json")
	public SearchBooksResponse searchBooksGet(@RequestParam String title,
											  @RequestParam String author) {
		SearchBooksRequest request = new SearchBooksRequest(title, author);
		return searchBookService.execute(request);
	}

}