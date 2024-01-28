package lv.javaguru.java2.cakeConstructor.newApp.web_ui.controllers.rest;

import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.*;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.*;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientRestController {

	@Autowired private GetIngredientService getIngredientService;
	@Autowired private AddIngredientService addIngredientService;
	@Autowired private UpdateIngredientService updateIngredientService;
	@Autowired private DeleteIngredientService deleteIngredientService;
	@Autowired private SearchIngredientsService searchIngredientService;

	@GetMapping(path = "/{id}", produces = "application/json")
	public GetIngredientResponse getIngredient(@PathVariable Long id) {
		GetIngredientRequest request = new GetIngredientRequest(id);
		return getIngredientService.execute(request);
	}

	@PostMapping(path = "/",
			consumes = "application/json",
			produces = "application/json")
	public AddIngredientResponse addIngredient(@RequestBody AddIngredientRequest request) {
		return addIngredientService.execute(request);
	}

	@PutMapping(path = "/{id}",
			consumes = "application/json",
			produces = "application/json")
	public UpdateIngredientResponse updateIngredient(@RequestBody UpdateIngredientRequest request) {
		return updateIngredientService.execute(request);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public DeleteIngredientResponse deleteIngredient(@PathVariable Long id) {
		DeleteIngredientRequest request = new DeleteIngredientRequest(id);
		return deleteIngredientService.execute(request);
	}

	@PostMapping(path = "/search",
			consumes = "application/json",
			produces = "application/json")
	public SearchIngredientsResponse searchIngredientsPost(@RequestBody SearchIngredientsRequest request) {
		return searchIngredientService.execute(request);
	}

	@GetMapping(path = "/search", produces = "application/json")
	public SearchIngredientsResponse searchIngredientsGet(@RequestParam String type,
											  @RequestParam String taste) {
		SearchIngredientsRequest request = new SearchIngredientsRequest(type, taste);
		return searchIngredientService.execute(request);
	}

}