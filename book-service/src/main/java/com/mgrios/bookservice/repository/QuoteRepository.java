package com.mgrios.bookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgrios.bookservice.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long>{

	List<Quote> findByBookId(Long bookId);
}
