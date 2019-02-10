package com.mgrios.bookservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mgrios.bookservice.model.Book;
import com.mgrios.bookservice.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceApplicationTests {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void contextLoadsRepository() {
		assertThat(bookRepository).isNotNull();
	}
	
	@Test
	public void contextLoadsBooks() {
		
		assertThat(bookRepository.findAll()).isNotEmpty();
		
	}

	@Test
	public void contextLoadsAddBook() {
		//AddBook
		Book book = new Book();
		book.setAuthor("Anne Rice");
		book.setBauthor(false);
		book.setChapters(5);
		book.setStars(5);
		book.setTitle("Interview with the Vampire");
		
		assertThat(bookRepository.save(book)).isNotNull();
	}
	
	@Test
	public void contextLoadsEditBook() {
		//EditBook
		Optional<Book> book = bookRepository.findById(bookRepository.findAll().get(0).getId());
		book.get().setStars(3);
		assertThat(bookRepository.save(book.get())).isNotNull();
	}
	
	@Test
	public void contextLoadsDeleteBook() {
		//DeleteBook
		Book bookToDelete = bookRepository.findAll().get(0);
		bookRepository.delete(bookToDelete);
		assertThat(bookRepository.findById(bookToDelete.getId())).isNull();
	}
}

