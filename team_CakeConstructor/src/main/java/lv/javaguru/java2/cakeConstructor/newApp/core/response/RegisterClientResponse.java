package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;

import java.util.List;

public class RegisterClientResponse extends CoreResponse {

	private Client newClient;

	public RegisterClientResponse(List<CoreError> errors) {
		super(errors);
	}

	public RegisterClientResponse(Client newClient) {
		this.newClient = newClient;
	}

	public Client getNewClient() {
		return newClient;
	}

}