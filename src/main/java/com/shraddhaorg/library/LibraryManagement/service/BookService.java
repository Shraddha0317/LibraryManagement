package com.shraddhaorg.library.LibraryManagement.service;
  import com.shraddhaorg.library.LibraryManagement.entities.Book;
  import com.shraddhaorg.library.LibraryManagement.repository.BookRepository;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;

  import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
       //add book
    public  Book addBook(Book book){
        return bookRepository.save(book);
    }
   //search book by title
    public List<Book> searchBooksByTitle(String title){
        return bookRepository.findByTitleContaining(title);
    }

    //get all book
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //delete a book
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
