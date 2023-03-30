package org.example.dto;

import org.example.User;

import java.util.List;

public class Car {

    User user;
    User user2;
    User user3;
    List<User> user4;
    List<User> user5;

    public Car(User user, User user2, User user3, List<User> user4) {
        this.user = user;
        this.user2 = user2;
        this.user3 = user3;
        this.user4 = user4;
    }

    public Car(User user, User user2, User user3, List<User> user4, List<User> user5) {
        this.user = user;
        this.user2 = user2;
        this.user3 = user3;
        this.user4 = user4;
        this.user5 = user5;
    }

    public List<User> getUser4() {
        return user4;
    }

    public void setUser4(List<User> user4) {
        this.user4 = user4;
    }

    public List<User> getUser5() {
        return user5;
    }

    public void setUser5(List<User> user5) {
        this.user5 = user5;
    }

    String[] phones;


    public Car(User user, User user2) {
        this.user = user;
        this.user2 = user2;
    }

    public Car(User user, User user2, User user3) {
        this.user = user;
        this.user2 = user2;
        this.user3 = user3;
    }

    public User getUser3() {
        return user3;
    }

    public void setUser3(User user3) {
        this.user3 = user3;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Car() {
    }

    public Car(User user) {
        this.user = user;
    }

    public Car(User user, String[] phones) {
        this.user = user;
        this.phones = phones;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }
}
