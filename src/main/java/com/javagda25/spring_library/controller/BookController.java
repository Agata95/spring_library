package com.javagda25.spring_library.controller;

import com.javagda25.spring_library.model.Book;
import com.javagda25.spring_library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/book/")
public class BookController {
    private final BookService bookService;

    @GetMapping(path = "/list")
    public String listBooks(Model model){
        List<Book> bookList = bookService.listAll();
        model.addAttribute("books", bookList);

        return "book-list";
    }
}
