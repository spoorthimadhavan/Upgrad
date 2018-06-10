package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class CommentManager extends SessionManager{

    public List<Comment> getAllComments() {
        Session session = openSession();
        List<Comment> comments = session.createCriteria(Comment.class).list();
        commitSession(session);

        return comments;
    }

    public void saveComment(final Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
    }
    public List<Comment> getById(int id)
    {
        Session session = openSession();

        try {
            List<Comment> comment = session.createCriteria(Comment.class)
                    .add(Restrictions.eq("id", id)).list();

            commitSession(session);

            return comment;
        } catch(HibernateException e) {
            System.out.println("unable to retrieve an image from database by its title");
        }

        return null;
    }
}
