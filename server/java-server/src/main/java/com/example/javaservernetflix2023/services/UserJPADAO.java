package com.example.javaservernetflix2023.services;

import com.example.javaservernetflix2023.datamodel.Address;
import com.example.javaservernetflix2023.datamodel.Contact;
import com.example.javaservernetflix2023.datamodel.Role;
import com.example.javaservernetflix2023.datamodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

// This is the DAO class for the User class
@Service
public class UserJPADAO {


    //
    private final SessionFactory factory;

    public UserJPADAO(SessionFactory factory) {
        this.factory = factory;
    }


    //Get a user by his username
    public User getUserbyUsername(String username){
        Session session = factory.openSession();
        Query<User> query = session.createQuery("from User where username = :username");
        query.setParameter("username", username);
        session.close();
        return query.uniqueResult();
    }

    // Get all users
    public List<User> getAllUsers() {
        Session session = factory.openSession();
        Query<User> query = session.createQuery("from User");
        List<User> users = query.list();
        session.close();
        return users;
    }


    //Get a user by his id
    public User getUserById(int user_id) {
        Session session = factory.openSession();
        Query<User> query = session.createQuery("from User where USER_ID = :USER_ID");
        query.setParameter("USER_ID", user_id);
        return query.uniqueResult();
    }

    //Delete a user by his id
    public User deleteUserById(int user_id) {
        Session session = factory.openSession();
        Query<User> query = session.createQuery("delete from User where USER_ID = :USER_ID");
        query.setParameter("USER_ID", user_id);
        return query.uniqueResult();
    }

    //Update a user by his id
    public User updateUserById(int user_id) {
        Session session = factory.openSession();
        Query<User> query = session.createQuery("update User where USER_ID = :USER_ID");
        query.setParameter("USER_ID", user_id);
        return query.uniqueResult();
    }


    //Add a user's address by updating the user
    public User addAddress(String username, String country, String area, String city, String street, String number) {
        // get user by username
        User user = getUserbyUsername(username);
        Contact contact = user.getContact();
        Address address = new Address();

        address.setCountry(country);
        address.setArea(area);
        address.setCity(city);
        address.setStreet(street);
        address.setNumber(number);
        contact.setBillingAddress(address);
        user.setContact(contact);

        Session session = getSession();
        Transaction transaction = session.beginTransaction();


        session.update(user);

        transaction.commit();
        session.close();
        return user;
    }

    //Add a user's contact by updating the user
    public User addContact(String username, String name, String email, String gender, Date birthDate){
        //get user by username
        User user = getUserbyUsername(username);
        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setBirthDate(birthDate);
        contact.setGender(gender);
        contact.setName(name);
        user.setContact(contact);

        //update user
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        return user;



    }

    //Register a new user
    public User register(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;

    }

    //Add a user's role by updating the user
    public User addRole(String username, String roleName) {
        // get user by username
        User user = getUserbyUsername(username);
        Role role = new Role();
        role.setName(roleName);

        user.setRole(role);

        // update found user
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        return user;
    }

    public Session getSession() {
        Session currentSession = null;
        try {
            currentSession = this.factory.getCurrentSession();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (currentSession != null && currentSession.isOpen()) {
            return currentSession;
        } else {
            return this.factory.openSession();
        }
    }





}
