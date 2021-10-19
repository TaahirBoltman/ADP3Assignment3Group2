package za.ac.cput.factory;

/*  BookFac.java
    Book entity factory
    Author: Taahir Boltman(218022972)
    Date: 10 June 2021
 */

import za.ac.cput.entity.Book;
import za.ac.cput.util.GenericHelper;

public class BookFac {
    public static Book createBook(String shelfNumber, String authorname, String name,
                                  String desc, String keywords){

        String bookId = GenericHelper.generateId();

        Book book = new Book.bookBuilder()
              .setBookId(bookId)
                .setShelfNumber(shelfNumber)
                .setAuthorName(authorname)
                .setName(name)
                .setDesc(desc)
                .setKeywords(keywords)
                .build();

        return book;


    }
}

