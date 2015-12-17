package com.ekart.account.repositories;

import com.ekart.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByPhone(long phone);

    @Override
    void delete(User user);

}
