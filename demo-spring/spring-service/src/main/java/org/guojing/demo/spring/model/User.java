package org.guojing.demo.spring.model;

/**
 * Created at: 2018-11-18 11:11
 *
 * @author guojing
 */
public class User {

    private int userId;
    private String username;
    private String phone;

    public User() {}

    public int getUserId() {
        return userId;
    }

    public User setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
