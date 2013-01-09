package net.therap.helloworld.controller;

import net.therap.helloworld.dao.CommentDao;
import net.therap.helloworld.dao.MealDao;
import net.therap.helloworld.domain.Comment;
import net.therap.helloworld.domain.Meal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 1/2/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/mealplan")
public class MealPlanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
        List<String> comments = new ArrayList<String>();
        List<String> usernames = new ArrayList<String>();
        List<String> mealType = new ArrayList<String>();
        List<Timestamp> mealDate = new ArrayList<Timestamp>();
        List<String> mealItem = new ArrayList<String>();
        String sv = "breakfast";
        HttpSession session = req.getSession();
        Object attribute = session.getAttribute("isadmin");

        sv = (String) (req.getParameter("cmb"));
        req.setAttribute("combo", sv);
        addComment(usernames, comments, sv);
        showMeals(mealItem, mealDate, mealType);
        req.setAttribute("usernames", usernames);
        req.setAttribute("comments", comments);
        req.setAttribute("mealItem", mealItem);
        req.setAttribute("mealDate", mealDate);
        req.setAttribute("mealType", mealType);
        req.setAttribute("Isadmin", (Integer) attribute);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/mealplan.jsp");
        requestDispatcher.forward(req, resp);


    }

    /*protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws  ServletException,IOException{

    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
        //resp
        HttpSession session = req.getSession(false);
        String submit = req.getParameter("submit");
        String sv = "breakfast";
        List<String> comments = new ArrayList<String>();
        List<String> usernames = new ArrayList<String>();
        List<String> mealType = new ArrayList<String>();
        List<Timestamp> mealDate = new ArrayList<Timestamp>();
        List<String> mealItem = new ArrayList<String>();
        java.util.Date date= new java.util.Date();
        sv = (String) (req.getParameter("cmb"));
        CommentDao commentDao = new CommentDao();

        /********ADMIN_MENU_CHANGE********************/
        if (submit.equals("menuchange")) {

            MealDao mealDao = new MealDao();
            Meal meal = new Meal();
            meal.setMealItem(req.getParameter("hide"));
            meal.setMealDate(new Timestamp(date.getTime()));
            meal.setMealType(sv);
            mealDao.updateMeal(meal);
            addComment(usernames, comments, sv);
            showMeals(mealItem, mealDate, mealType);


        }

        /**********POST_COMMENT**********************/
        else {
            Comment com = new Comment();

            com.setUserName((String) session.getAttribute("username"));
            com.setComment(req.getParameter("commentArea"));
            com.setMealtype(sv);

            commentDao.saveComment(com);
            addComment(usernames, comments, sv); //process comments.........

            showMeals(mealItem, mealDate, mealType);
            req.setAttribute("combo", sv);
        }
        req.setAttribute("usernames", usernames);
        req.setAttribute("comments", comments);
        req.setAttribute("mealItem", mealItem);
        req.setAttribute("mealDate", mealDate);
        req.setAttribute("mealType", mealType);
        req.setAttribute("Isadmin", (Integer) session.getAttribute("isadmin"));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/mealplan.jsp");
        requestDispatcher.forward(req, resp);

    }

    public void addComment(List<String> usernames, List<String> comments, String sv) {

        CommentDao commentDao = new CommentDao();
        //process comments.........

        ResultSet set = commentDao.getComments(sv);
        try {
            while (set.next()) {
                usernames.add(set.getString(1));
                comments.add(set.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    public void showMeals(List<String> mealItem, List<Timestamp> mealDate, List<String> mealType) {
        MealDao mealDao = new MealDao();
        ResultSet rs = mealDao.showMeal();
        try {
            while (rs.next()) {
                mealItem.add(rs.getString(1));
                mealDate.add(rs.getTimestamp(2));
                mealType.add(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
