package com.orange.XRDigitalMarketing.repos;

import com.orange.XRDigitalMarketing.entities.Bufcart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface CartRepo extends JpaRepository<Bufcart,Long> {

    List<Bufcart> findByEmail(String email);
    Bufcart findByBufcartIDAndEmail(Long bufcartID , String email);
    void deleteByBufcartIDAndEmail(Long bufcartID, String email);
    List<Bufcart> findAllByEmail(String email);
    List<Bufcart> findAllByOrderID(Long orderID);
}
