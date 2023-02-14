package com.example.javaservernetflix2023.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private int role_id;

    @Column(name = "NAME")
    private String name;

    public Role(){}

    public Role(String name, int role_id) {
        this.name = name;
        this.role_id = role_id;
    }



    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", role_id=" + role_id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }


}
