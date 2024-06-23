package gk_inventory.service;

import gk_inventory.model.GkAuthRequest;
import gk_inventory.model.GkUserDetail;
import gk_inventory.model.GkUserInfo;
import gk_inventory.repository.GkUserInfoRepository;
import inventory.dao.UserInfoRepository;
import inventory.models.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class GkJwtService {
    @Autowired
    private GkUserInfoRepository userInfoRepository;

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    private final String SECRET = "b5d97e0293fb668d4af235c2fddb3f7d1687883d7e5409668274836e92b5d8d3";

    public Authentication validateToken(String token) {
        String userName = extractUserName(token);
        if (userName!=null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName); //#1

            GkUserInfo userInfo=userInfoRepository.findByName(userName).orElse(null); //#2

            if (userInfo!=null && userInfo.getName().equals(userDetails.getUsername())){
                Authentication authentication=new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
                        null, userDetails.getAuthorities());
//                authentication.setAuthenticated(true); IMPORTANT: THIS IS DONE BY ABOVE CONSTRUCTOR
                return authentication;
            }
        }
        return null;
    }

    private String extractUserName(String token) {
        Claims claims=extractAllClaims(token);
        return claims.getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }

    public String generateToken(GkAuthRequest authRequest){
        return Jwts.builder()
                .setSubject(authRequest.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 30*60*1000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] bytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(bytes);
    }


}
