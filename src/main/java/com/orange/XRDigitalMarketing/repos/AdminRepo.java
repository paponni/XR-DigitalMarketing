package com.orange.XRDigitalMarketing.repos;


import com.orange.XRDigitalMarketing.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {

    public Admin findByEmailAndPassword(String email,String password);
}
