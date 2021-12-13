package com.example.hellospringbatch.Service;

import com.example.hellospringbatch.Entity.User;
import com.example.hellospringbatch.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void updatePoint(User user) {
        Optional<User> result = userRepository.findById(user.getUser_id());
        if (result.isPresent()) {
            User entity = result.get();
            entity.changePoint(user.getPoint());
            userRepository.save(entity);
        }
    }

}
