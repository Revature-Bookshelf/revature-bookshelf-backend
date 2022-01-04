package com.revature.bookshelf.loginservice.repository;

import com.revature.bookshelf.loginservice.entity.Address;
import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAllByUserDetails(User userEntity);
    Address findByUserDetailsAndAddressId(User userEntity, String addressId);
}
