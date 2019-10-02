package com.javagda25.spring_library.service;

import com.javagda25.spring_library.model.Book;
import com.javagda25.spring_library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> listAll() {
        return bookRepository.findAll();
    }
}
