package com.UrlShortnet.UserService.Repository;

import com.UrlShortnet.UserService.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserDetails,Integer> {

    public UserDetails findByEmailAndPassword(String email,String password);
}
