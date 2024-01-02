package com.mustafa.repository;

import com.mustafa.entity.Post;
import com.mustafa.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository implements Repository<Post>{
    private CRUD crud;
    public PostRepository(){
        crud = new CRUD();
    }
    private String sql;
    private ResultSet resultSet;
    @Override
    public boolean save(Post entity) {
        sql = "insert into tblpost (userid,title,postcomment,shareddate,imageurl,likecount,commentcount) " +
                "values('"+entity.getUserid()
                +"','"+entity.getTitle()
                +"','"+entity.getPostcomment()
                +"','"+entity.getShareddate()
                +"','"+entity.getImageurl()
                +"','"+entity.getLikeCount()
                +"','"+entity.getCommentCount()+"')";
        crud.executeUpdate(sql);
        return true;

    }

    @Override
    public boolean update(Post entity) {
        sql = "update tblpost set postcomment=new where id=id";//??
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public List<Post> findAll() {
        sql = "select * from tblpost";
        resultSet = crud.getAllTableRows(sql);
        List<Post> postList = new ArrayList<>();
        try{
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                Long userid= resultSet.getLong("userid");
                String title = resultSet.getString("title");
                String postcomment = resultSet.getString("postcomment");
                long shareddate = resultSet.getLong("shareddate");
                String imageurl = resultSet.getString("imageurl");
                int likecount = resultSet.getInt("likecount");
                int commentcount = resultSet.getInt("commentcount");
                Post post = new Post(id,userid,title,postcomment,shareddate,imageurl,likecount,commentcount);
                postList.add(post);
            }
            return postList;
        }catch (Exception exception){
            return postList;
        }
    }

    @Override
    public Optional<Post> findById(Long id) {
        sql = "select * from tblpost where userid="+id;
        resultSet = crud.getAllTableRows(sql);
        Optional<Post> postOptinal = Optional.empty();
        try {
            while(resultSet.next()){
                Long db_id = resultSet.getLong("id");
                Long userid= resultSet.getLong("userid");
                String title = resultSet.getString("title");
                String postcomment = resultSet.getString("postcomment");
                long shareddate = resultSet.getLong("shareddate");
                String imageurl = resultSet.getString("imageurl");
                int likecount = resultSet.getInt("likecount");
                int commentcount = resultSet.getInt("commentcount");
                Post post = new Post(db_id,userid,title,postcomment,shareddate,imageurl,likecount,commentcount);
                postOptinal = Optional.of(post);
            }
        }catch (Exception exception){

        }
        return postOptinal;
    }

    public List<Post> findbyIdAll(Long id) {
        sql = "select * from tblpost where userid= "+id;
        resultSet = crud.getAllTableRows(sql);
        List<Post> postList = new ArrayList<>();
        try{
            while (resultSet.next()){
                Long db_id = resultSet.getLong("id");
                Long userid= resultSet.getLong("userid");
                String title = resultSet.getString("title");
                String postcomment = resultSet.getString("postcomment");
                long shareddate = resultSet.getLong("shareddate");
                String imageurl = resultSet.getString("imageurl");
                int likecount = resultSet.getInt("likecount");
                int commentcount = resultSet.getInt("commentcount");
                Post post = new Post(db_id,userid,title,postcomment,shareddate,imageurl,likecount,commentcount);
                postList.add(post);
            }
            return postList;
        }catch (Exception exception){
            return postList;
        }
    }

    public String findNamebyPost(Long id) {
        sql = "select adsoyad from tblpost as p left join tbluser as u on p.userid = u.id where userid="+id;
        resultSet = crud.getAllTableRows(sql);
        String adsoyad = null;
        try{
            while (resultSet.next()){
               adsoyad = resultSet.getString("adsoyad");
                User user = new User( adsoyad);
            }
            return adsoyad;
        }catch (Exception exception){
            return adsoyad;
        }
    }

}
