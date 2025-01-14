package com.shraddhaorg.library.LibraryManagement.repository;
  import com.shraddhaorg.library.LibraryManagement.entities.Book;
  import org.springframework.data.jpa.repository.JpaRepository;

  import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContaining(String title);
}
