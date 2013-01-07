package net.therap.helloworld.dao;

import net.therap.helloworld.domain.Comment;
import net.therap.helloworld.util.Database;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 1/5/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommentDao {
    Database database = Database.getInstance();
    Connection connection = Database.getConnection();

    public void saveComment(Comment comment){
        String query = "INSERT INTO CommentDetails(username,comment,mealtype) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,comment.getUserName());
            //preparedStatement.setTimestamp(2,  comment.getDateTime());
            preparedStatement.setString(2,comment.getComment());
            preparedStatement.setString(3,comment.getMealtype());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public ResultSet getComments(String sv){
        String query = "SELECT username,comment FROM CommentDetails";
        ResultSet resultSet = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

}
