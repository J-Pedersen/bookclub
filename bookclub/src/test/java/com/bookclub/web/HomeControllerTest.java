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
  This is a Web Layer Test for the HomeController.
  It uses MockMvc to simulate an HTTP GET request to the home page ('/'),
  this verifies that the correct view is being returned and that the page
  is accessible.
 **/

@WebMvcTest(HomeController.class)
@AutoConfigureMockMvc(addFilters = false)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookOfTheMonthDao bookOfTheMonthDao;

    @Test
    void testShowHomeLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}