package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class UpdateBookRequest {

	private Long id;
	private String newTitle;
	private String newAuthor;
	private Integer newIssueYear;

	public UpdateBookRequest() { }

	public UpdateBookRequest(Long id, String newTitle, String newAuthor, Integer issueYear) {
		this.id = id;
		this.newTitle = newTitle;
		this.newAuthor = newAuthor;
		this.newIssueYear = issueYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewAuthor() {
		return newAuthor;
	}

	public void setNewAuthor(String newAuthor) {
		this.newAuthor = newAuthor;
	}

	public Integer getNewIssueYear() {
		return newIssueYear;
	}

	public void setNewIssueYear(Integer newIssueYear) {
		this.newIssueYear = newIssueYear;
	}
}