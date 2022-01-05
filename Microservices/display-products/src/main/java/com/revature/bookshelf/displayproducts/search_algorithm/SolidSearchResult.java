package com.revature.bookshelf.bookservice.search_algorithm;

import com.revature.bookshelf.bookservice.entity.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SolidSearchResult implements SearchResult{

    private final StringContainment stringContainment;
    private final StringSimilarity stringSimilarity;

    public SolidSearchResult(StringContainment sc, StringSimilarity ss) {
        this.stringContainment = sc;
        this.stringSimilarity = ss;
    }

    public List<Book> getSearchResultByTitle(List<Book> bookList, String userInput) {
        List<Book> similarBooks = new ArrayList<>();
        List<Book> dissimilarBooks = new ArrayList<>();
        Map<Book, Double> bookSimilarities = new HashMap<>();
        Map<Book,Integer> bookContainments = new HashMap<>();
        for (Book book: bookList) {
            double similarity = stringSimilarity.similarity(userInput,book.getTitle());
            bookSimilarities.put(book,similarity);
            if (similarity >= 0.40) {
                similarBooks.add(book);
            }
            else {
                dissimilarBooks.add(book);
            }
        }
        List<Book> dissimilarBooksResult = new ArrayList<>(dissimilarBooks);
        for (Book book: dissimilarBooks) {
            int containCount = stringContainment.contains(userInput, book.getTitle());
            if (containCount >= 1) {
                bookContainments.put(book, containCount);
            }
            else {
                dissimilarBooksResult.remove(book);
            }
        }

        similarBooks.sort((o1, o2) -> {
            if (bookSimilarities.get(o1) < bookSimilarities.get(o2)) {
                return 1;
            }
            if (Objects.equals(bookSimilarities.get(o1), bookSimilarities.get(o2))) {
                return 0;
            }
            else {
                return -1;
            }
        });

        dissimilarBooksResult.sort(Comparator.comparingInt(bookContainments::get));
        similarBooks.addAll(dissimilarBooksResult);
        return similarBooks;
    }

    public List<Book> getSearchResultByAuthor(List<Book> bookList,String userInput) {
        List<Book> similarBooks = new ArrayList<>();
        Map<Book, Double> bookSimilarities = new HashMap<>();
        for (Book book: bookList) {
            double similarity = stringSimilarity.similarity(userInput,book.getAuthor());
            bookSimilarities.put(book,similarity);
            if (similarity >= 0.40) {
                similarBooks.add(book);
            }
        }

        similarBooks.sort((o1, o2) -> {
            if (bookSimilarities.get(o1) < bookSimilarities.get(o2)) {
                return 1;
            }
            if (Objects.equals(bookSimilarities.get(o1), bookSimilarities.get(o2))) {
                return 0;
            }
            else {
                return -1;
            }
        });

        return similarBooks;
    }
    public List<Book> getSearchResultByISBN(List<Book> bookList,String userInput) {
        List<Book> similarBooks = new ArrayList<>();
        Map<Book, Double> bookSimilarities = new HashMap<>();
        for (Book book: bookList) {
            double similarity = stringSimilarity.similarity(userInput,book.getIsbn());
            bookSimilarities.put(book,similarity);
            if (similarity >= 0.80) {
                similarBooks.add(book);
            }
        }

        similarBooks.sort((o1, o2) -> {
            if (bookSimilarities.get(o1) < bookSimilarities.get(o2)) {
                return 1;
            }
            if (Objects.equals(bookSimilarities.get(o1), bookSimilarities.get(o2))) {
                return 0;
            }
            else {
                return -1;
            }
        });

        return similarBooks;
    }
}
