package fi.jamk.course.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class BookController {
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String greetings(Model model) {
        return "index";
    }
	
}
