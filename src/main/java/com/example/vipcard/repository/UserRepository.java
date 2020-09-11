package com.example.vipcard.repository;

import com.example.vipcard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select user from User user where user.userOpenid = :userOpenid")
    User findByUserOpenid(String userOpenid);
}
