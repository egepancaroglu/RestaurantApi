package com.restaurantapi.services;

import com.restaurantapi.models.Comments;
import com.restaurantapi.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    public Comments findById(Long id) {
        return commentsRepository.getById(id);
    }

    public Comments create(Comments comments) {
        return commentsRepository.save(comments);
    }

    public Comments update(Comments comments) {
        Comments update = commentsRepository.getById((long) comments.getId());
        if (update != null) {
            commentsRepository.save(comments);
            return update;
        }
        return comments;
    }

    public void deleteById(Long id) {
        commentsRepository.deleteById(id);
    }
}