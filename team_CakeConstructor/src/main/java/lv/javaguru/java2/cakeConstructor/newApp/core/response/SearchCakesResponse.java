package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;

import java.util.List;

public class SearchCakesResponse extends CoreResponse {

	private List<Cake> cakes;

	public SearchCakesResponse(List<Cake> cakes, List<CoreError> errors) {
		super(errors);
		this.cakes = cakes;
	}

	public List<Cake> getCakes() {
		return cakes;
	}
}
