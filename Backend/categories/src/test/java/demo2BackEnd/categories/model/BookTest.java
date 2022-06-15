package demo2BackEnd.categories.model;

import demo2BackEnd.categories.model.BookCategory;
import demo2BackEnd.categories.model.MovieCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class BookTest {
    private long book_id;
    private String pic;
    private String name;
    private String description;
    private String author;
    private String release_date;
    private String ISBN_10;
    private String ISBN_13;
    private String place;
    private long score;
    private String price;
    private String language;
    private String publisher;
    private int pages;


    public BookTest(long book_id, String pic, String name, String description, String author, String release_date, String ISBN_10, String ISBN_13, String place, long score, String price, String language, String publisher, int pages) {
        this.book_id = book_id;
        this.pic = pic;
        this.name = name;
        this.description = description;
        this.author = author;
        this.release_date = release_date;
        this.ISBN_10 = ISBN_10;
        this.ISBN_13 = ISBN_13;
        this.place = place;
        this.score = score;
        this.price = price;
        this.language = language;
        this.publisher = publisher;
        this.pages = pages;
    }


    @Parameters
    public static Collection<Object[]> getParameters() {
        Collection<Object[]> retList = new ArrayList<Object[]>();
        try {
            Scanner in = new Scanner(new File("bookFile.txt"));
            while (in.hasNextLine()) {
                String l = in.nextLine();
                String dataArray[] = l.split(",");
                Object[] d = new Object[14];
                d[0] = Long.parseLong(dataArray[0]);
                d[1] = dataArray[1];
                d[2] = dataArray[2];
                d[3] = dataArray[3];
                d[4] = dataArray[4];
                d[5] = dataArray[5];
                d[6] = dataArray[6];
                d[7] = dataArray[7];
                d[8] = dataArray[8];
                d[9] = Long.parseLong(dataArray[9]);
                d[10] = dataArray[10];
                d[11] = dataArray[11];
                d[12] = dataArray[12];
                d[13] = Integer.parseInt(dataArray[13]);
                retList.add(d);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return retList;
    }

    @Test
    public void Book_test_1(){
        BookCategory book = new BookCategory(book_id, pic, name, description, author, release_date, ISBN_10, ISBN_13, place, score, price, language,publisher,pages);
        assertEquals("AnnaKarenina", book.getName());
        assertNotNull(book.getPic());
        assertEquals(1, book.getBook_id());
        assertNotNull(book.getName());
        assertEquals(8, book.getScore());
        assertNotNull(book.getPic());
        assertNotNull(book.getPrice());
        assertNotNull(book.getLanguage());
        assertNotNull(book.getPublisher());
        assertEquals("author", book.getAuthor());
        assertEquals("date", book.getRelease_date());
        assertEquals("isbn-10", book.getISBN_10());
        assertEquals("isbn-13", book.getISBN_13());
        assertEquals("place", book.getPlace());
        assertNotNull(book.getDescription());
        assertEquals("language", book.getLanguage());
        assertEquals("publisher", book.getPublisher());
        assertEquals("book",book.getDescription());
        assertEquals(311,book.getPages());

        book.setBook_id(11111);
        book.setISBN_13("isbn-13");
        book.setISBN_10("isbn-10");
        book.setPages(311);
        book.setDescription("description");
        book.setName("Name");
        book.setScore(5);
        book.setLanguage("chinese");
        book.setPlace("place");
        book.setRelease_date("date");
        book.setAuthor("author");
        book.setPic("pic");
        book.setPrice("111");
        book.setPublisher("pub");
    }

}