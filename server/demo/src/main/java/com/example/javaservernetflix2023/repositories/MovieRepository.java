package com.example.javaservernetflix2023.repositories;

import com.example.javaservernetflix2023.services.MovieJPADAO;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository extends MovieJPADAO {

    public MovieRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
