package com.university.marketplace.cloudutils.event;

import java.time.LocalDateTime;

public class SignupVerificationEvent extends MarketplaceEvent {

    private final String email;
    private final String verificationLink;

    public SignupVerificationEvent(String email, String verificationLink) {
        super("SIGNUP_VERIFICATION_REQUESTED", LocalDateTime.now(), "auth-service", email == null ? "" : email);
        this.email = email;
        this.verificationLink = verificationLink;
    }

    public String getEmail() {
        return email;
    }

    public String getVerificationLink() {
        return verificationLink;
    }
}
