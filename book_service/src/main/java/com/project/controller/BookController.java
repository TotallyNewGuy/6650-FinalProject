package com.project.controller;

import com.project.api.BookService;
import com.project.vo.ResultBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * BookController, responsible for processing incoming REST API requests,
 * preparing a model, and returning the view to be rendered as a response.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public ResultBook getBook(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

}
