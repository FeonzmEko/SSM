package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.domain.Code;
import com.itheima.domain.Result;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new Result(flag,flag?Code.SAVE_OK:Code.SAVE_ERR);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        boolean flag = bookService.update(book);
        return new Result(flag,flag?Code.UPDATE_OK:Code.UPDATE_ERR);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = bookService.delete(id);
        return new Result(flag,flag?Code.DELETE_OK:Code.DELETE_ERR);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Book book = bookService.getById(id);
        return new Result(book != null, book, book != null ? Code.GET_OK : Code.GET_ERR);
    }

    @GetMapping
    public Result getAll(){
        List<Book> books = bookService.getAll();
        return new Result(books, Code.GET_OK);
    }
}
