package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;

import java.util.List;

public class GetCakeResponse extends CoreResponse {

	private Cake cake;

	public GetCakeResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetCakeResponse(Cake cake) {
		this.cake = cake;
	}

	public Cake getCake() {
		return cake;
	}

}
