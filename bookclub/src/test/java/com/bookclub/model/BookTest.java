package com.bookclub.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
  This Unit Test is designed for the Book model class.
  It verifies that the Book class is correctly setting and retrieving the data fields
  such as the ISBN, book title, num of pages, and author, and that its behavior
  is functioning as expected.
 **/

class BookTest {

    @Test
    void testBookConstructorAndGetters() {
        Book book = new Book("ISBN:9780395520215", "The Hobbit", "The Hobbit is a tale of high adventure, undertaken by a company of dwarves in search of dragon-guarded gold. A reluctant partner in this perilous quest is Bilbo Baggins, a comfort-loving unambitious hobbit, who surprises even himself by his resourcefulness and skill as a burglar. Encounters with trolls, goblins, dwarves, elves, and giant spiders, conversations with the dragon, Smaug, and a rather unwilling presence at the Battle of Five Armies are just some of the adventures that befall Bilbo. Bilbo Baggins has taken his place among the ranks of the immortals of children’s fiction. Written by Professor Tolkien for his children, The Hobbit met with instant critical acclaim when published",
                             "https://openlibrary.org/books/OL51709286M/The_Hobbit", 290);

        assertEquals("ISBN:9780395520215", book.getIsbn());
        assertEquals("The Hobbit", book.getTitle());
        assertEquals("The Hobbit is a tale of high adventure, undertaken by a company of dwarves in search of dragon-guarded gold. A reluctant partner in this perilous quest is Bilbo Baggins, a comfort-loving unambitious hobbit, who surprises even himself by his resourcefulness and skill as a burglar. Encounters with trolls, goblins, dwarves, elves, and giant spiders, conversations with the dragon, Smaug, and a rather unwilling presence at the Battle of Five Armies are just some of the adventures that befall Bilbo. Bilbo Baggins has taken his place among the ranks of the immortals of children’s fiction. Written by Professor Tolkien for his children, The Hobbit met with instant critical acclaim when published", book.getDescription());
        assertEquals("https://openlibrary.org/books/OL51709286M/The_Hobbit", book.getInfoUrl());
        assertEquals(290, book.getNumOfPages());
    }

    @Test
    void testToStringContainsAllFields() {
        Book book = new Book("ISBN:9780545790352", "Harry Potter and the Sorcerer's Stone", "Turning the envelope over, his hand trembling, Harry saw a purple wax seal bearing a coat of arms; a lion, an eagle, a badger and a snake surrounding a large letter 'H'. HARRY POTTER has never even heard of Hogwarts when the LETTERS start dropping on the doormat at number four, Privet Drive. Addressed in GREEN INK on yellowish parchment with a PURPLE SEAL, they are swiftly confiscated by his GRISLY aunt and uncle. Then, on Harry's eleventh birthday, a great beetle-eyed giant of a man called RUBEUS HAGRID bursts in with some ASTONISHING news: Harry Potter is a wizard, and he has a place at Hogwarts School of Witchcraft and Wizardry. An incredible adventure is about to begin!",
                             "https://openlibrary.org/works/OL82563W/Harry_Potter_and_the_Philosopher's_Stone?edition=key:/books/OL26629979M", 246);

        String toStringOutput = book.toString();

        assertTrue(toStringOutput.contains("ISBN:9780545790352"));
        assertTrue(toStringOutput.contains("Harry Potter and the Sorcerer's Stone"));
        assertTrue(toStringOutput.contains("Turning the envelope over, his hand trembling, Harry saw a purple wax seal bearing a coat of arms; a lion, an eagle, a badger and a snake surrounding a large letter 'H'. HARRY POTTER has never even heard of Hogwarts when the LETTERS start dropping on the doormat at number four, Privet Drive. Addressed in GREEN INK on yellowish parchment with a PURPLE SEAL, they are swiftly confiscated by his GRISLY aunt and uncle. Then, on Harry's eleventh birthday, a great beetle-eyed giant of a man called RUBEUS HAGRID bursts in with some ASTONISHING news: Harry Potter is a wizard, and he has a place at Hogwarts School of Witchcraft and Wizardry. An incredible adventure is about to begin!"));
        assertTrue(toStringOutput.contains("https://openlibrary.org/works/OL82563W/Harry_Potter_and_the_Philosopher's_Stone?edition=key:/books/OL26629979M"));
        assertTrue(toStringOutput.contains("246"));
    }
}
