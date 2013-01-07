package net.therap.helloworld.domain;

import net.therap.helloworld.util.Database;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/30/12
 * Time: 12:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
    private int id;
    private int ISADMIN;

    public int getISADMIN() {
        return ISADMIN;
    }

    public void setISADMIN(int ISADMIN) {
        this.ISADMIN = ISADMIN;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;

    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
