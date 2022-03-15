package com.orange.XRDigitalMarketing.services.impl;


import com.orange.XRDigitalMarketing.entities.ConfirmationToken;
import com.orange.XRDigitalMarketing.repos.ConfirmationTokenRepo;
import com.orange.XRDigitalMarketing.services.ConfirmationTokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenImpl implements ConfirmationTokenService {

    private final ConfirmationTokenRepo tokenRepo;

    public ConfirmationTokenImpl(ConfirmationTokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    public void saveConfirmationToken(ConfirmationToken token) {
        tokenRepo.save(token);
    }

    @Override
    public Optional<ConfirmationToken> getToken(String token) {
        return tokenRepo.findByToken(token);
    }

    @Override
    public int setConfirmedAt(String token) {
        return tokenRepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
