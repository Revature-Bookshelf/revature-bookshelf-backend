package com.revature.bookshelf.displayproducts.service;

import com.revature.bookshelf.displayproducts.entity.Filter;
import com.revature.bookshelf.displayproducts.entity.Book;

import java.util.List;

public interface FilterService {

    List<Book> doFilter(List<Book> products, Filter filter);
}
