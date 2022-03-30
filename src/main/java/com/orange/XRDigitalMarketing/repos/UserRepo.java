package com.orange.XRDigitalMarketing.repos;

import com.orange.XRDigitalMarketing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
