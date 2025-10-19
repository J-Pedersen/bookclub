package com.bookclub.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wishlist")
public class WishlistItem
{
    @Id
    private String id;

    @NotNull
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    @NotNull
    @NotEmpty(message = "Title is a required field.")
    private String title;

    @NotNull(message = "Pages is a required field.")
    @Min(value = 1, message = "Pages must be greater than zero.")
    private Integer pages;

    @NotNull
    @NotEmpty(message = "Author is a required field.")
    private String author;

    public WishlistItem() {}

    public WishlistItem(String isbn, String title, Integer pages, String author) {
        this.isbn = isbn;
        this.title = title;
        this.pages = pages;
        this.author = author;   
    }

    public String getId() {
        return id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

        public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPages() {
        return pages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format(
            "WishlistItem{id=%s, isbn=%s, title=%s, pages=%d,author=%s}",
            id, isbn, title, pages, author
        );
    }
}