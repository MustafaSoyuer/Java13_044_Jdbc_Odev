package com.mustafa.repository;
import com.mustafa.entity.Comment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentRepository implements Repository<Comment> {
    private CRUD crud;

    public CommentRepository() {
        crud = new CRUD();
    }

    private String sql;
    private ResultSet resultSet;

    @Override
    public String toString() {
        return "CommentRepository{" +
                "crud=" + crud +
                ", sql='" + sql + '\'' +
                ", resultSet=" + resultSet +
                '}';
    }

    public CRUD getCrud() {
        return crud;
    }

    public void setCrud(CRUD crud) {
        this.crud = crud;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    @Override
    public boolean save(Comment entity) {
        sql = "insert into tblcomment (userid,postid,commenttext,cammentdate) " +
                "values('" + entity.getUserid()
                + "','" + entity.getPostid()
                + "','" + entity.getCommenttext()
                + "','" + entity.getCommentdate() + "')";
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public boolean update(Comment entity) {
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public List<Comment> findAll() {
        sql = "select * from tblcomment";
        resultSet = crud.getAllTableRows(sql);
        List<Comment> commentList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long userid = resultSet.getLong("userid");
                Long postid = resultSet.getLong("postid");
                String commenttext = resultSet.getString("commenttext");
                long commentdate = resultSet.getLong("commentdate");
                Comment comment = new Comment(id, userid, postid, commenttext, commentdate);
                commentList.add(comment);
            }
            return commentList;
        } catch (Exception exception) {
            return commentList;
        }
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }
}