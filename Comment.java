package com.upgrad.ImageHoster.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @ManyToOne(fetch = FetchType.EAGER)
    private Image image;

   // @ManyToOne(fetch = FetchType.LAZY)
    //private User user;

    @Column
    private String text;

    public int imageId;

    public Comment(String comment) {
        this.text = comment;

    }
    public Comment(String comment, int imageId)
    {
        this.text = comment;
        this.imageId=imageId;

    }

    public Comment() {

    }
    public void setId(int id) {
        this.id = id;

    }

    public void setComment(String comment) {
        this.text = comment;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return text;
    }
}
