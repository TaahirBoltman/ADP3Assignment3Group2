package za.ac.cput.service.impl;
/*  BookService.java
    Book Service
    Author: Taahir Boltman(218022972)
 */
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Book;
import za.ac.cput.repository.BookRepository;

import java.util.*;

@Service
public class BookService implements IBookService{
    private static BookService service = null;
    private BookRepository repository = null;

    private BookService(){ this.repository = BookRepository.getRepository();}

    public static BookService getService() {
        if (service == null) {
            service = new BookService();
        }
        return service;
    }

    @Override
    public Book create(Book book) {
        return this.repository.create(book);
    }

    @Override
    public Book read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Book update(Book book) {
        return this.repository.update(book);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Set<Book> getAll() {
        return this.repository.getAll();
    }
}
