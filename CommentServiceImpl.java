package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.common.CommentManager;
import com.upgrad.ImageHoster.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    public CommentManager commentManager;

    public CommentServiceImpl()
    {
        commentManager=new CommentManager();
    }

    @Override
    public List<Comment> getAll() {
        return commentManager.getAllComments();
    }

    @Override
    public List<Comment> getById(int id) {
        return commentManager.getById(id);
    }

    @Override
    public void save(Comment comment) {
        commentManager.saveComment(comment);
    }
}
