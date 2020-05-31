package com.login.demo.Implementation;

import javax.persistence.*;

@Entity // declare that this is a representation of a table in sql using JPA
@Table(name="myUsers")//here we declare the name of the table in Postgres
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//for the secuence of the primary key
    private int id;
    private String username;
    private String password;
    private boolean active;
    private String roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
