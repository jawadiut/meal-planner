package net.therap.helloworld.domain;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 1/2/13
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Meal {
    private String mealId;
    private String mealItem;
    private Timestamp mealDate;
    private String mealType;

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getMealItem() {
        return mealItem;
    }

    public void setMealItem(String mealItem) {
        this.mealItem = mealItem;
    }

    public Timestamp getMealDate() {
        return mealDate;
    }

    public void setMealDate(Timestamp mealDate) {
        this.mealDate = mealDate;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
