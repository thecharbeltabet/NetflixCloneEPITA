//package com.example.javaservernetflix2023;
//
//import com.example.javaservernetflix2023.datamodel.Contact;
//import com.example.javaservernetflix2023.datamodel.Role;
//import com.example.javaservernetflix2023.datamodel.User;
//import com.example.javaservernetflix2023.services.UserDAO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.junit.Assert.assertThat;
//
//public class UserDAOTests {
//
//    package com.example.javaservernetflix2023.dao;
//
//import com.example.javaservernetflix2023.datamodel.Contact;
//import com.example.javaservernetflix2023.datamodel.Role;
//import com.example.javaservernetflix2023.datamodel.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//    @DataJpaTest
//    public class UserDaoTest {
//
//        @Autowired
//        private UserDAO userDao;
//
//        @Test
//        public void testSaveUser() {
//            Contact contact = new Contact("John", "Doe", "johndoe@example.com");
//            Role role = new Role("ROLE_USER");
//            User user = new User("johndoe", "password123", contact, role);
//            User savedUser = userDao.save(user);
//            assertThat(savedUser.getUser_id()).isGreaterThan(0);
//        }
//
//        @Test
//        public void testGetUserById() {
//            Contact contact = new Contact("John", "Doe", "johndoe@example.com");
//            Role role = new Role("ROLE_USER");
//            User user = new User("johndoe", "password123", contact, role);
//            User savedUser = userDao.save(user);
//            User retrievedUser = userDao.findbyId(savedUser.getUser_id()).orElse(null);
//            assertThat(retrievedUser).isNotNull();
//            assertThat(retrievedUser.getUsername()).isEqualTo("johndoe");
//        }
//
//        @Test
//        public void testGetUserByUsername() {
//            Contact contact = new Contact("John", "Doe", "johndoe@example.com");
//            Role role = new Role("ROLE_USER");
//            User user = new User("johndoe", "password123", contact, role);
//            userDao.save(user);
//            User retrievedUser = userDao.findByUsername("johndoe");
//            assertThat(retrievedUser).isNotNull();
//            assertThat(retrievedUser.getPassword()).isEqualTo("password123");
//        }
//
//        @Test
//        public void testDeleteUser() {
//            Contact contact = new Contact("John", "Doe", "johndoe@example.com");
//            Role role = new Role("ROLE_USER");
//            User user = new User("johndoe", "password123", contact, role);
//            User savedUser = userDao.save(user);
//            userDao.delete(savedUser);
//            User deletedUser = userDao.findById(savedUser.getUser_id()).orElse(null);
//            assertThat(deletedUser).isNull();
//        }
//
//    }
//
//}
