package com.evaluateApisBcolinad.restfulApis.JWT;

import com.evaluateApisBcolinad.restfulApis.CustomClass.CustomUserDetails;
import com.evaluateApisBcolinad.restfulApis.Entities.User;
import com.evaluateApisBcolinad.restfulApis.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository users;

    public CustomUserDetailsService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = users.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("Usuario o contraseña inválidos"));
        } else {
            return new CustomUserDetails(user.getEmail(),user.getPassword(),user.getRoles());
        }

    }
}