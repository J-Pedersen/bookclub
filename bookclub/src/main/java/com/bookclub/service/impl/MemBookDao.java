package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {
        this.books = new ArrayList<Book>();
        this.books.add(new Book("9780048230690", "The Hobbit", "Bilbo Baggins, a reluctant hobbit, is swept into an adventure with Gandalf and thirteen dwarves to reclaim their mountain home from the dragon Smaug, discovering courage and cunning within himself.", 300, new ArrayList<>(List.of("J.R.R. Tolkien"))));
        this.books.add(new Book("9780547928210", "The Fellowship of the Ring", "The first part of The Lord of the Rings introduces Frodo Baggins, who inherits the One Ring—a weapon of immense evil. With a fellowship of companions, he embarks on a perilous journey to destroy it in the fires of Mount Doom.", 423, new ArrayList<>(List.of("J.R.R. Tolkien"))));
        this.books.add(new Book("9780547928203", "The Two Towers", "The fellowship is broken: Frodo and Sam continue toward Mordor with the treacherous Gollum, while Aragorn, Legolas, and Gimli pursue enemies across Middle-earth. Battles rage as the fate of the world hangs in balance.", 352, new ArrayList<>(List.of("J.R.R. Tolkien"))));
        this.books.add(new Book("9780547928197", "The Return of the King", "The climactic conclusion of The Lord of the Rings, where armies clash for Middle-earth, Aragorn embraces his destiny, and Frodo faces the ultimate test to destroy the Ring and end Sauron’s power.", 432, new ArrayList<>(List.of("J.R.R. Tolkien"))));
        this.books.add(new Book("9780064471190", "The Lion, the Witch and the Wardrobe", "Four siblings step through a wardrobe into Narnia, a magical land under the rule of the White Witch. With the help of Aslan the lion, they must fight to restore peace and break winter’s curse.", 208, new ArrayList<>(List.of("C.S. Lewis"))));
        this.books.add(new Book("9780064471053", "Prince Caspian", "The Pevensies return to Narnia, finding centuries have passed. They aid Prince Caspian in reclaiming his throne from his corrupt uncle and awaken the land’s ancient magic.", 240, new ArrayList<>(List.of("C.S. Lewis"))));
        this.books.add(new Book("9780064471084", "The Voyage of the Dawn Treader", "Lucy, Edmund, and Eustace join King Caspian aboard the Dawn Treader, sailing east in search of seven lost lords. Along the way, they encounter wonders, dragons, and the edge of the world itself.", 271, new ArrayList<>(List.of("C.S. Lewis"))));
        this.books.add(new Book("9780064471046", "The Silver Chair", "Eustace and Jill embark on a mission given by Aslan to rescue Prince Rilian, held captive in an underground kingdom, encountering giants, gnomes, and dark enchantments.", 243, new ArrayList<>(List.of("C.S. Lewis"))));
        this.books.add(new Book("9780064471107", "The Horse and His Boy", "In a standalone tale set during the Pevensies’ reign in Narnia, a runaway boy and a talking horse flee to the north, uncovering a plot to invade the free lands.", 241, new ArrayList<>(List.of("C.S. Lewis"))));
        this.books.add(new Book("9780064471077", "The Magician’s Nephew", "A prequel to the series, telling the story of Narnia’s creation, the rise of the White Witch, and how the wardrobe became a gateway between worlds.", 202, new ArrayList<>(List.of("C.S. Lewis"))));
        this.books.add(new Book("9780064471084", "The Last Battle", "The final chapter in Narnia’s history, where treachery, deception, and a false Aslan lead to the ultimate confrontation between good and evil as the world of Narnia ends.", 211, new ArrayList<>(List.of("C.S. Lewis"))));
        this.books.add(new Book("9780747532743", "Harry Potter and the Philosopher’s Stone", "On his eleventh birthday, Harry Potter discovers he is a wizard and attends Hogwarts School of Witchcraft and Wizardry, where he uncovers the truth about his parents’ mysterious deaths and faces the dark wizard who killed them.", 223, new ArrayList<>(List.of("J.K. Rowling"))));
        this.books.add(new Book("9780439064873", "Harry Potter and the Chamber of Secrets", "In his second year at Hogwarts, Harry encounters strange whispers in the walls, a deadly monster roaming the school, and the hidden Chamber of Secrets tied to the school’s founder.", 341, new ArrayList<>(List.of("J.K. Rowling"))));
        this.books.add(new Book("9780439136365", "Harry Potter and the Prisoner of Azkaban", "Danger looms as Sirius Black, a convicted murderer, escapes from Azkaban. Harry learns unsettling truths about his family and the betrayal that shaped his past.", 435, new ArrayList<>(List.of("J.K. Rowling"))));
        this.books.add(new Book("9780439139601", "Harry Potter and the Goblet of Fire", "When Harry’s name mysteriously emerges from the Goblet of Fire, he is thrust into the deadly Triwizard Tournament, facing dragons, mermaids, and dark conspiracies leading to the return of Voldemort.", 734, new ArrayList<>(List.of("J.K. Rowling"))));
        this.books.add(new Book("9780439358071", "Harry Potter and the Order of the Phoenix", "As Voldemort gains power, Harry battles the Ministry of Magic’s denial of the threat. Secret lessons with Dumbledore’s Army prepare students for the battles to come.", 870, new ArrayList<>(List.of("J.K. Rowling"))));
        this.books.add(new Book("9780439785969", "Harry Potter and the Half-Blood Prince", "Dark magic spreads across the wizarding world as Harry learns of Voldemort’s Horcruxes. Meanwhile, a mysterious textbook belonging to the ‘Half-Blood Prince’ holds secrets of its own.", 652, new ArrayList<>(List.of("J.K. Rowling"))));
        this.books.add(new Book("9780545139700", "Harry Potter and the Deathly Hallows", "Harry, Ron, and Hermione set out on a dangerous quest to destroy Voldemort’s Horcruxes. The fate of the wizarding world rests on their final confrontation at Hogwarts.", 759, new ArrayList<>(List.of("J.K. Rowling"))));
    }

    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }
}