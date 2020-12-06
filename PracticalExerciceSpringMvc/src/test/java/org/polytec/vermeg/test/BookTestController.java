package org.polytec.vermeg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.polytec.vermeg.controller.BookController;
import org.polytec.vermeg.controller.BookController;
import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
@ExtendWith ({MockitoExtension.class})
class BookTestController {
	Book book;
	@Autowired
	private MockMvc mockMvc;
	Date d =new Date(2020-12-12);
	@Mock
	private BookService bookservice;
	@InjectMocks
	private BookController bookController;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
		
		
		//MockitoAnnotations.initMocks(this);
	  //  this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetBooks() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Book b1= new Book(1, "LesParoles", "Jane", 1, d);
		List <Book> books = new ArrayList<Book>();
		books.add(b) ;
		books.add(b1) ;
		when(bookservice.getAllBooks()).thenReturn(books);
		this.mockMvc.perform(get("/api/book/getAll"))
		.andExpect(status().isOk())
		.andDo(print());
		
	}

	@Test
	void testGetBookById() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		long idBook=b.getId();
		when(bookservice.getBook(idBook)).thenReturn(b);
		this.mockMvc.perform(get("/api/book/getBook/"+idBook))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testAddBook() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		bookservice.addBook(b);;
		   verify(bookservice, times(1)).addBook(b);
	
	 this.mockMvc.perform(post("/api/book/addBook"))
			.andExpect(status().isOk())
			.andDo(print());
	}

	@Test
	void testUpdateBook() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Book b1= new Book(1, "LesParoles", "Jane", 1, d);
		Long idBook =b.getId();
		bookservice.updateBook(b);
		verify(bookservice, times(1)).updateBook(b);
		 this.mockMvc.perform(put("/api/book/updateBook/"+idBook))
		  .andExpect(status().isOk())
		   .andDo(print());
	}

	@Test
	void testDeleteBook() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Long idBook =b.getId();
		bookservice.deleteBook(idBook);
	verify(bookservice, times(1)).deleteBook(idBook);
    this.mockMvc.perform(delete("/api/book/deleteBook/"+idBook))
	  .andExpect(status().isOk())
	   .andDo(print());
	}

}
