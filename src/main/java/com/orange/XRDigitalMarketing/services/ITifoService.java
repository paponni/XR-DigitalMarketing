package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.entities.Tifo;
import com.orange.XRDigitalMarketing.exceptions.TifoNotFoundException;
import com.orange.XRDigitalMarketing.exceptions.TifoNotValidException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ITifoService {
 public Tifo createTifo(Tifo tifo,MultipartFile multipartFile) throws IOException;
 public List<Tifo> getTifos();
 public Tifo updateTifo(Tifo tifo) throws TifoNotFoundException, TifoNotValidException;
   public Tifo getTifo(Long id);
}
