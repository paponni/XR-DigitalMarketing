package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.utils.RegistrationRequest;

public interface RegistrationService {
    public String register(RegistrationRequest registrationRequest) throws Exception;
    public String confirmToken(String token);
}
