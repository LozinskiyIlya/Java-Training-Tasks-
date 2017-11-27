package com.jwt.dao;


import com.jwt.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public List<User> getAllUsers(){
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

}
