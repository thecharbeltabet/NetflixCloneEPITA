package com.example.javaservernetflix2023.repositories;

import com.example.javaservernetflix2023.services.UserJPADAO;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends UserJPADAO {

    public UserRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
