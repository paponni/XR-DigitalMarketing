package com.orange.XRDigitalMarketing.services.impl;

import com.orange.XRDigitalMarketing.entities.Tifo;
import com.orange.XRDigitalMarketing.exceptions.TifoNotFoundException;
import com.orange.XRDigitalMarketing.exceptions.TifoNotValidException;
import com.orange.XRDigitalMarketing.repos.TifoRepo;
import com.orange.XRDigitalMarketing.services.ITifoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@Slf4j
public class TifoImpl implements ITifoService {

    private final TifoRepo tifoRepo;

    public TifoImpl(TifoRepo tifoRepo) {
        this.tifoRepo = tifoRepo;
    }

    @Override
    public Tifo createTifo(Tifo tifo) {
        log.info("save tifo : {}",tifo.getNomEquipe());
        LocalDate dateSystem = LocalDate.now();
        if(tifo.getDateAffichage().compareTo(dateSystem)>=0 &&
            tifo.getHeureAffichge().compareTo(tifo.getTicket().getHeureMatch()) >=0
                && tifo.getDureeAffichage() * 60 >0 && tifo.getDureeAffichage() * 60 < 5400)
        {tifoRepo.save(tifo);}
        return tifo;
    }

    @Override
    public List<Tifo> getTifos() {
        log.info("fetch all tifos");
        return tifoRepo.findAll();
    }

    @Override
    public Tifo updateTifo(Tifo tifo) throws TifoNotFoundException, TifoNotValidException {
        log.info("update tifo : {}",tifo.getId());
        Tifo tifoFromDB = tifoRepo.findById(tifo.getId()).orElse(null);
        LocalDate localDate = LocalDate.now();
        if(tifoFromDB == null)
            throw new TifoNotFoundException(tifo.getId());
        if(tifo.getDateAffichage().compareTo(localDate)>=0
        && tifo.getHeureAffichge().compareTo(tifo.getTicket().getHeureMatch())>=0){
            tifo.setId(tifoFromDB.getId());
            return tifoRepo.save(tifo);
        }
        else{
            throw new TifoNotValidException("invalid tifo ") ;
        }
    }


}
