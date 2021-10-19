package za.ac.cput.factory;

/*  BookFacTest.java
    Book entity factory test
    Author: Taahir Boltman(218022972)
    Date: 10 June 2021
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Book;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class BookFacTest {

    private Book book;
    private Book book1;

    @Test
    public void createBook(){
        book = BookFac.createBook("4", "Rick Y", "The Last Star", "In the last days Earths remaining survivors need to decide whats more important, saving themselves or saving their humanity",
                "Stars, Aliens, Soldiers");

        book1 = BookFac.createBook("2", "Rick Y", "The Infinite Sea", "No one can anticipate the depth to which the others will sink nor the heights to which humanity will rise",
                "Sea, Aliens, Soldiers");

        System.out.println(book);
        System.out.println(book1);
    }

    @Test
    void TestEquality(){
        assertEquals(book,book1);
    }

    @Test
    void TestIdentity(){
        assertSame(book,book1);
    }

    @Test
    @Timeout(value= 100, unit = TimeUnit.MILLISECONDS)
    void TestTimeout(){
        createBook();
    }

    @Test
    @Disabled
    void TestDisabled(){
        createBook();
    }

}
