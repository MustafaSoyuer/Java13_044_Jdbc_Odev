package com.mustafa.repository;


import com.mustafa.entity.User;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<User> {

    private CRUD crud;
    public UserRepository(){
        crud = new CRUD();
    }
    private String sql;
    private ResultSet resultSet;
    @Override
    public boolean save(User entity) {
        sql = "insert into tbluser (adsoyad,username,password,avatar) " +
                "values('"+entity.getAdsoyad()
                +"','"+entity.getUsername()
                +"','"+entity.getPassword()
                +"','"+entity.getAvatar()+"')";
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public boolean update(User entity) {
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public List<User> findAll() {

        resultSet = crud.getAllTableRows("select * from tbluser");
        List<User> userList = new ArrayList<>();
        try{
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String adSoyad= resultSet.getString("adsoyad");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String avatar = resultSet.getString("avatar");
                User user = new User(id,adSoyad,username,password,avatar);
                userList.add(user);
            }
            return userList;
        }catch (Exception exception){
            return userList;
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }


    /**
     * Bu method verilen kullanıcı adı ve şifreyi DBye sorgu olarak gönderir ve herhangi
     * bir kayıt olup olmadığını sorgular. Eğer bir kayıt bulur ise bunu döner bulamaz ise
     * boş olarak döner.
     * @param username
     * @param password
     * @return
     */
    public  Optional<User> doLogin(String username, String password){
        sql = "select * from tbluser where username='"+username+"' and password='"+password+"'";
        resultSet = crud.getAllTableRows(sql);
        Optional<User> userOptinal = Optional.empty();
        try {
            while(resultSet.next()){ // sorgu neticesinde gelen tabloyu , satır satır dolaşmak için kullanılır.
                Long db_id = resultSet.getLong("id"); // her bir satırda hangi kolonu okumak istediğimiz belirtiyoruz.
                String db_adsoyad = resultSet.getString("adsoyad");
                String db_username = resultSet.getString("username");
                String db_password = resultSet.getString("password");
                String db_avatar = resultSet.getString("avatar");
                User user = new User(db_id,db_adsoyad,db_username,db_password,db_avatar); // yeni bir user nesnesi oluşturuyoruz
                userOptinal = Optional.of(user); // user nesnesini optinal ile sarmalayarak eşitliyoruz

            }
        }catch (Exception exception){

        }

        return userOptinal;
    }

    public boolean isUserName(String username){
        sql = "select * from tbluser where username='"+username+"'";
        resultSet = crud.getAllTableRows(sql);
        boolean isUser = false;
        try {
            while (resultSet.next()){
                isUser = true;
            }
//            isUser = resultSet.next();
        }catch (Exception exception){

        }
        return isUser;
    }
}
