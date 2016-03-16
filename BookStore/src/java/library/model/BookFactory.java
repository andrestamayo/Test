package library.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;


public class BookFactory implements BookFacade {

    private Collection<Book> books = null;
    private Collection<Book> booksn = null;
    public BookFactory () {
        init();
    }
    public BookFactory (String l) {
        booksn = new ArrayList<Book>();
        for(Book b:books){
            if(b.getAuthor().charAt(0)==l.charAt(0)){
                booksn.add(b);
            }
        }
    }
    

    private void init() {
        books = new ArrayList<Book>();
        Random random = new Random();
        books.add(new Book(random.nextLong(), "David Roos", "Struts book", true));
        books.add(new Book(random.nextLong(), "Micheal Jackson", "Java book", true));
        books.add(new Book(random.nextLong(), "Bruce Lee", "Java2 book", false));
        books.add(new Book(random.nextLong(), "Tom Jones" ,"EJB book", true));
        books.add(new Book(random.nextLong(), "Mc Donald", "Jboss for beginners", false));
        books.add(new Book(random.nextLong(), "Lars Mars", "Using Myeclipse for cooking", true));
        books.add(new Book(random.nextLong(), "Mary Jane", "EJB or spending your weekends", true));
    }

    public Collection<Book> getBooks() {
        return books;
    }
    public Collection<Book> getBooksn() {
        return booksn;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
    
    @Override
    public long createBook(Book book) {
        Random random = new Random();
        book.setId(random.nextLong());
        books.add(book);

        return book.getId();
    }
    
    @Override
    public void updateBook(Book book) {
        ArrayList<Book> booksNew = (ArrayList) books;
        int index = 0;
          for (Book libro:books) {
            if (libro.getId() == book.getId()) {
            	booksNew.set(index, book);
                break;
            }
            index++;
        }
        
        books = booksNew;
    }
    

    @Override
    public Book findBook(long id) {
        for (Book libro:books) {
            if (libro.getId() == id) 
                return libro;
        }
        return null;
    }
    
    @Override
    public void deleteBook(long id){
        Collection booksNew = new ArrayList<Book>();
        for (Book libro:books) {
            if (libro.getId() != id){
            	booksNew.add(libro);
            }
        }
        books = booksNew;
    }

}