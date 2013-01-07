package net.therap.helloworld.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/31/12
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Database {

    private static Database instance;

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/therap";
    private static final String USER_NAME = "root";
    private static final String PASSWORD="root";

    private static Connection connection;

    private Database(){
        try {
            Class.forName(DRIVER_NAME);
           connection =  DriverManager
                    .getConnection(URL,USER_NAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("not getting connection");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("not getting sql");
            e.printStackTrace();
        }
    }

    public static Database getInstance(){
        if(instance==null){
            instance = new Database();
        }
        return instance;
    }


    public static Connection getConnection(){
        if (connection !=null) {
            return connection;
        }
        return null;
    }
    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
