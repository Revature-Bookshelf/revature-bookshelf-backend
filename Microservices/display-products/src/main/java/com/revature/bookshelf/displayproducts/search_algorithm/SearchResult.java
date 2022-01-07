package com.revature.bookshelf.displayproducts.search_algorithm;



import com.revature.bookshelf.displayproducts.entity.Book;

import java.util.List;

public interface SearchResult {

    List<Book> getSearchResultByTitle(List<Book> bookList, String userInput);
    List<Book> getSearchResultByAuthor(List<Book> bookList, String userInput);
    List<Book> getSearchResultByISBN(List<Book> bookList, String userInput);

}
