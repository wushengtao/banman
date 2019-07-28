package com.lunzi.batman.controller;

import com.lunzi.batman.core.service.BookService;
import com.lunzi.batman.dal.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author lunzi <lunzi@maihaoche.com>
 * @date 2019/7/27 16
 */
@Controller
@RequestMapping("/batman")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/list")
    @ResponseBody
    public Book queryBookList() {
        return bookService.queryBookByNo("NO001");
    }

    @RequestMapping("/test")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
