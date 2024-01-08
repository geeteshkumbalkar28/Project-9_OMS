package com.oms.service;

import com.oms.Entity.Users;
import com.oms.exceptions.InvalidCredentialsException;
import com.oms.exceptions.ResourceNotFoundException;
import com.oms.repositories.UsersRepository;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = this.usersRepository.findByEmail(email);
        if (users == null) {
            System.out.println("user not found");
            throw new ResourceNotFoundException("user not found","email",email);
        }
        return users;
    }
}
