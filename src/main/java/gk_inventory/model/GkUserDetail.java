package gk_inventory.model;

import inventory.models.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GkUserDetail implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public GkUserDetail(GkUserInfo userInfo){
        this.username=userInfo.getName();
        this.password=userInfo.getPassword();
        this.authorities= Arrays.stream(userInfo.getRoles().split(",")).map(SimpleGrantedAuthority::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
