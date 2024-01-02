package com.mustafa.entity;

public class Post {
    Long id;
    Long userid;
    String title;
    String postcomment;
    Long shareddate;
    String imageurl;
    int likeCount;
    int commentCount;

    public Post() {
    }

    public Post(Long userid, String title, String postcomment) {
        this.userid = userid;
        this.title = title;
        this.postcomment = postcomment;
    }

    public Post(Long userid, String title, String postcomment, Long shareddate, String imageurl, int likeCount, int commentCount) {
        this.userid = userid;
        this.title = title;
        this.postcomment = postcomment;
        this.shareddate = shareddate;
        this.imageurl = imageurl;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public Post(Long id, Long userid, String title, String  postcomment, Long shareddate, String imageurl, int likeCount, int commentCount) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.postcomment = postcomment;
        this.shareddate = shareddate;
        this.imageurl = imageurl;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", postcomment='" + postcomment + '\'' +
                ", shareddate=" + shareddate +
                ", imageurl='" + imageurl + '\'' +
                ", likeCount=" + likeCount +
                ", commentCount=" + commentCount +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostcomment() {
        return postcomment;
    }

    public void setPostcomment(String  postcomment) {
        this.postcomment = postcomment;
    }

    public Long getShareddate() {
        return shareddate;
    }

    public void setShareddate(Long shareddate) {
        this.shareddate = shareddate;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }


}
