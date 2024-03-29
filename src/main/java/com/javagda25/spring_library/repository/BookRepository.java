package com.javagda25.spring_library.repository;

import com.javagda25.spring_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
