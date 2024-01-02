package com.mustafa.controller;

import com.mustafa.entity.User;
import com.mustafa.repository.UserRepository;
import com.mustafa.utility.UserUtility;

import java.util.*;

public class UserController {
    private UserRepository userRepository;
    public UserController(){
        this.userRepository = new UserRepository();
    }
    UserUtility userUtility = new UserUtility();
    Queue<User> aktifkullanicilar = new LinkedList<>();
    User aktifkullanici ;

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
        aktifkullanicilar.add(userOptinal.get());


        if(userOptinal.isPresent()){
            System.out.println("GIRIS YAPILDI.");
            aktifkullanici= aktifkullanicilar.peek();
            yeniAnaEkran();
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
                System.err.println("Bu kullanıcı adı zaten kullanılıyor. Lütfen değiştirin.");
        }while (isUser);

        System.out.print("Sifre.....: ");
        String password = new Scanner(System.in).nextLine();

        userRepository.isUserName(username);

        User user = new User(adsoyad,username,password,"");
        userRepository.save(user);
    }

    public static void kullanicilariGoruntule() {
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.findAll();

        if (!users.isEmpty()) {
            System.out.println("********** KULLANICILAR **********");
            for (User user : users) {
                System.out.println("User ID: " + user.getId());
                System.out.println("Ad Soyad: " + user.getAdsoyod());
                System.out.println("Username: " + user.getUsername());
                System.out.println("-------------------------------");
            }
        } else {
            System.out.println("Henüz kullanıcı bulunmamaktadır.");
        }
    }

    public void yeniAnaEkran(){
        int secim;
        do{
            System.out.println("         *******************************************************");
            System.out.println("         ********      HOSGELDIN "+aktifkullanici.getAdsoyod()+"         ********");
            System.out.println("""             
                         *  ******** G I R I S *********************************
                         *  1- Postları Goruntule
                         *  2- Post Paylas
                         *  3- Kullanıcıları Goruntule
                         *  4- LogOut
                     
                """);
            System.out.print("Lütfen seciniz....: ");
            secim = new Scanner(System.in).nextInt();
            switch (secim){
                case 1 : new PostController().postlariGoruntule(aktifkullanici.getId()); break;
                case 2 : new PostController().postPaylas(aktifkullanici.getId(),aktifkullanici.getAdsoyod()); break;
                case 3 : kullanicilariGoruntule(); break;
                case 4 :
                    System.out.println("Ana menuye donuluyor... ");
                    app(); break;
                default:
                    System.err.println("Lütfen geçerli bir seçim yapınız.");
                    break;
            }
        }while (secim!=0);
    }

    public void app(){
        int secim;
        do{

            System.out.println("""
                    
                         *  ******************************
                         *  ******* Java Forum Sayfası ***
                         *  ******** G I R I S ***********
                         *  1- Login
                         *  2- Register
                         *  0- C I K I S
                
                
             
                """);
            System.out.print("Lütfen seciniz....: ");
            secim = new Scanner(System.in).nextInt();
            switch (secim){
                case 1 : new UserController().Login(); break;
                case 2 : new UserController().Register(); break;
                default:
                     System.err.println("Lütfen geçerli bir seçim yapınız.");
                    break;
            }
        }while (secim!=0);
        System.out.println("CIKIS");
    }

}
