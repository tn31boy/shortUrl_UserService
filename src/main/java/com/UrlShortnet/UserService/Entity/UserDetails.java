package com.UrlShortnet.UserService.Entity;

import jakarta.persistence.Column;

public class UserDetails {

    private int id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;


    private String PhNo;

    @Column(nullable = false)
    private String Password;
}
