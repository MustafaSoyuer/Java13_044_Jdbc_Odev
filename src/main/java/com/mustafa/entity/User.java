package com.mustafa.entity;

public class User {
    Long id;
    String adsoyod;
    String username;
    String password;
    String avatar;

    public User() {
    }

    public User(String adsoyod, String username, String password, String avatar) {
        this.adsoyod = adsoyod;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }

    public User(Long id, String adsoyod, String username, String password, String avatar) {
        this.id = id;
        this.adsoyod = adsoyod;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", adsoyod='" + adsoyod + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdsoyod() {
        return adsoyod;
    }

    public void setAdsoyod(String adsoyod) {
        this.adsoyod = adsoyod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
