package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;

import java.util.List;

public class DeleteClientResponse extends CoreResponse {

	private Client deletedClient;

	public DeleteClientResponse(List<CoreError> errors) {
		super(errors);
	}

	public DeleteClientResponse(Client deletedClient) {
		this.deletedClient = deletedClient;
	}

	public Client getDeletedClient() {
		return deletedClient;
	}

}
