package com.UrlShortnet.UserService.Controller;

import com.UrlShortnet.UserService.Entity.UserDetails;
import com.UrlShortnet.UserService.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("email") String email,@RequestParam("password") String password)
    {
        System.out.println(email+password);
        if(email.isEmpty() || password.isEmpty())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Please enter all values");
        UserDetails user=loginService.login(email,password);
        if(user==null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("NO user in Db");
        return ResponseEntity.status(HttpStatus.FOUND).body("login Success");
    }

}
