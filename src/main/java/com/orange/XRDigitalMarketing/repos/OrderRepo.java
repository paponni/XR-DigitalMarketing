package com.orange.XRDigitalMarketing.repos;


import com.orange.XRDigitalMarketing.entities.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderRepo  extends JpaRepository<PlaceOrder,Long> {
    PlaceOrder findByOrderID(Long orderID);
    List<PlaceOrder> findAll();
}
