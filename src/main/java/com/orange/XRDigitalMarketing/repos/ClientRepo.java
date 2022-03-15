package com.orange.XRDigitalMarketing.repos;

import com.orange.XRDigitalMarketing.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    public Client findByEmailAndPassword(String email,String password);
    Optional<Client> findByEmail(String email);
    Optional<Client> findByTel(String tel);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
