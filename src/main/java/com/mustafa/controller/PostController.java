package com.mustafa.controller;

import com.mustafa.entity.Post;
import com.mustafa.repository.PostRepository;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PostController {
    Post post;

    private PostRepository postRepository;

    public PostController(){
        this.postRepository=new PostRepository();
    }

    public  void postlarimiGoruntule(Long id) {
        List<Post> posts = postRepository.findbyIdAll(id);

        if (!posts.isEmpty()) {
            System.out.println("********** POSTLARIM **********");
            for (Post post : posts) {
                System.out.println("Başlık...: " +post.getTitle());
                System.out.println("Aciklama...: " +post.getPostcomment());
                System.out.println("Paylaşım Tarihi...: " +new Date(post.getShareddate()));
                System.out.println("Resim...: " +post.getImageurl());
                System.out.println("Beğeni Sayısı...: " +post.getLikeCount());
                System.out.println("Yorum Sayısı...: " +post.getCommentCount());
                System.out.println("*****************************************");
                System.out.println();
            }
        } else {
            System.out.println("Henüz post bulunmamaktadır.");
        }
    }

    public void postPaylas(Long id,String user) {
        System.out.println("        ******************************");
        System.out.println("        ***** "+user+" Paylaşmak istediğin post başlığını giriniz *****");
        System.out.println("        ******************************");
        String baslik =  new Scanner(System.in).nextLine();
        System.out.println("Açiklama giriniz");
        String aciklama = new Scanner(System.in).nextLine();
        Long time = System.currentTimeMillis();
        post = new Post(id,baslik,aciklama, time,"",0,0);
        postRepository.save(post);



    }

    public void tumPostlariGoruntule() {
        List<Post> posts = postRepository.findAll();

        if (!posts.isEmpty()) {
            System.out.println("********** POSTLAR **********");
            for (Post post : posts) {
                System.out.println(postRepository.findNamebyPost(post.getUserid())+ " nın postu...");
                System.out.println("Başlık...: " +post.getTitle());
                System.out.println("Aciklama...: " +post.getPostcomment());
                System.out.println("Paylaşım Tarihi...: " +new Date(post.getShareddate()));
                System.out.println("Resim...: " +post.getImageurl());
                System.out.println("Beğeni Sayısı...: " +post.getLikeCount());
                System.out.println("Yorum Sayısı...: " +post.getCommentCount());
                System.out.println("*******************************************");
                System.out.println();
            }
        } else {
            System.out.println("Henüz post bulunmamaktadır.");
        }
    }
}
