package com.orange.XRDigitalMarketing.controllers;


import com.orange.XRDigitalMarketing.entities.Tifo;
import com.orange.XRDigitalMarketing.exceptions.TifoNotFoundException;
import com.orange.XRDigitalMarketing.exceptions.TifoNotValidException;
import com.orange.XRDigitalMarketing.services.ITifoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TifoController {

    private final ITifoService tifoService ;

    public TifoController(ITifoService tifoService) {
        this.tifoService = tifoService;
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Tifo createTifo(@RequestBody Tifo tifo){
        return tifoService.createTifo(tifo);
    }

    @GetMapping("/tifos")
    @ResponseStatus(HttpStatus.OK)
    public List<Tifo> loadTifos() {
        return  tifoService.getTifos();
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Tifo updateTifo(@RequestBody Tifo tifo) throws TifoNotValidException, TifoNotFoundException {
        return tifoService.updateTifo(tifo);
    }

}
