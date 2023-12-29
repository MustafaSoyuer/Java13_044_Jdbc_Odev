package com.mustafa.controller;

import com.mustafa.entity.User;
import com.mustafa.repository.UserRepository;

import java.util.*;

public class UserController {
    private UserRepository userRepository;
    public UserController(){
        this.userRepository = new UserRepository();
    }
    Queue<Optional<User>> userlist = new LinkedList<>();
    public void Login(){
        System.out.println("""
                    *************************************
                    ****      KULLANICI GIRIS      ******
                    *************************************
                
                """);
        System.out.print("Kullanıcı adı......: ");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Sifre......: ");
        String password = new Scanner(System.in).nextLine();
        Optional<User> userOptinal = userRepository.doLogin(username,password);
        userlist.add(userOptinal);
        userlist.peek();
        if(userOptinal.isPresent()){
            System.out.println("GIRIS YAPILDI.");
        }else{
            System.out.println("Kullanıcı adı ya da sifre hatalıdır.");
        }

    }
    public void Register(){
        System.out.println("""
                    *************************************
                    ****     YENI KULLANICI KAYDI   *****
                    *************************************
                
                """);
        System.out.print("Ad soyad.....: ");
        String adsoyad = new Scanner(System.in).nextLine();
        String username;
        boolean isUser;
        do{
            System.out.print("Kullanıcı adı.....: ");
            username= new Scanner(System.in).nextLine();
            isUser = userRepository.isUserName(username);
            if(isUser)
                System.err.println("Bu kullanıcı adı zaten kullanılıyor. Lütfen değiştirin");
        }while (isUser);

        System.out.print("Sifre.....: ");
        String password = new Scanner(System.in).nextLine();

        userRepository.isUserName(username);

        User user = new User(adsoyad,username,password,"");
        userRepository.save(user);
    }

}
