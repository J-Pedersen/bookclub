package com.bookclub.web;

import com.bookclub.service.dao.BookOfTheMonthDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
  This is a Web Layer Test for the HomeController's About Us page.
  It uses MockMvc to perform a GET request to '/about', This verifies that
  the correct 'about' view is being rendered.
 **/

@WebMvcTest(HomeController.class)
@AutoConfigureMockMvc(addFilters = false)
public class HomeControllerAboutTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookOfTheMonthDao bookOfTheMonthDao;

    @Test
    void testShowAboutUsPage() throws Exception {
        mockMvc.perform(get("/about"))
                .andExpect(status().isOk())
                .andExpect(view().name("about"));
    }
}