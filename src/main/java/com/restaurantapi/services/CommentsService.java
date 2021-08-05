package com.restaurantapi.services;

import com.restaurantapi.models.entity.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentsService {

    Comments create(Comments comments);

    List<Comments> getAll();

    Comments getById(Long id);

    Comments update(Comments comments);

    Comments deleteById(Long id);

    Comments findById(Long id);

    String delete(Long id);

    List<Comments> findAll();

}