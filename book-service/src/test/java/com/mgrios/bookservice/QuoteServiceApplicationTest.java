package com.mgrios.bookservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mgrios.bookservice.model.Book;
import com.mgrios.bookservice.model.Quote;
import com.mgrios.bookservice.repository.BookRepository;
import com.mgrios.bookservice.repository.QuoteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuoteServiceApplicationTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Test
	public void contextLoads() {
		assertThat( quoteRepository).isNotNull();
	}
	
	@Test
	public void contextLoadsQuotes() {
		//LoadsQuotes
		assertThat(quoteRepository.findAll()).isNotEmpty();
	}

	@Test
	public void contextLoadsAddQuote() {
		//AddQuote
		Book bookToQuote = bookRepository.findAll().get(0);
		Quote quote = new Quote();
		quote.setBook(bookToQuote);
		quote.setQuote("If you hide your ignorance, no one will hit you and you'll never learn.");
		quote.setStars(5);
		assertThat(quoteRepository.save(quote)).isNotNull();
	}
	
	@Test
	public void contextLoadsEditQuote() {
		//EditQuote
		Quote quoteEdit = quoteRepository.findAll().get(0);
		quoteEdit.setStars(3);
		assertThat( quoteRepository.save(quoteEdit) ).isNotNull(); 
	}
	
	@Test
	public void contextLoadsDeleteQuote() {
		//DeleteQuote
		Quote quoteEdit = quoteRepository.findAll().get(0);
		quoteRepository.delete(quoteEdit);
		assertThat( quoteRepository.findById(quoteEdit.getId()) ).isEmpty();
	}
	
}
