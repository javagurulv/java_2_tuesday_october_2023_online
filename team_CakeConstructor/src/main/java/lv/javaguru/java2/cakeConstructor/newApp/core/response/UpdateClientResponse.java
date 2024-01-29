package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;

import java.util.List;

public class UpdateClientResponse extends CoreResponse {

	private Client updatedClient;

	public UpdateClientResponse(List<CoreError> errors) {
		super(errors);
	}

	public UpdateClientResponse(Client updatedClient) {
		this.updatedClient = updatedClient;
	}

	public Client getUpdatedClient() {
		return updatedClient;
	}

}