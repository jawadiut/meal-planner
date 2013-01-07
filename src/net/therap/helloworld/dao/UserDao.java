package net.therap.helloworld.dao;

import net.therap.helloworld.domain.User;
import net.therap.helloworld.util.Database;

import javax.servlet.RequestDispatcher;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/31/12
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDao {
    Database database = Database.getInstance();
    Connection connection = Database.getConnection();

    public void saveUser(User user) {
        String query = "INSERT INTO User(firstName,lastName,userName,email,password,ISADMIN) VALUES (?,?,?,?,?,?)";
        try {
            //System.out.println(user);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1,1);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getISADMIN());
            /*ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String
            }*/
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public boolean authenticateUser(User user) {
        boolean  isTrue = false;
        String rs = "";
        ResultSet resultSet = null;
        String query = "SELECT * FROM User WHERE userName='"+user.getUserName()+"' AND password = '"+user.getPassword() +"'";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                isTrue = true;

            }

        }catch (SQLException e){
           e.printStackTrace();
        }
        System.out.println(query);
        return isTrue;

    }

    public User isAdmin(User user){
        ResultSet resultSet = null;

        String query = "SELECT * FROM User WHERE userName='"+user.getUserName()+"' AND password = '"+user.getPassword() +"'";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            //System.out.println("mewow");

            if(resultSet.next()){
                //System.out.println("whttttt???");
            }
            int meao = resultSet.getInt(7);
            //System.out.println(meao);
            user.setISADMIN(meao);


        }catch (SQLException e){
            System.out.println("connection not established");
            e.printStackTrace();
        }
        return user;
    }

}
