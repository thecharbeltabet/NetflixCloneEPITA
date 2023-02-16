package com.example.javaservernetflix2023.repositories;

import com.example.javaservernetflix2023.services.MovieDAO;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository extends MovieDAO {

    public MovieRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
