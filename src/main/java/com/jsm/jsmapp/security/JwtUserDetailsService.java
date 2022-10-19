package com.jsm.jsmapp.security;

import com.jsm.jsmapp.data.models.AppUser;
import com.jsm.jsmapp.data.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public record JwtUserDetailsService(UserRepository userRepository) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("AppUser not found with username: " + username));
        if (appUser != null) {
            return new User(appUser.getUsername(), appUser.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("AppUser not found with username: " + username);
        }
    }
}
