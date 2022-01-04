package com.revature.bookshelf.loginservice.service;


import com.revature.bookshelf.loginservice.dto.AddressDTO;
import com.revature.bookshelf.loginservice.entity.Address;
import com.revature.bookshelf.loginservice.entity.User;
import com.revature.bookshelf.loginservice.repository.AddressRepository;
import com.revature.bookshelf.loginservice.repository.UserProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<AddressDTO> getAddresses(String userId) {

        List<AddressDTO> addressDTOList = new ArrayList<>();

        User userEntity = userProfileRepository.findByUserId(userId);

        if (userEntity == null)
        {
            return addressDTOList;
        }

        ModelMapper modelMapper = new ModelMapper();

        List<Address> addresses = addressRepository.findAllByUserDetails(userEntity);

        for (Address addressEntity : addresses)
        {
            AddressDTO addressDTO = modelMapper.map(addressEntity, AddressDTO.class);
            addressDTOList.add(addressDTO);
        }

        return addressDTOList;
    }

    @Override
    public AddressDTO getAddress(String userId, String addressId) {
        AddressDTO addressDTO = null;

        User userEntity = userProfileRepository.findByUserId(userId);
        Address addressEntity = addressRepository.findByUserDetailsAndAddressId(userEntity, addressId);

        if (addressEntity != null)
        {
            ModelMapper modelMapper = new ModelMapper();
            addressDTO = modelMapper.map(addressEntity, AddressDTO.class);
        }

        return addressDTO;
    }
}
