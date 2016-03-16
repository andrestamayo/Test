package library.model;

public class Book {

    private long id = 0;
    private String title = "";
    private String author = "";
    private boolean available = false;

    public Book() {
    }

    public Book(long id, String author, String title, boolean available) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
