package com.mustafa.controller;

import com.mustafa.entity.Post;
import com.mustafa.entity.User;
import com.mustafa.repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostController {

    private PostRepository postRepository;
    public PostController(){
        this.postRepository=new PostRepository();
    }
    public void yeniEkran(){
        System.out.println("***********************************************");
//        System.out.println("*******Hoşgeldin "+user.getAdsoyod()+"**********");
        System.out.println("***********************************************");
    }


    public void postlariGoruntule(User username){
        System.out.println("""
                        ***********************************
                        ********** POST LİSTESİ ***********
                        ***********************************
                
                """);
        Optional<Post> postOptinal = postRepository.findById(username.getId());
        if(postOptinal.isPresent()){
            System.out.println("Postlar : ");
        }else{
            System.out.println("Post bulunamadı");
        }

    }
}
