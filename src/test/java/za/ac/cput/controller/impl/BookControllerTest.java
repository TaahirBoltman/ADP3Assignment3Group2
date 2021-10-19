package za.ac.cput.controller.impl;

/*  BookControllerTest.java
    Book Controller Test
    Author: Taahir Boltman(218022972)
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Book;
import za.ac.cput.factory.BookFac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
    private static Book book = BookFac.createBook("","","","","");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/user";
    @Test
    @Disabled
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Book> postResponse = restTemplate.postForEntity(url, book,Book.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        book = postResponse.getBody();
        System.out.println("Saved data: " + book);
        assertEquals(book.getBookId(), postResponse.getBody().getBookId());
    }

    @Test
    @Disabled
    void b_read() {
        String url = BASE_URL + "/read/" + book.getBookId();
        System.out.println("URL: " + url);
        ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
        assertEquals(book.getBookId(), response.getBody().getBookId());
    }

    @Test
    @Disabled
    void c_update() {
        Book updated = new Book.bookBuilder().copy(book).setDesc("The Biggest Planet in our Solar System").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: "+ updated);
        ResponseEntity<Book> response = restTemplate.postForEntity(url, updated, Book.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = BASE_URL + "/delete/" + book.getBookId();
        System.out.println("URL: "+ url);
        restTemplate.delete(url);
        String readUrl = BASE_URL + "/read/" + book.getBookId();
        ResponseEntity<Book> response = restTemplate.getForEntity(readUrl, Book.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @Disabled
    void d_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}