package com.orange.XRDigitalMarketing.repos;

import com.orange.XRDigitalMarketing.entities.Publicite;
import com.orange.XRDigitalMarketing.entities.Tifo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubliciteRepo extends JpaRepository<Publicite,Long> {
}
