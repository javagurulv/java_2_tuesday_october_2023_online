package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class DeleteReaderRequest {

	private Long id;

	public DeleteReaderRequest() { }

	public DeleteReaderRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
