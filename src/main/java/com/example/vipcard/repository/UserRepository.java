package com.example.vipcard.repository;

import com.example.vipcard.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
