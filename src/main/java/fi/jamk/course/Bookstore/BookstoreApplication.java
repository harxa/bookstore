package fi.jamk.course.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jamk.course.Bookstore.domain.Book;
import fi.jamk.course.Bookstore.domain.BookRepository;
import fi.jamk.course.Bookstore.domain.Category;
import fi.jamk.course.Bookstore.domain.CategoryRepository;
import fi.jamk.course.Bookstore.domain.User;
import fi.jamk.course.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoAdd(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return(args) ->{
			
			crepository.save(new Category("Dekkari"));
			crepository.save(new Category("Tietokirja"));
			crepository.save(new Category("Sarjakuva"));
			
			Book b1 = new Book ("Isku Ytimeen", "Ilkka Remes", "2002", "1234567890", "23.95", crepository.findByName("Dekkari").get(0));
			Book b2 = new Book ("Shokkiaalto", "Ilkka Remes", "2001", "1234567880", "21.55", crepository.findByName("Dekkari").get(0));
			
			repository.save(b1);
			repository.save(b2);
			
			// Create users: user/user, useri/useri, admin/admin 
			User user1 = new User("user", "$2a$10$UBii/e.Wy3sx5HiWgpfj7edVYR/e/zTuAoKP5bHZeFJcRe7WsIEz6", "user@email.me", "USER");
			User user2 = new User("useri", "$2a$10$ti4io24XeSDi8WSbEAl6Ce1L/7zuA0rpId3jCiRmNZm2jxMcFGmRG", "useri@email.me", "USER");
			User user3 = new User("admin", "$2a$10$SzTnZOy1xTkAKGb4aItDDuPEgJcyGF8q4mIXDAYSvhvLRGb/Q7gqG", "admin@email.me", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
		};
	}
	
}
