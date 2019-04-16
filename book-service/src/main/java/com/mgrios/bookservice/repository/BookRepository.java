package com.mgrios.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgrios.bookservice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	Boolean existsByTitle(String title);
}
