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

@Service
public class UserDAO {

    private final SessionFactory factory;

    public UserDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public User getUserbyUsername(String username) {
        Session session = getSession();
        Query<User> query = session.createQuery("from User where username = :username");
        query.setParameter("username", username);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    public List<User> getAllUsers() {
        Session session = getSession();
        Query<User> query = session.createQuery("from User");
        List<User> users = query.list();
        session.close();
        return users;
    }

    public User getUserById(int user_id) {
        Session session = getSession();
        Query<User> query = session.createQuery("from User where USER_ID = :USER_ID");
        query.setParameter("USER_ID", user_id);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    public void deleteUserById(int user_id) {
        Session session = getSession();
        Query<User> query = session.createQuery("delete from User where USER_ID = :USER_ID");
        query.setParameter("USER_ID", user_id);
        Transaction transaction = session.beginTransaction();
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public User addAddress(String username, String country, String area, String city, String street, String number) {
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
        updateUser(user);
        return user;
    }

    public User addContact(String username, String name, String email, String gender, Date birthDate){
        User user = getUserbyUsername(username);
        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setBirthDate(birthDate);
        contact.setGender(gender);
        contact.setName(name);
        user.setContact(contact);
        updateUser(user);
        return user;
    }

    public User register(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

    public User addRole(String username, String roleName) {
        User user = getUserbyUsername(username);
        Role role = new Role();
        role.setName(roleName);
        user.setRole(role);
        updateUser(user);
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
