package com.klu;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LibraryController {

    // In-memory book list
    private List<Book> bookList = new ArrayList<>();

    // 2. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 3. /count
    @GetMapping("/count")
    public int totalBooks() {
        return 120;
    }

    // 4. /price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 5. /books
    @GetMapping("/books")
    public List<String> getBookTitles() {
        return Arrays.asList(
                "Java Programming",
                "Spring Boot in Action",
                "Data Structures",
                "Cloud Computing"
        );
    }

    // 6. /books/{id}
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return new Book(id, "Spring Boot Guide", "John Doe", 699.00);
    }

    // 7. /search?title=
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "You searched for the book titled: " + title;
    }

    // 8. /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 9. /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 10. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
