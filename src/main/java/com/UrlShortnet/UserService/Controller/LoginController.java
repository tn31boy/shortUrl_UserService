package com.UrlShortnet.UserService.Controller;

import com.UrlShortnet.UserService.Entity.UserDetails;
import com.UrlShortnet.UserService.Service.LoginService;
import com.UrlShortnet.UserService.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("email") String email,@RequestParam("password") String password)
    {
        System.out.println(email+password);
        if(email.isEmpty() || password.isEmpty())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Please enter all values");
        UserDetails user=loginService.login(email,password);
        if(user==null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("NO user in Db");

        String token=jwtUtils.createJwt(user.getEmail());
        System.out.println(token);

        return ResponseEntity.status(HttpStatus.FOUND).body("login Success"+token);
    }

    @PostMapping("/forget")
    public ResponseEntity<?> forgetpass(@RequestParam("email") String email, @RequestParam("pass") String password, @RequestHeader("Authorization") String token)
    {
        if(token!=null && !token.startsWith("Bearer "))
            return ResponseEntity.accepted().body("Authorization not valid");


        String auth=token.substring(7);
       // System.out.println(auth+"token");
        String sub=jwtUtils.isValied(auth);
        if(sub==null)
            return ResponseEntity.ok("invalid token");
       // System.out.println("subject of token---"+sub);

        if(loginService.forgetPassword(email,password)==1)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("SUccessfully changed");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bad Credentials");
    }

}
