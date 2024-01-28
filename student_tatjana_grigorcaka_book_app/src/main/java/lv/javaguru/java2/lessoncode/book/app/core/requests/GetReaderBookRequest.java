package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class GetReaderBookRequest {

	private Long Id;

	public GetReaderBookRequest() {
	}

	public GetReaderBookRequest(Long id) {
		Id = id;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
}
