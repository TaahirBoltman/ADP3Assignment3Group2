package za.ac.cput.repository;
/*  BookRepository.java
    Book Repository
    Author: Taahir Boltman(218022972)
 */
import za.ac.cput.entity.Book;
import java.util.*;

public class BookRepository implements IBookRepository {

    private static BookRepository repository = null;
    private Set<Book> bookDB = null;

    private BookRepository() {
        bookDB = new HashSet<Book>();
        }

        public static BookRepository getRepository() {
            if (repository == null) {
                repository = new BookRepository();
            }
            return repository;
        }

    @Override
    public Book create(Book book) {
        boolean success = bookDB.add(book);
        if (!success)
            return null;
        return book;
    }

    @Override
    public Book read(String bookId) {
        /* for(Book b: bookDB)
        {
            if(b.getBookId().equals(bookId)){
                return b;
            }
        }
        return null;*/
        Book book = bookDB.stream()
                .filter(e -> e.getBookId().equals(bookId))
                .findAny()
                .orElse(null);
        return book;
    }

    @Override
    public Book update(Book book) {
        Book oldBook = read(book.getBookId());
        if (oldBook != null) {
            bookDB.remove(oldBook);
            bookDB.add(book);
            return book;
        }
        return null;
    }

    @Override
    public boolean delete(String bookId) {
        Book bookToDelete = read(bookId);
        if (bookToDelete == null)
            return false;
        bookDB.remove(bookToDelete);
        return true;
    }

    @Override
    public Set<Book> getAll() {
        return bookDB;
    }
}

