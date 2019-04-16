package com.mgrios.bookservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgrios.bookservice.exception.ResourceNotFoundException;
import com.mgrios.bookservice.model.Quote;
import com.mgrios.bookservice.repository.BookRepository;
import com.mgrios.bookservice.repository.QuoteRepository;

@RestController
public class QuoteController {

	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/books/{bookId}/quotes")
	public List<Quote> getQuotesByBookId(@PathVariable Long bookId){
		return quoteRepository.findByBookId(bookId);
	}
	
	@PostMapping("/books/{bookId}/quote")
	public Quote addQuote(@PathVariable Long bookId,
			@Valid @RequestBody Quote quote) {
		return bookRepository.findById(bookId)
				.map(book -> {
					quote.setBook(book);
					return quoteRepository.save(quote);
				}).orElseThrow(() -> new ResourceNotFoundException("Book not found with Id" + bookId));
	}
	
	@PutMapping("/books/{bookId}/quotes/{quoteID}")
	public Quote updateQuote(@PathVariable Long bookId, 
			@PathVariable Long quoteId,
			@Valid @RequestBody Quote quoteRequest) {
		
		if(!bookRepository.existsById(bookId)) {
			throw new ResourceNotFoundException("Book not found with Id " + bookId);
		}
		
		return quoteRepository.findById(quoteId)
				.map(quote -> {
					quote.setQuote(quoteRequest.getQuote());
					quote.setStars(quoteRequest.getStars());
					return quoteRepository.save(quote);
				}).orElseThrow(() -> new ResourceNotFoundException("Quote not found with Id " + quoteId));
	}
	
	@DeleteMapping("/books/{bookId}/quote/{quoteId}")
	public ResponseEntity<?> deleteQuote(@PathVariable Long bookId,
			@PathVariable Long quoteId){
		if(!bookRepository.existsById(bookId)) {
			throw new ResourceNotFoundException("Book not found with Id " + bookId);
		}
		
		return quoteRepository.findById(quoteId)
				.map(quote -> {
					quoteRepository.delete(quote);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Quote not found with Id" + quoteId));
	}
}
