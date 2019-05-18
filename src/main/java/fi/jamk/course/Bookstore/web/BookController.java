package fi.jamk.course.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.jamk.course.Bookstore.domain.Book;
import fi.jamk.course.Bookstore.domain.BookRepository;
import fi.jamk.course.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository; 
	
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String greetings(Model model) {
        return "index";
    }
    
    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String BookList(Model model) {
    	model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    @RequestMapping(value="/book/{id}", method=RequestMethod.GET)
    public String oneBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("books", repository.findById(bookId));
        return "booklist";
    }
    
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categorys", crepository.findAll());
		return "addbook";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }
    
    @RequestMapping(value="/editBook", method = RequestMethod.POST)
    public String editBookList(Book book) {
    	//model.addAttribute("book", model);
    	repository.save(book);
        //model.addAttribute("books", repository.findAll());
        return "redirect:booklist";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
} 
    
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    } 
}
