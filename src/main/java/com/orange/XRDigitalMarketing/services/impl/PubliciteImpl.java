package com.orange.XRDigitalMarketing.services.impl;

import com.orange.XRDigitalMarketing.entities.Publicite;
import com.orange.XRDigitalMarketing.exceptions.PubliciteNotValidException;
import com.orange.XRDigitalMarketing.repos.PubliciteRepo;
import com.orange.XRDigitalMarketing.services.IPubliciteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PubliciteImpl implements IPubliciteService {

    private final PubliciteRepo publiciteRepo;

    public PubliciteImpl(PubliciteRepo publiciteRepo) {
        this.publiciteRepo = publiciteRepo;
    }

    @Override
    public Publicite createPublicite(Publicite publicite) throws PubliciteNotValidException {
        log.info("save publicite {}",publicite.getNomPub());
        LocalDate dateSystem = LocalDate.now();
        if(publicite.getDateAffichage().compareTo(dateSystem)>=0
        && publicite.getHeureAffichge().compareTo(publicite.getTicket().getHeureMatch())>=0
                && publicite.getDureeAffichage() * 60 >0 && publicite.getDureeAffichage() * 60 < 5400){
            publiciteRepo.save(publicite);
        }
        else {
            throw new PubliciteNotValidException(publicite.getId());
        }
        return publicite;
    }

    @Override
    public List<Publicite> getAllPublicites() {
        log.info("fetch all publicite");
        return publiciteRepo.findAll();
    }
}
