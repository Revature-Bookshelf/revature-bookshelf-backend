package com.revature.bookshelf.loginservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.revature.bookshelf.loginservice.dto.UserDTO;

import java.util.List;

public interface ProfileService extends UserDetailsService {
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO getUser(String email);
    public UserDTO getUserByUserId(String userId);
    public UserDTO updateUser(String userId,UserDTO userDTO);
    public void deleteUser(String userId);
    public List<UserDTO> getUsers(int page, int limit);
}
