package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.entities.Tifo;
import com.orange.XRDigitalMarketing.exceptions.TifoNotFoundException;
import com.orange.XRDigitalMarketing.exceptions.TifoNotValidException;

import java.util.List;

public interface ITifoService {
 public Tifo createTifo(Tifo tifo);
 public List<Tifo> getTifos();
 public Tifo updateTifo(Tifo tifo) throws TifoNotFoundException, TifoNotValidException;
}
