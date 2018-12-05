package com.example.demo.repository;

import com.example.demo.model.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<user, Integer> {




    @Query("select u from user u  where u.id = ?1")
    user findOneWithUserID(Integer id);
}
