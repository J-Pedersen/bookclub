package com.bookclub.web;

import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.service.impl.RestBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.List;
import java.util.StringJoiner;

@Controller
@RequestMapping("/")
public class HomeController {

    private BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {

        Calendar cal = Calendar.getInstance();
        int calMonth = cal.get(Calendar.MONTH) + 1;

        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));

        if (monthlyBooks.isEmpty()) {
            model.addAttribute("books", List.of());
            return "index";
        }

        StringJoiner isbnJoiner = new StringJoiner(",", "ISBN:", "");
        for (BookOfTheMonth monthlyBook : monthlyBooks) {
            if (monthlyBook.getIsbn() != null && !monthlyBook.getIsbn().isBlank()) {
                isbnJoiner.add(monthlyBook.getIsbn().trim());
            }
        }

        String isbnString = isbnJoiner.toString();

        RestBookDao bookDao = new RestBookDao();
        List<Book> books = bookDao.list(isbnString);

        model.addAttribute("books", books);

        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        RestBookDao bookDao = new RestBookDao();
        Book book = bookDao.find(id);
        model.addAttribute("book", book);
        return "monthly-books/view";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs() {
        return "about";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs() {
        return "contact";
    }
}