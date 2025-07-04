package com.UrlShortnet.UserService.Service;

import com.UrlShortnet.UserService.Entity.UserDetails;
import com.UrlShortnet.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    UserRepository userRepository;

    public boolean signUp(String name,String password,String email)
    {
        System.out.println(name+password+email);
        System.out.println(email);
        UserDetails isSave=userRepository.save(UserDetails.builder()
                .id(1).name(name)
                .email(email)
                .password(password)
                .build());

        return isSave!=null;
    }

}
