package com.example.javaservernetflix2023.repositories;

import com.example.javaservernetflix2023.services.UserDAO;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends UserDAO {

    public UserRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
