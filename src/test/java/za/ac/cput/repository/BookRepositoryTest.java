package za.ac.cput.repository;
/*  BookRepositoryTest.java
    Book Repository Test
    Author: Taahir Boltman(218022972)
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Book;
import za.ac.cput.factory.BookFac;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {
    private static BookRepository repository = BookRepository.getRepository();
    private static Book book = BookFac.createBook("4","T.Boltman","How many Stars in the sky","About Stars","Stars, sky");

    @Test
    void create(){
        Book created = repository.create(book);
        assertEquals(created.getBookId(),book.getBookId());
        System.out.println("Created: " + created);
    }

    @Test
    void read(){
        Book read = repository.read(book.getBookId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update(){
        Book updated = new Book.bookBuilder().copy(book).setDesc("Many many stars").build();
        assertEquals(updated,repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete(){
        boolean fail = repository.delete(book.getBookId());
        assertFalse(fail);
        System.out.println("Deleted: " + fail);
    }

    @Test
    void getAll(){
        System.out.println("Showing all: ");
        System.out.println(repository.getAll());
    }

}
