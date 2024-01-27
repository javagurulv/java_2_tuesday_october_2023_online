package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class DeleteClientRequest {

	private Long id;

	public DeleteClientRequest() { }

	public DeleteClientRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) { this.id = id; }
}
