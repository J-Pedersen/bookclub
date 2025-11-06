package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void update(WishlistItem entity) {
        if (entity.getId() == null || entity.getId().isEmpty()) {
            throw new IllegalArgumentException("Cannot update WishlistItem: id is null or empty");
        }

        WishlistItem wishlistItem = mongoTemplate.findById(entity.getId(), WishlistItem.class);

        if (wishlistItem != null) {
            wishlistItem.setIsbn(entity.getIsbn());
            wishlistItem.setTitle(entity.getTitle());
            wishlistItem.setPages(entity.getPages());
            wishlistItem.setAuthor(entity.getAuthor());
            wishlistItem.setUsername(entity.getUsername());

            mongoTemplate.save(wishlistItem);
        } else {
            mongoTemplate.save(entity);
        }
    }

    @Override
    public boolean remove(WishlistItem entity) {
        Query query = new Query();
    
        query.addCriteria(Criteria.where("id").is(entity.getId()));
    
        mongoTemplate.remove(query, WishlistItem.class);
    
        return true;
    }
    
    @Override
    public boolean remove(String id) {
        Query query = new Query();
    
        query.addCriteria(Criteria.where("id").is(id));
    
        mongoTemplate.remove(query, WishlistItem.class);
    
        return true;
    }

    @Override
    public List<WishlistItem> list(String username) {
        Query query = new Query();

        query.addCriteria(Criteria.where("username").is(username));

        return mongoTemplate.find(query, WishlistItem.class);
    }

    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}