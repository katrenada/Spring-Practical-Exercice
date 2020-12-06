package org.polytec.vermeg.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.polytec.vermeg.dao.BookDAO;
import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.service.BookService;




@ExtendWith ({MockitoExtension.class})
class BookTest {
	Book book;
	Date d = new Date (2020, 11,11);	
	@Mock
	private BookDAO bookdao;
	
	@InjectMocks
	private BookService bookservice;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllBooks() {
		List <Book> books = new ArrayList<Book>();
		books.add(new Book(1,"a","a",1,d)) ;
		books.add(new Book(2,"a","a",1,d)) ;
		books.add(new Book(3,"a","a",1,d)) ;		
		when(bookdao.getAllBook()).thenReturn(books);
		List<Book> books1 = bookservice.getAllBooks() ;
		assertEquals(books1, books, "sfljf");
	}

	private Object given(List<Book> allBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	void testGetBook() {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);

		bookdao.getBook((long) 1);
		long id=b.getId();
		when(bookdao.getBook(id)).thenReturn(b);

		assertEquals(bookdao.getBook((long) 1),bookservice.getBook((long) 1),"incorrecte");
	}

	@Test
	void testAddBook() {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		bookdao.addBook(b);;
		   verify(bookdao, times(1)).addBook(b);
	}

	@Test
	void testUpdateBook() {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Book b1= new Book(1, "LesParoles", "Jane", 1, d);
		bookdao.updateBook(b);
		verify(bookdao, times(1)).updateBook(b);
	}

	@Test
	void testDeleteBook() {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Long id =b.getId();
		bookdao.deleteBook(id);
	verify(bookdao, times(1)).deleteBook(id);
	}

}
