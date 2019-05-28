package com.event.backoffice.model.dao;

import com.event.backoffice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {

//    String getData();

    @Query("SELECT u FROM User u WHERE u.id=:id")
    User getUserById(@Param("id") Long id);

//    User getUser();
}

