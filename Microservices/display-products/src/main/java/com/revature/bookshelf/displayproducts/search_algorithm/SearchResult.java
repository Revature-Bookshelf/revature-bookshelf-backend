package com.revature.bookshelf.bookservice.search_algorithm;

import com.revature.bookshelf.bookservice.entity.Book;

import java.util.List;

public interface SearchResult {

    List<Book> getSearchResultByTitle(List<Book> bookList, String userInput);
    List<Book> getSearchResultByAuthor(List<Book> bookList, String userInput);
    List<Book> getSearchResultByISBN(List<Book> bookList, String userInput);

}
