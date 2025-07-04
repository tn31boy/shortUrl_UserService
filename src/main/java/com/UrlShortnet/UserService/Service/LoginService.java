package com.UrlShortnet.UserService.Service;

import com.UrlShortnet.UserService.Entity.UserDetails;
import com.UrlShortnet.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public UserDetails login(String email, String password)
    {
        return userRepository.findByEmailAndPassword(email,password);
    }
}
