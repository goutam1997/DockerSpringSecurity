package gk_inventory.service;

import gk_inventory.model.GkUserDetail;
import gk_inventory.model.GkUserInfo;
import gk_inventory.repository.GkUserInfoRepository;
import inventory.dao.UserInfoRepository;
import inventory.models.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsServiceImpl")
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private GkUserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GkUserInfo userInfo = userInfoRepository.findByName(username).orElse(null);
        if (userInfo!=null){
            log.info("Got userinfo: {}", userInfo);
            return new GkUserDetail(userInfo);
        }
        return null;
    }
}
