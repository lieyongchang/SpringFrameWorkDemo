package domain;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Author {

	private String firstName;
	private String lastName;
	private Set<Book> books;
	
	public Author() {}
	
	public Author(String firstName, String lastName, Set<Book> books){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBooks(books);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
