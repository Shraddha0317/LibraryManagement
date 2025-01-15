package com.shraddhaorg.library.LibraryManagement.controller;

import com.shraddhaorg.library.LibraryManagement.entities.Book;
import com.shraddhaorg.library.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookPageController {

    @Autowired
    private BookService bookService;

    // Display all books
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list"; // Renders templates/book-list.html
    }

    // Search books by title
    @GetMapping("/search")
    public String searchBooks(@RequestParam String title, Model model) {
        List<Book> books = bookService.searchBooksByTitle(title);
        model.addAttribute("books", books);
        return "book-list"; // Same page with filtered results
    }

    // Show form to add a new book
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book"; // Renders templates/add-book.html
    }

    // Handle form submission for adding a new book
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books"; // Redirect to book list after adding
    }

    // Delete a book and return to the list
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books"; // Redirect to book list
    }
}

