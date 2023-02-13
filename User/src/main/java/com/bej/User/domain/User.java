/*
 * Author : Ketki Keni
 * Date : 13-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.bej.User.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int userId;
    private String userName;
    private String userPassword;
    private String userAddress;

    public User() {
    }

    public User(int userId, String userName, String userPassword, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
