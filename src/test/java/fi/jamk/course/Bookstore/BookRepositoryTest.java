package fi.jamk.course.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.jamk.course.Bookstore.domain.Book;
import fi.jamk.course.Bookstore.domain.BookRepository;
import fi.jamk.course.Bookstore.domain.Category;
import fi.jamk.course.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
    @Autowired
    private BookRepository repository;
    private CategoryRepository crepository;

  
    @Test
    public void createNewBook() {
    	Book book = new Book ("Kiirastuli", "Ilkka Remes", "2016", "1234567890", "23.95", new Category("Dekkari"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void deleteBook() {
        List<Book> books = repository.findByAuthor("Ilkka Remes");
        assertThat(books).hasSize(2);
		repository.deleteById(books.get(0).getId());
		books = repository.findByAuthor("Ilkka Remes");
        assertThat(books).hasSize(1);
    }
    
    @Test
    public void searchBooks() {
    	List<Book> books = (List<Book>) repository.findAll();
        assertThat(books).hasSize(2);
    }

}
