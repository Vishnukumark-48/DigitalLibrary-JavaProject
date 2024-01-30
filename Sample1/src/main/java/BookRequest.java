// BookRequest.java

public class BookRequest {
    private String bookName;
    private String authorName;

    public BookRequest(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }
}
