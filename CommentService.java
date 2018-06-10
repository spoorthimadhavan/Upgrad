package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.model.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getAll();
    public List<Comment> getById(int id);
    void save(Comment comment);

}
