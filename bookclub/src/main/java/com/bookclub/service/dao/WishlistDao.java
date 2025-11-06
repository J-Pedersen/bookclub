package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import java.util.List;

public interface WishlistDao {

    void add(WishlistItem entity);

    void update(WishlistItem entity);

    boolean remove(WishlistItem entity);

    boolean remove(String id);

    List<WishlistItem> list(String username);

    WishlistItem find(String key);
}