package com.mgrios.bookservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgrios.bookservice.exception.ResourceDuplicated;
import com.mgrios.bookservice.exception.ResourceNotFoundException;
import com.mgrios.bookservice.model.Book;
import com.mgrios.bookservice.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/books")
	public Page<Book> getBooks(Pageable pageable){
		return bookRepository.findAll(pageable);
	}
	
	@PostMapping("/book")
	public Book createBook(@Valid @RequestBody Book book) {
		if(bookRepository.existsByTitle(book.getTitle())) {
			throw new ResourceDuplicated("The book " + book.getTitle() + " is already inserted");
		}
		return bookRepository.save(book);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@PathVariable Long bookId,
			@Valid @RequestBody Book bookRequest) {
		return bookRepository.findById(bookId)
				.map(book -> {
					book.setTitle(bookRequest.getTitle());
					book.setAuthor(bookRequest.getAuthor());
					book.setChapters(bookRequest.getChapters());
					book.setStars(bookRequest.getStars());
					book.setBauthor(bookRequest.isBauthor());
					return bookRepository.save(book);
				}).orElseThrow(() -> new ResourceNotFoundException("Book not found with Id " + bookId ));
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId){
		return bookRepository.findById(bookId)
				.map( book -> {
					bookRepository.delete(book);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Book not found with ID " + bookId));
	}
}
