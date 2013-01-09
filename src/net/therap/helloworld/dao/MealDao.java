package net.therap.helloworld.dao;

import net.therap.helloworld.domain.Meal;
import net.therap.helloworld.domain.User;
import net.therap.helloworld.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 1/2/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class MealDao {
    Database database = Database.getInstance();
    Connection connection = Database.getConnection();
    public void saveMeal(Meal meal){
        String query = "INSERT INTO MealPlan(mealItem,mealType) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,meal.getMealItem());
            preparedStatement.setString(2,meal.getMealType());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public void updateMeal(Meal meal){

        String query = "UPDATE MealPlan SET mealItem = ?, mealDate = ?, mealType = ?";
        ResultSet resultSet = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,meal.getMealItem());
            preparedStatement.setTimestamp(2,meal.getMealDate());
            preparedStatement.setString(3,meal.getMealType());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public ResultSet showMeal(){
        String query = "SELECT mealItem,mealDate,mealType FROM MealPlan";
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
