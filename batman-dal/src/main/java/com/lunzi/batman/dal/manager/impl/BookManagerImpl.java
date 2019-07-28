package com.lunzi.batman.dal.manager.impl;

import com.lunzi.batman.dal.domain.Book;
import com.lunzi.batman.dal.dao.BookDao;
import com.lunzi.batman.dal.manager.BookManager;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lunzi
 * @since 2019-07-28
 */
@Service
public class BookManagerImpl extends ServiceImpl<BookDao, Book> implements BookManager {

}
