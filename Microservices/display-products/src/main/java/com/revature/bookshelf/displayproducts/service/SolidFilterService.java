package com.revature.bookshelf.bookservice.service;

import com.revature.bookshelf.bookservice.entity.Book;
import com.revature.bookshelf.bookservice.entity.Filter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolidFilterService implements FilterService{

    @Override
    public List<Book> doFilter(List<Book> books, Filter filter) {
        List<Book> filteredBooks = new ArrayList<>(books);
        for (Book book : books) {
            //GENRE FILTER
            if (!filter.getGenres().isEmpty()) {
                boolean containsGenre = false;
                if (!filter.getGenres().contains(book.getGenre())) {
                    filteredBooks.remove(book);
                }
            }

            //DATE FILTER
            if (filter.getDates()[0].after(book.getPublishDate()) || filter.getDates()[1].before(book.getPublishDate())) {
                filteredBooks.remove(book);
            }

            //PAGECOUNT FILTER
            else if (filter.getPgcounts()[0] > book.getPageCount() || filter.getPgcounts()[1] < book.getPageCount()) {
                filteredBooks.remove(book);
            }

            //PRICE FILTER
            else if (filter.getPrices()[0] > book.getPrice() || filter.getPrices()[1] < book.getPrice()) {
                filteredBooks.remove(book);
            }
        }
        return filteredBooks;
    }
}

//THIS IS A SERVICE THAT FILTERS BOOKS BASED ON A USER'S SET FILTERS. THIS IS USED FOR THE SEARCH FUNCTIONALITY