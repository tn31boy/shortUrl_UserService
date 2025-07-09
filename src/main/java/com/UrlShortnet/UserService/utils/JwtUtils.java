package com.UrlShortnet.UserService.utils;

import io.jsonwebtoken.Claims;
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
                .setExpiration(new Date(System.currentTimeMillis()+(1000*60)))
                .signWith(SignatureAlgorithm.HS256,privateKey.getBytes()).compact();
    }

    public String isValid(String token)
    {
        try
        {
            Claims claims=Jwts.parser().setSigningKey(privateKey.getBytes()).parseClaimsJws(token).getBody();
            if(expired(claims.getExpiration()))
                return null;
            return claims.getSubject();
        }
        catch (JwtException e)
        {
            System.out.println(e);
            return null;
        }
    }

    public boolean expired(Date time)
    {
        return time.before(new Date());
    }


    //public boolean isExpired(long )
}
