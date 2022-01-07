package com.revature.bookshelf.bookservice.search_algorithm;


import com.revature.bookshelf.displayproducts.entity.Book;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolidSearchResultTest {
    private static SolidSearchResult solidSearchResult;
    private static final List<Book> bookList = new ArrayList<>();
    private static StringSimilarity stringSimilarityMock;
    private static StringContainment stringContainmentMock;

    @BeforeAll
    static void populateBookList() {
        Book b1 = new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(1993, 1, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png",1,99.99);
        Book b2 = new Book(2, "Train Life", 150, new Date(1962, 1, 1), "0-987-65-4321", "Jane Smith", "Nonfiction", "./trainlife.png", 1,50.50);
        Book b3 = new Book(3, "Legends of Hawaiian Mythology", 700, new Date(2019, 1, 1), "3-420-76-9158", "Norman Reedus", "Mythology", "./legends.png", 1,119.99);
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
    }

    @BeforeEach
    void initiate() {
        stringSimilarityMock = Mockito.mock(StringSimilarity.class);
        stringContainmentMock = Mockito.mock(StringContainment.class);
        solidSearchResult = new SolidSearchResult(stringContainmentMock,stringSimilarityMock);
    }

    @BeforeEach
    void recordTitleMock() {
        //Title test mocks
        Mockito.when(stringSimilarityMock.similarity("train dog","Train Life")).thenReturn(0.6);
        Mockito.when(stringSimilarityMock.similarity("train dog","How to Train Your Dog and Make it Love You")).thenReturn(0.5);
        Mockito.when(stringSimilarityMock.similarity("train dog","Legends of Hawaiian Mythology")).thenReturn(0.20689655172413793);
        Mockito.when(stringContainmentMock.contains("train dog","Train Life")).thenReturn(1);
        Mockito.when(stringContainmentMock.contains("train dog","How to Train Your Dog and Make it Love You")).thenReturn(2);
        Mockito.when(stringContainmentMock.contains("train dog","Legends of Hawaiian Mythology")).thenReturn(0);

        //Author test mocks
        Mockito.when(stringSimilarityMock.similarity("John Smith","John Smith")).thenReturn((double) 1);
        Mockito.when(stringSimilarityMock.similarity("John Smith","Jane Smith")).thenReturn(0.7);
        Mockito.when(stringSimilarityMock.similarity("John Smith","Norman Reedus")).thenReturn(0.23076923076923078);

        //ISBN test mocks
        Mockito.when(stringSimilarityMock.similarity("1-234-56-7890","0-987-65-4321")).thenReturn(0.23);
        Mockito.when(stringSimilarityMock.similarity("1-234-56-7890","3-420-76-9158")).thenReturn(0.9);
        Mockito.when(stringSimilarityMock.similarity("1-234-56-7890","1-234-56-7890")).thenReturn((double) 1);
    }

    @Test
    @DisplayName("Title Search Test")
    public void titleSearchTest() {
        List<Book> actual = solidSearchResult.getSearchResultByTitle(bookList,"train dog");
        List<Book> expected = new ArrayList<>();
        Book b1 = new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(1993, 1, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png", 1,99.99);;
        Book b2 = new Book(2, "Train Life", 150, new Date(1962, 1, 1), "0-987-65-4321", "Jane Smith", "Nonfiction", "./trainlife.png", 1,50.50);
        expected.add(b2);
        expected.add(b1);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Author Search Test")
    public void authorSearchTest() {
        List<Book> actual = solidSearchResult.getSearchResultByAuthor(bookList,"John Smith");
        List<Book> expected = new ArrayList<>();
        Book b1 = new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(1993, 1, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png", 1,99.99);;
        Book b2 = new Book(2, "Train Life", 150, new Date(1962, 1, 1), "0-987-65-4321", "Jane Smith", "Nonfiction", "./trainlife.png", 1,50.50);
        expected.add(b1);
        expected.add(b2);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("ISBN Search Test")
    public void isbnSearchTest() {
        List<Book> actual = solidSearchResult.getSearchResultByISBN(bookList,"1-234-56-7890");
        List<Book> expected = new ArrayList<>();
        Book b1 = new Book(1, "How to Train Your Dog and Make it Love You", 300, new Date(1993, 1, 1), "1-234-56-7890", "John Smith", "Nonfiction", "./dogbook.png", 1,99.99);;
        Book b3 = new Book(3, "Legends of Hawaiian Mythology", 700, new Date(2019, 1, 1), "3-420-76-9158", "Norman Reedus", "Mythology", "./legends.png", 1,119.99);
        expected.add(b1);
        expected.add(b3);
        Assertions.assertEquals(expected,actual);
    }
}
