package lv.javaguru.java2.product.storage.web_ui.controllers.rest;

import lv.javaguru.java2.product.storage.core.requests.*;
import lv.javaguru.java2.product.storage.core.responses.*;
import lv.javaguru.java2.product.storage.core.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired private GetProductService getProductService;
	@Autowired private AddProductService addProductService;
	@Autowired private UpdateProductService updateProductService;
	@Autowired private DeleteProductService deleteProductService;
	@Autowired private SearchProductsService searchProductService;

	@GetMapping(path = "/{id}", produces = "application/json")
	public GetProductResponse getProduct(@PathVariable Long id) {
		GetProductRequest request = new GetProductRequest(id);
		return getProductService.execute(request);
	}

	@PostMapping(path = "/",
			consumes = "application/json",
			produces = "application/json")
	public AddProductResponse addProduct(@RequestBody AddProductRequest request) {
		return addProductService.execute(request);
	}

	@PutMapping(path = "/{id}",
			consumes = "application/json",
			produces = "application/json")
	public UpdateProductResponse updateProduct(@RequestBody UpdateProductRequest request) {
		return updateProductService.execute(request);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public DeleteProductResponse deleteProduct(@PathVariable Long id) {
		DeleteProductRequest request = new DeleteProductRequest(id);
		return deleteProductService.execute(request);
	}

	@PostMapping(path = "/search",
			consumes = "application/json",
			produces = "application/json")
	public SearchProductsResponse searchProductsPost(@RequestBody SearchProductsRequest request) {
		return searchProductService.execute(request);
	}

	@GetMapping(path = "/search", produces = "application/json")
	public SearchProductsResponse searchProductsGet(@RequestParam String productBrand,
											  @RequestParam String productModel) {
		SearchProductsRequest request = new SearchProductsRequest(productBrand, productModel);
		return searchProductService.execute(request);
	}

}