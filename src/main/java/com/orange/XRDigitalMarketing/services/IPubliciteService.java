package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.entities.Publicite;
import com.orange.XRDigitalMarketing.exceptions.PubliciteNotValidException;

import java.util.List;

public interface IPubliciteService {
    public Publicite createPublicite(Publicite publicite) throws PubliciteNotValidException;
    public List<Publicite> getAllPublicites();
}
