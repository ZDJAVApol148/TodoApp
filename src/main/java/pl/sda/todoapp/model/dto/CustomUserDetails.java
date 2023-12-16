package pl.sda.todoapp.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import pl.sda.todoapp.model.User;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.unmodifiableCollection(
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // if (user.getExpiryDate() < new Date()) { return false; }
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // if (user.isBanned()) { return false; }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // if (user.getPasswordExpiryDate() < new Date()) { return false; }
        return true;
    }

    @Override
    public boolean isEnabled() {
        // if (!user.isEnabled()) { return false; }
        return true;
    }
}
