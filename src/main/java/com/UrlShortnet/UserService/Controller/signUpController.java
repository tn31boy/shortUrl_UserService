package com.UrlShortnet.UserService.Controller;

import com.UrlShortnet.UserService.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class signUpController {

    @Autowired
    SignUpService signUpService;


    @PostMapping("/signup")
    public String singUp(@RequestParam("name") String userName,@RequestParam("password") String userPassword,@RequestParam("email") String userEmail)
    {
        if(userName.isEmpty() || userPassword.isEmpty()  || userEmail.isEmpty())
                return "Please All details";

        if(signUpService.signUp(userName,userPassword,userEmail))
            return "Successfully Account Created";
        return "Account Not Created";
    }
}
