package com.mustafa.controller;

import com.mustafa.entity.Comment;
import com.mustafa.repository.CommentRepository;

import java.util.List;
import java.util.Scanner;

public class CommentController {
    Comment comment;
    private CommentRepository commentRepository;
    public CommentController(){
        this.commentRepository=new CommentRepository();
    }
    public void commentpaylas(Long userid,Long postid){
        System.out.println("*********************************");
        System.out.println("**     Yorumunuzu giriniz.     **");
        String yorum = new Scanner(System.in).nextLine();
        Long time = System.currentTimeMillis();
        comment = new Comment(userid,postid,yorum,time);
        commentRepository.save(comment);

    }


    public void commentGoruntule(Long id){
        List<Comment> comments = commentRepository.findbyIdAll(id);

        if (!comments.isEmpty()) {
            System.out.println("************ COMMENTS *************");
            for(Comment comment : comments){
                System.out.println("Yorum : "+comment.getCommenttext());
                System.out.println("Paylaşım Tarihi : "+comment.getCommentdate());
            }
        }else{
            System.out.println("Henüz bir yorum yapılmamıştır.");
        }
    }


}
