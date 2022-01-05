package com.revature.bookshelf.loginservice.repository;

import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserProfileRepository  extends PagingAndSortingRepository<User, Long> {
    User findByEmail(String email);

    User findByUserId(String userId);
}
