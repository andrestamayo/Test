package library.model;

public interface BookFacade {
    public long createBook(Book book);
    public void updateBook(Book book);
    public Book findBook(long id);
    public void deleteBook(long id);    
}
