package com.mustafa;

import com.mustafa.controller.UserController;

import java.util.Scanner;

public class Runner {
    /**
     * ---> giriş yapan kişinin bilgilerini bir yerde tutacaksınız.
     * ---> Yeni Ana Ekran
     * *********************************
     * *** Hoşgeldin [Muhammet HOCA]
     * 1- Postları görüntüle
     * 2- Post paylaş
     * 3- Kullanıcıları Görüntüle
     * 4- Logout (Sistemden Çıkış yap login ekranına dön.)
     * -----------------------------------
     *       ***********************************
     *       ********** POST LİSTESİ ***********
     *       ***********************************
     *
     *       * * * * * * * * * * * * * * * * * *
     *       *       Muhammet Hoca           * *
     *       *bugün java öğrenmek için güzel-  *
     *       bir gün.                          *
     *                            29.12.2023   *
     *       * * * * * * * * * * * * * * * * * *
     */
    public static void main(String[] args) {
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