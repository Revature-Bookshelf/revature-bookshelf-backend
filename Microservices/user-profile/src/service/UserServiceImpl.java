package com.revature.service;

import com.revature.entity.User;
import com.revature.repository.UserRepository;
import com.revature.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserServiceImpl/* implements UserService, UserDetailsService*/{/*
  @Autowired
   private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepository.findByEmail(username);
        if(user==null)throw new UsernameNotFoundException(username);

        ArrayList<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for(String authority:user.getAuthorities()){
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), grantedAuthorities);
        return userDetails;
        }*/
    }

