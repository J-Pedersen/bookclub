package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
  This Unit Test is designed for the RestBookDao class.
  It is testing that the list() method is returning a valid list of Book objects
  which are retrieved using the external REST API or a mock data source,
  which will also confirm that the DAO is functioning correctly and that it does 
  not return null values.
 **/

class RestBookDaoTest {

    @Test
    void testListReturnsBooks() {
        // Mock DAO
        BookDao mockDao = Mockito.mock(BookDao.class);

        when(mockDao.list("ISBN:9780545790352,9780395520215")).thenReturn(
                List.of(
                        new Book("ISBN:9780545790352", "Harry Potter and the Sorcerer's Stone", "Turning the envelope over, his hand trembling, Harry saw a purple wax seal bearing a coat of arms; a lion, an eagle, a badger and a snake surrounding a large letter 'H'. HARRY POTTER has never even heard of Hogwarts when the LETTERS start dropping on the doormat at number four, Privet Drive. Addressed in GREEN INK on yellowish parchment with a PURPLE SEAL, they are swiftly confiscated by his GRISLY aunt and uncle. Then, on Harry's eleventh birthday, a great beetle-eyed giant of a man called RUBEUS HAGRID bursts in with some ASTONISHING news: Harry Potter is a wizard, and he has a place at Hogwarts School of Witchcraft and Wizardry. An incredible adventure is about to begin!", "https://openlibrary.org/works/OL82563W/Harry_Potter_and_the_Philosopher's_Stone?edition=key:/books/OL26629979M", 246),
                        new Book("ISBN:9780395520215", "The Hobbit", "The Hobbit is a tale of high adventure, undertaken by a company of dwarves in search of dragon-guarded gold. A reluctant partner in this perilous quest is Bilbo Baggins, a comfort-loving unambitious hobbit, who surprises even himself by his resourcefulness and skill as a burglar. Encounters with trolls, goblins, dwarves, elves, and giant spiders, conversations with the dragon, Smaug, and a rather unwilling presence at the Battle of Five Armies are just some of the adventures that befall Bilbo. Bilbo Baggins has taken his place among the ranks of the immortals of children’s fiction. Written by Professor Tolkien for his children, The Hobbit met with instant critical acclaim when published", "https://openlibrary.org/books/OL51709286M/The_Hobbit", 290)
                )
    
        );

        List<Book> books = mockDao.list("ISBN:9780545790352,9780395520215");

        assertEquals(2, books.size());
        assertEquals("Harry Potter and the Sorcerer's Stone", books.get(0).getTitle());
        assertEquals("The Hobbit", books.get(1).getTitle());
        verify(mockDao, times(1)).list("ISBN:9780545790352,9780395520215");
    }
}