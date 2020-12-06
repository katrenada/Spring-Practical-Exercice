package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.Book;

import org.polytec.vermeg.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	BookService bookService;
	
//	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
//    public String sayHello(){
//        return "lll ";
//    }
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Book> getBooks() {
		
		List<Book> listOfBooks = bookService.getAllBooks();
		
		return listOfBooks;
	}
	
	@RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBook(id);
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBook(@ModelAttribute("book") Book book) {	
		if(book.getId()==0)
		{
			bookService.addBook(book);
		}
		else
		{	
			bookService.updateBook(book);
			
		}
		
		return "redirect:/getAllBooks";
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateBook(@PathVariable("id") long id,Book book) {
		System.out.println(book.getDate());
		bookService.updateBook(book);
		
		 return "redirect:/getAllBooks";
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		
		 return "redirect:/getAllBooks";

	}
	
	

}
