package com.orange.XRDigitalMarketing.services;


import com.orange.XRDigitalMarketing.entities.ConfirmationToken;

import java.util.Optional;


public interface ConfirmationTokenService {
    public void saveConfirmationToken(ConfirmationToken token);
    public Optional<ConfirmationToken> getToken(String token);
    public int setConfirmedAt(String token);

}
