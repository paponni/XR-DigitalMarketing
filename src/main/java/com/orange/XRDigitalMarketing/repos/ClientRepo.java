package com.orange.XRDigitalMarketing.repos;

import com.orange.XRDigitalMarketing.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    public Client findByEmailAndPassword(String email,String password);
}
