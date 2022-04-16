package com.project.api;

import com.project.vo.Result;
import com.project.vo.ResultBook;

public interface BookService {
    ResultBook getBookById(Long id);
}
