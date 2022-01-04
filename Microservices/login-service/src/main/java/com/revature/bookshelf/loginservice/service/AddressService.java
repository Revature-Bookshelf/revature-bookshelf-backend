package com.revature.bookshelf.loginservice.service;

import com.revature.bookshelf.loginservice.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAddresses(String userId);
    AddressDTO getAddress(String userId,String addressId);
}

