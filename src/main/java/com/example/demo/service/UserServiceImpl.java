package com.example.demo.service;

import com.example.demo.model.user;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void updateuser(Integer id, Integer price) {
        user olduser= userRepository.findOneWithUserID(id);


        olduser.setFund(olduser.getFund()-price);
        userRepository.save(olduser);
    }
}
