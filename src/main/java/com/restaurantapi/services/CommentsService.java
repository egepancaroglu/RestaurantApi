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

    public List<Comments> getAll() {
        return commentsRepository.findAll();
    }

    public Comments findById(Long id) {
        return commentsRepository.getById(id);
    }

    public Comments getById(Long id) {
        return commentsRepository.getById(id);
    }

    public Comments create(Comments comments) {
        return commentsRepository.save(comments);
    }

    public Comments update(Comments comments) {
        Comments foundComments = commentsRepository.getById(comments.getId());
        if (comments.getComment() != null) {
            foundComments.setComment(comments.getComment());
        }
        return commentsRepository.save(comments);
    }

    public Comments deleteById(Long id) {
        Comments comments = commentsRepository.getById(id);
        if (comments != null) {
            commentsRepository.deleteById(id);
            return comments;
        }
        return comments;
    }

    public String delete(long id) {

        commentsRepository.deleteById(id);
        return "SUCCESS";
    }
}