package gk_inventory.controller;

import gk_inventory.model.GkAuthRequest;
import gk_inventory.model.GkUserInfo;
import gk_inventory.repository.GkUserInfoRepository;
import gk_inventory.service.GkJwtService;
import inventory.dao.UserInfoRepository;
import inventory.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private GkUserInfoRepository userInfoRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GkJwtService jwtService;

    @PostMapping("/add-user")
    public String addUser(@RequestBody GkUserInfo userInfo){
        userInfoRepository.save(userInfo);
        return "User added successfully!!!";
    }

    @PostMapping("/create-token")
    public String createToken(@RequestBody GkAuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest);
        }
        throw new UsernameNotFoundException(authRequest.getUsername());
    }

    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String welcomePage(){
        return "Welcome to Spring Security!!!";
    }
}
