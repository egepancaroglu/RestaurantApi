package com.restaurantapi.services.impl;

import com.restaurantapi.models.Comments;
import com.restaurantapi.repositories.CommentsRepository;
import com.restaurantapi.services.CommentsService;

import java.util.List;

public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public List<Comments> getAll() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments findById(Long id) {
        return commentsRepository.getById(id);
    }

    @Override
    public Comments getById(Long id) {
        return commentsRepository.getById(id);
    }

    @Override
    public Comments create(Comments comments) {
        return commentsRepository.save(comments);
    }

    @Override
    public Comments update(Comments comments) {
        Comments foundComments = commentsRepository.getById(comments.getId());
        if (comments.getComment() != null) {
            foundComments.setComment(comments.getComment());
        }
        return commentsRepository.save(comments);
    }

    @Override
    public Comments deleteById(Long id) {
        Comments comments = commentsRepository.getById(id);
        if (comments != null) {
            commentsRepository.deleteById(id);
            return comments;
        }
        return comments;
    }

    @Override
    public String delete(Long id) {

        commentsRepository.deleteById(id);
        return "SUCCESS";
    }

}
