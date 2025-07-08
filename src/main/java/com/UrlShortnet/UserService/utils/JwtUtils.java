package com.UrlShortnet.UserService.utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String privateKey="secret";

    public String createJwt(String email)
    {
        return Jwts.builder().setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+(1000*60*60)))
                .signWith(SignatureAlgorithm.HS256,privateKey.getBytes()).compact();
    }

    public String isValied(String token)
    {
        try
        {
            return Jwts.parser()
                    .setSigningKey(privateKey)
                    .parseClaimsJws(token)
                    .getBody().getSubject();
        }
        catch (JwtException e)
        {
            System.out.println(e);
            return null;
        }
    }


    //public boolean isExpired(long )
}
