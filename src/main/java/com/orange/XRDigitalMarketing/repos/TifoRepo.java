package com.orange.XRDigitalMarketing.repos;

import com.orange.XRDigitalMarketing.entities.Tifo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TifoRepo extends JpaRepository<Tifo,Long> {
}
