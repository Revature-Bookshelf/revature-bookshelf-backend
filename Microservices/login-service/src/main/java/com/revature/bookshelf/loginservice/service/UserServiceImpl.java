package com.revature.bookshelf.loginservice.service;


import com.revature.bookshelf.loginservice.entity.User;
import com.revature.bookshelf.loginservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(User user) {
        String bcryptHashString = passwordEncoder.encode(user.getPassword());
        user.setPassword(bcryptHashString);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (user == null) throw new UsernameNotFoundException(username);

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String authority : user.getAuthorities()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
