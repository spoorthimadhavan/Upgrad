package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;
import com.upgrad.ImageHoster.service.TagService;
import com.upgrad.ImageHoster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/image/{id}/comments/create")
    public String showImage1() {


        return "redirect:/";
    }

    @RequestMapping(value="/image/{id}/comments/create" ,method= RequestMethod.POST)
    public String showImage(@PathVariable int id,
                            @RequestParam("comment") String text,HttpSession session,
                            Model model) {


        User currUser = (User) session.getAttribute("currUser");
        Comment comment=new Comment(text,id);
        commentService.save(comment);
        List<Comment> comments=commentService.getById(id);
        model.addAttribute("comment",comments);
        return "redirect:/images/"+id;
    }
}
