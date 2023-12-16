package pl.sda.todoapp.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.model.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("username " + username + " not found");
        }

        return new CustomUserDetails(userOptional.get());
    }

    private static class CustomUserDetails implements UserDetails {

        private final User user;

        private CustomUserDetails(User user) {
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
}
