package com.mgrios.bookservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book extends AuditModel{

	private static final long serialVersionUID = -5132209373902019643L;

	@Id
	@GeneratedValue(generator = "book_generator")
	@SequenceGenerator(
			name = "book_generator",
			sequenceName = "book_sequence",
			initialValue = 1
			)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 250)
	private String title;
	
	@NotBlank
	@Size(min = 3, max = 250)
	private String author;
	
	@Column(columnDefinition = "integer")
	private int chapters;
	
	@Column(columnDefinition = "integer")
	private int stars;
	
	@Column(columnDefinition = "boolean")
	private boolean bauthor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getChapters() {
		return chapters;
	}

	public void setChapters(int chapters) {
		this.chapters = chapters;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public boolean isBauthor() {
		return bauthor;
	}

	public void setBauthor(boolean bauthor) {
		this.bauthor = bauthor;
	}

	
	
}
