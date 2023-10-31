package classWork;

public class SearchBooksRequest {
    String Author;
    String title;

    public SearchBooksRequest(String author, String title) {
        Author = author;
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTitle() {
        return title;
    }
}
