package com.lunzi.batman.core.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lunzi.batman.core.service.BookService;
import com.lunzi.batman.dal.domain.Book;
import com.lunzi.batman.dal.manager.BookManager;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lunzi <lunzi@maihaoche.com>
 * @date 2019/7/27 16
 */
@Component
public class BookServiceImpl implements BookService {
    @Autowired
    BookManager bookManager;

    @Override
    public Book queryBookByNo(String bookNo) {
        EntityWrapper<Book> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("book_no", bookNo);
        List<Book> bookList = bookManager.selectList(entityWrapper);
        if (CollectionUtils.isEmpty(bookList)) {
            return null;
        }
        return bookList.get(0);
    }
}
