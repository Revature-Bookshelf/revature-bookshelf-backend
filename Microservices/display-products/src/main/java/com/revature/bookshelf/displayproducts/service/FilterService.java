package com.revature.bookshelf.bookservice.service;

import com.revature.bookshelf.bookservice.entity.Book;
import com.revature.bookshelf.bookservice.entity.Filter;

import java.util.List;

public interface FilterService {

    List<Book> doFilter(List<Book> products, Filter filter);
}
