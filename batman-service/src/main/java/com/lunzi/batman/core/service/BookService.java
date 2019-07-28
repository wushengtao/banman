package com.lunzi.batman.core.service;

import com.lunzi.batman.dal.domain.Book;

import java.util.List;

/**
 * @author lunzi <lunzi@maihaoche.com>
 * @date 2019/7/27 16
 */
public interface BookService {
    /**
     * 根据书籍编号查询书籍
     * @param bookNo 书编号
     * @return bookList
     */
    Book queryBookByNo(String bookNo);
}
