package com.revature.bookshelf.loginservice.service;

import com.revature.bookshelf.loginservice.dto.AddressDTO;
import com.revature.bookshelf.loginservice.dto.UserDTO;
import com.revature.bookshelf.loginservice.entity.Address;
import com.revature.bookshelf.loginservice.entity.User;
import com.revature.bookshelf.loginservice.exception.UserServiceException;
import com.revature.bookshelf.loginservice.repository.AddressRepository;
import com.revature.bookshelf.loginservice.repository.UserProfileRepository;
import com.revature.bookshelf.loginservice.utils.ErrorMessages;
import com.revature.bookshelf.loginservice.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;


    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(User user) {
        String bcryptHashString = passwordEncoder.encode(user.getPassword());
        user.setPassword(bcryptHashString);
        userProfileRepository.save(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO)
    {
        User userEntityByEmail = userProfileRepository.findByEmail(userDTO.getEmail());
        if (userEntityByEmail != null)
        {
            throw new RuntimeException("Record already exists");
        }

        List<AddressDTO> addressDTOList = userDTO.getAddresses();
        for (AddressDTO addressDTO : addressDTOList)
        {
            addressDTO.setAddressId(utils.generateAddressId(30));
            addressDTO.setUserDetails(userDTO);
        }

        ModelMapper modelMapper = new ModelMapper();
        User userEntity = modelMapper.map(userDTO, User.class);

        String publicUserId = utils.generateUserId(20);
        userEntity.setId(Integer.parseInt(publicUserId));
        userEntity.setPassword(bcryptPasswordEncoder.encode(userDTO.getPassword()));

        User storedUserEntity = userProfileRepository.save(userEntity);
        UserDTO returnUserDTO = modelMapper.map(storedUserEntity, UserDTO.class);

        return returnUserDTO;
    }

    @Override
    public UserDTO getUser(String email)
    {
        User userEntity = userProfileRepository.findByEmail(email);
        if (userEntity == null)
        {
            throw new UsernameNotFoundException(email);
        }
        UserDTO returnUserDTO = new UserDTO();
        BeanUtils.copyProperties(userEntity, returnUserDTO);
        return returnUserDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        User userEntity = userProfileRepository.findByEmail(email);
        if (userEntity == null)
        {
            throw new UsernameNotFoundException(email);
        }
        return (UserDetails) new User(userEntity.getEmail(), userEntity.getPassword(),new ArrayList<>());

    }

    @Override
    public UserDTO getUserByUserId(String userId)
    {
        User userEntityByUserId = userProfileRepository.findByUserId(userId);

        if (userEntityByUserId == null)
        {
            throw new UsernameNotFoundException(userId);
        }

        ModelMapper modelMapper = new ModelMapper();
        UserDTO returnUserDTO = modelMapper.map(userEntityByUserId, UserDTO.class);

        return returnUserDTO;
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO)
    {
        User userEntityfromDB = userProfileRepository.findByUserId(userId);

        if (userEntityfromDB == null)
        {
            throw new UserServiceException(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
        }

        List<Address> addressEntityList = userEntityfromDB.getAddresses();
        for (Address addressEntity : addressEntityList)
        {
            addressEntity.setUserDetails(null);
            addressRepository.save(addressEntity);
        }

        List<AddressDTO> addressDTOList = userDTO.getAddresses();
        for (AddressDTO addressDTO : addressDTOList)
        {
            addressDTO.setAddressId(utils.generateAddressId(30));
            addressDTO.setUserDetails(userDTO);
        }

        ModelMapper modelMapper = new ModelMapper();

        User userEntity = modelMapper.map(userDTO, User.class);
        userEntity.setId(userEntityfromDB.getId());
        userEntity.setId(userEntityfromDB.getId());
        userEntity.setPassword(bcryptPasswordEncoder.encode(userDTO.getPassword()));

        User updatedUserEntity = userProfileRepository.save(userEntity);

        UserDTO returnUserDTO =  modelMapper.map(updatedUserEntity, UserDTO.class);

        return returnUserDTO;
    }

    @Override
    public void deleteUser(String userId)
    {
        User userEntityByUserId = userProfileRepository.findByUserId(userId);

        if (userEntityByUserId == null)
        {
            throw new UserServiceException(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
        }
        userProfileRepository.delete(userEntityByUserId);

    }

    @Override
    public List<UserDTO> getUsers(int page, int limit)
    {
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();

        if (page > 0)
        {
            page = page - 1;
        }

        Pageable pageable = PageRequest.of(page, limit);
        Page<User> usersPage = userProfileRepository.findAll(pageable);

        List<User> userEntityList = usersPage.getContent();

        for (User userEntity : userEntityList)
        {

            ModelMapper modelMapper = new ModelMapper();
            UserDTO userDTO = modelMapper.map(userEntityList, UserDTO.class);
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }
}
