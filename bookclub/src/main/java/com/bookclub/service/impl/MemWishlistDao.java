package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {
    List<WishlistItem> wishlist;

    public MemWishlistDao() {
        this.wishlist = new ArrayList<WishlistItem>();
        this.wishlist.add(new WishlistItem("9780048230690", "The Hobbit"));
        this.wishlist.add(new WishlistItem("9780547928210", "The Fellowship of the Ring"));
        this.wishlist.add(new WishlistItem("9780547928203", "The Two Towers"));
        this.wishlist.add(new WishlistItem("9780547928197", "The Return of the King"));
        this.wishlist.add(new WishlistItem("9780064471190", "The Lion, the Witch and the Wardrobe"));
        this.wishlist.add(new WishlistItem("9780064471053", "Prince Caspian"));
        this.wishlist.add(new WishlistItem("9780064471084", "The Voyage of the Dawn Treader"));
        this.wishlist.add(new WishlistItem("9780064471046", "The Silver Chair"));
        this.wishlist.add(new WishlistItem("9780064471107", "The Horse and His Boy"));
        this.wishlist.add(new WishlistItem("9780064471077", "The Magician’s Nephew"));
        this.wishlist.add(new WishlistItem("9780064471084", "The Last Battle"));
        this.wishlist.add(new WishlistItem("9780747532743", "Harry Potter and the Philosopher’s Stone"));
        this.wishlist.add(new WishlistItem("9780439064873", "Harry Potter and the Chamber of Secrets"));
        this.wishlist.add(new WishlistItem("9780439136365", "Harry Potter and the Prisoner of Azkaban"));
        this.wishlist.add(new WishlistItem("9780439139601", "Harry Potter and the Goblet of Fire"));
        this.wishlist.add(new WishlistItem("9780439358071", "Harry Potter and the Order of the Phoenix"));
        this.wishlist.add(new WishlistItem("9780439785969", "Harry Potter and the Half-Blood Prince"));
        this.wishlist.add(new WishlistItem("9780545139700", "Harry Potter and the Deathly Hallows"));
    }

    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }

    @Override
    public WishlistItem find(String key) {
        for (WishlistItem item : wishlist) {
            if (item.getIsbn().equals(key)) {
                return item;
            }
        }
        return new WishlistItem();
    }
}