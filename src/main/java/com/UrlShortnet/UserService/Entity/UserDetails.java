package com.UrlShortnet.UserService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetails {

    @Id
    private int id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;


    private String PhNo;

    @Column(nullable = false)
    private String password;
}
