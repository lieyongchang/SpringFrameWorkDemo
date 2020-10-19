package domain;

import java.util.*;
import javax.persistence.*;

import org.springframework.data.annotation.Id;

public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	@OneToMany
	@JoinColumn(name="publisher_id")
	private Set<Book> books = new HashSet<>();
	
	public Publisher() {
		
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}



	public Set<Book> getBooks() {
		return books;
	}



	public void setBooks(Set<Book> books) {
		this.books = books;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}
}
