package domain;

import javax.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	private String title;
	private String isbn;
	
	@ManyToOne
	
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name = "author_books", 
	           joinColumns = @JoinColumn(name ="book_id"),
	           inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();
	
	
	public Book() {}
	
	public Book(String title, String isbn/*, Set<Author> authors*/) {
		this.setTitle(title);
		this.setIsbn(isbn);
//		this.setAuthors(authors);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}
