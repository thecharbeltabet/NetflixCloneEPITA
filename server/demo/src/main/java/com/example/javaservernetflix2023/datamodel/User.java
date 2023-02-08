package com.example.javaservernetflix2023.datamodel;

public class User {

    private String user_id;

    private String username;

    private String password;

    private Contact contact;

    private Role role;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User(String username, String password, Contact contact, Role role) {
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                ", role=" + role +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
