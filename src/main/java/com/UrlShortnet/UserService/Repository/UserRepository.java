package com.UrlShortnet.UserService.Repository;

import com.UrlShortnet.UserService.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserDetails,Integer> {

    public UserDetails findByEmailAndPassword(String email,String password);

    @Modifying
    @Query("update UserDetails u set u.password=:pass where u.email=:email")
    public int update(@Param("email") String email,@Param("pass") String password);
}
