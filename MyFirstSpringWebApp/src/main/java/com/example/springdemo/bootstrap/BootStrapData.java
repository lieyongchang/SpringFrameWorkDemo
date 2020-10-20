package com.example.springdemo.bootstrap;

import com.example.springdemo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springdemo.domain.*;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository publisherRepo;
	
	
	public BootStrapData(AuthorRepository authorRepo,
			             BookRepository bookRepo,
			             PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author dan = new Author("Dan", "Brown");
		Book topSeller = new Book("AngelsAndDemons","12312312");
		Publisher publisher = new Publisher();
		
		publisher.setName("yongchang");
		publisher.setAddress("BoonLay");
		publisher.setCity("Singapore");
		publisher.setState("Singapore");
		publisher.setZip("640185");
		
		
		dan.getBooks().add(topSeller);
		topSeller.getAuthors().add(dan);
		
		topSeller.setPublisher(publisher);
		publisher.getBooks().add(topSeller);

//		publisher = publisherRepo.save(publisher);
//		dan = authorRepo.save(dan);
//		topSeller = bookRepo.save(topSeller);

		
		System.out.println("count: " + bookRepo.count());
		System.out.println("count: " + publisher.getBooks().size());
	}

}
