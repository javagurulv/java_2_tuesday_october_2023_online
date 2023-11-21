package classWork.core.requests;

public class SearchBooksRequest {
    String Author;
    String title;
    Paging padding;
    Ordering ordering;




    public SearchBooksRequest(String author, String title, Paging padding, Ordering ordering) {
        Author = author;
        this.title = title;
        this.padding = padding;
        this.ordering = ordering;
    }
    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPadding() {
        return padding;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTitle() {
        return title;
    }

}
