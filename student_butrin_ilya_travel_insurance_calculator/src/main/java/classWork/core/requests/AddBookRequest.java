package classWork.core.requests;

public class AddBookRequest {
    String Title;
    String Author;
    public AddBookRequest(String title, String author) {
        Title = title;
        Author = author;
    }
    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }
}
