package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;

import java.util.List;

public class GetClientResponse extends CoreResponse {

	private Client client;

	public GetClientResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetClientResponse(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

}
