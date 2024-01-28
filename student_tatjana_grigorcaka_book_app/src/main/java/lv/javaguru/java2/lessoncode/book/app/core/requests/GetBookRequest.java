package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class GetBookRequest {

	private Long id;

	public GetBookRequest() { }

	public GetBookRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
