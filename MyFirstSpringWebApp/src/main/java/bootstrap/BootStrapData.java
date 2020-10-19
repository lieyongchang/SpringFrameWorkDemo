package bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import domain.*;
import repository.*;

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
		
		authorRepo.save(dan);
		bookRepo.save(topSeller);
		publisherRepo.save(publisher);
		
		
		System.out.print("count: " + bookRepo.count());
		System.out.print("count: " + publisher.getBooks().size());
	}

}
