package com.revature.bookshelf.loginservice.service;


import com.revature.bookshelf.loginservice.entity.User;
import com.revature.bookshelf.loginservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
import java.util.List;
// Looks like there are no things as repositories for MongoDB?

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // From UserService Interface
    @Override
    public void register(User user) {
        String bcryptHashString = passwordEncoder.encode(user.getPassword());
        user.setPassword(bcryptHashString);
        userRepository.save(user);
    }

    // From UserDetailService Interface
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
//        List<User> userList= userRepository.findAll();
//        User user = userList.get(0);
        System.out.println(user);
        if (user == null) throw new UsernameNotFoundException(email);

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String authority : user.getAuthorities()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
        System.out.println(userDetails);
        return userDetails;
    }
}
