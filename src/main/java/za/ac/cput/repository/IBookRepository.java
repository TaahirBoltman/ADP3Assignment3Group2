package za.ac.cput.repository;
/*  IBookRepository.java
    Book Repository Interface
    Author: Taahir Boltman(218022972)
 */
import za.ac.cput.entity.Book;

import java.util.*;

public interface IBookRepository extends IRepository<Book, String>{
    public Set<Book> getAll();
}
