package com.revature.bookshelf.bookservice.service;

import com.revature.bookshelf.bookservice.entity.Book;
import com.revature.bookshelf.bookservice.entity.Filter;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SolidFilterServiceTest {

    private static FilterService filterService;
    private static final List<Book> bookList = new ArrayList<>();

    @BeforeAll
    static void populateBookList() {
        Book b1 = new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(93, Calendar.JANUARY, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png", 1,99.99);
        Book b2 = new Book(2, "Train Life", 150, new Date(62, Calendar.JANUARY, 1), "0-987-65-4321", "Jane Smith", "Nonfiction", "./trainlife.png", 1, 50.50);
        Book b3 = new Book(3, "Legends of Hawaiian Mythology", 700, new Date(119, Calendar.JANUARY, 1), "3-420-76-9158", "Norman Reedus", "Mythology", "./legends.png", 1,119.99);
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
    }

    @BeforeEach
    public void init() {
        filterService = new SolidFilterService();
    }

    @Test
    @DisplayName("Genre Filter Test")
    public void genreFilterTest() {
        Date[] defaultDates = new Date[2];
        defaultDates[0] = new Date(0,Calendar.JANUARY,1);
        defaultDates[1] = new Date();
        List<String> genres = new ArrayList<>();
        genres.add("Nonfiction");
        long[] defaultPgCounts = new long[2];
        defaultPgCounts[1] = Long.MAX_VALUE;
        double[] defaultPrices = new double[2];
        defaultPrices[0] = 0;
        defaultPrices[1] = Double.MAX_VALUE;
        Filter filter = new Filter(genres,defaultDates,defaultPgCounts,defaultPrices);

        List<Book> actual = filterService.doFilter(bookList, filter);
        List<Book> expected = new ArrayList<>();
        expected.add(new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(93, Calendar.JANUARY, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png", 1,99.99));
        expected.add(new Book(2, "Train Life", 150, new Date(62, Calendar.JANUARY, 1), "0-987-65-4321", "Jane Smith", "Nonfiction", "./trainlife.png", 1,50.50));
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Page Count Filter Test")
    public void pgcountFilterTest() {
        Date[] defaultDates = new Date[2];
        defaultDates[0] = new Date(0,Calendar.JANUARY,1);
        defaultDates[1] = new Date();
        List<String> genres = new ArrayList<>();
        long[] pgCounts = new long[2];
        pgCounts[0] = 100;
        pgCounts[1] = 400;
        double[] defaultPrices = new double[2];
        defaultPrices[0] = 0;
        defaultPrices[1] = Double.MAX_VALUE;
        Filter filter = new Filter(genres,defaultDates,pgCounts,defaultPrices);

        List<Book> actual = filterService.doFilter(bookList, filter);
        List<Book> expected = new ArrayList<>();
        expected.add(new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(93, Calendar.JANUARY, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png", 1,99.99));
        expected.add(new Book(2, "Train Life", 150, new Date(62, Calendar.JANUARY, 1), "0-987-65-4321", "Jane Smith", "Nonfiction", "./trainlife.png", 1,50.50));
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Publish Date Filter Test")
    public void dateFilterTest() {
        Date[] dates = new Date[2];
        dates[0] = new Date(50,Calendar.JANUARY,1);
        dates[1] = new Date(100,Calendar.JANUARY,1);
        List<String> genres = new ArrayList<>();
        long[] defaultPgCounts = new long[2];
        defaultPgCounts[1] = Long.MAX_VALUE;
        double[] defaultPrices = new double[2];
        defaultPrices[0] = 0;
        defaultPrices[1] = Double.MAX_VALUE;
        Filter filter = new Filter(genres,dates,defaultPgCounts,defaultPrices);

        List<Book> actual = filterService.doFilter(bookList, filter);
        List<Book> expected = new ArrayList<>();
        expected.add(new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(93, Calendar.JANUARY, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png", 1,99.99));
        expected.add(new Book(2, "Train Life", 150, new Date(62, Calendar.JANUARY, 1), "0-987-65-4321", "Jane Smith", "Nonfiction", "./trainlife.png", 1,50.50));
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Price Filter Test")
    public void priceFilterTest() {
        Date[] defaultDates = new Date[2];
        defaultDates[0] = new Date(0,Calendar.JANUARY,1);
        defaultDates[1] = new Date();
        List<String> genres = new ArrayList<>();
        long[] defaultPgCounts = new long[2];
        defaultPgCounts[1] = Long.MAX_VALUE;
        double[] prices = new double[2];
        prices[0] = 50.00;
        prices[1] = 100.00;
        Filter filter = new Filter(genres,defaultDates,defaultPgCounts,prices);

        List<Book> actual = filterService.doFilter(bookList, filter);
        List<Book> expected = new ArrayList<>();
        expected.add(new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(93, Calendar.JANUARY, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png",1, 99.99));
        expected.add(new Book(2, "Train Life", 150, new Date(62, Calendar.JANUARY, 1), "0-987-65-4321", "Jane Smith", "Nonfiction", "./trainlife.png", 1,50.50));
        Assertions.assertEquals(expected,actual);
    }

//    @Test
//    @DisplayName("Congregated Filter Test")
//    public void allFilterTest() {
//        Date[] dates = new Date[2];
//        dates[0] = new Date(100,Calendar.JANUARY,1);
//        dates[1] = new Date();
//        List<String> genres = new ArrayList<>();
//        genres.add("Fiction");
//        long[] pgCounts = new long[2];
//        pgCounts[0] = 500;
//        pgCounts[1] = Long.MAX_VALUE;
//        double[] prices = new double[2];
//        prices[0] = 100.00;
//        prices[1] = Double.MAX_VALUE;
//        Filter filter = new Filter(genres,dates,pgCounts,prices);
//
//        System.out.println("Congregated Filter Test");
//        List<Book> actual = filterService.doFilter(bookList, filter);
//        List<Book> expected = new ArrayList<>();
//        expected.add(new Book(3, "Legends of Hawaiian Mythology", 700, new Date(119, Calendar.JANUARY, 1), "3-420-76-9158", "Norman Reedus", "Mythology", "./legends.png", 1,119.99));
//        Assertions.assertEquals(expected,actual);
//    }
}
