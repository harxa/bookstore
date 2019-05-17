package fi.jamk.course.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jamk.course.Bookstore.domain.Book;
import fi.jamk.course.Bookstore.domain.BookRepository;
import fi.jamk.course.Bookstore.domain.Category;
import fi.jamk.course.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoAdd(BookRepository repository, CategoryRepository crepository) {
		return(args) ->{
			
			crepository.save(new Category("Dekkari"));
			crepository.save(new Category("Tietokirja"));
			crepository.save(new Category("Sarjakuva"));
			
			Book b1 = new Book ("Isku Ytimeen", "Ilkka Remes", "2002", "1234567890", "23.95", crepository.findByName("Dekkari").get(0));
			Book b2 = new Book ("Shokkiaalto", "Ilkka Remes", "2001", "1234567880", "21.55", crepository.findByName("Dekkari").get(0));
			
			repository.save(b1);
			repository.save(b2);
		};
	}
	
}
