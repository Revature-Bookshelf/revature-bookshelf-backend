package com.revature.bookshelf.loginservice.service;

import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.revature.bookshelf.loginservice.dto.UserDTO;

import java.util.List;

//extends UserDetailsService was here
public interface ProfileService  {
//    void register(User user);
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO getUser(String email);
    public UserDTO getUserByUserId(String userId);
    public UserDTO updateUser(String userId,UserDTO userDTO);
    public void deleteUser(String userId);
    public List<UserDTO> getUsers(int page, int limit);
}
