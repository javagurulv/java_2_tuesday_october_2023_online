package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class GetReaderRequest {

	private Long id;

	public GetReaderRequest() { }

	public GetReaderRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
