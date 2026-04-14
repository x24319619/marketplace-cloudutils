package com.university.marketplace.cloudutils.notification;

import com.university.marketplace.cloudutils.event.ListingCreatedEvent;
import com.university.marketplace.cloudutils.event.ListingRentedEvent;
import com.university.marketplace.cloudutils.event.ListingSoldEvent;
import com.university.marketplace.cloudutils.event.MessageSentEvent;
import com.university.marketplace.cloudutils.event.SellerContactEvent;
import com.university.marketplace.cloudutils.event.SignupVerificationEvent;

public class NotificationPayloadBuilder {

    public String buildSellerContactSubject(SellerContactEvent event) {
        return "Buyer interested in " + defaultValue(event.getListingTitle(), "your listing");
    }

    public String buildSellerContactMessage(SellerContactEvent event) {
        return defaultValue(event.getBuyerName(), "A buyer")
                + " is interested in "
                + defaultValue(event.getListingTitle(), "your listing")
                + ". Buyer email: "
                + defaultValue(event.getBuyerEmail(), "not provided");
    }

    public String buildListingCreatedMessage(ListingCreatedEvent event) {
        return "Listing " + event.getListingId()
                + " created in category "
                + defaultValue(event.getCategory(), "unknown")
                + " with status "
                + defaultValue(event.getStatus(), "unknown");
    }

    public String buildListingCreatedSubject(ListingCreatedEvent event) {
        return "New marketplace listing";
    }

    public String buildListingClosedSubject(ListingSoldEvent event) {
        return "Listing sold: " + defaultValue(event.getListingTitle(), "your listing");
    }

    public String buildListingClosedSubject(ListingRentedEvent event) {
        return "Listing rented: " + defaultValue(event.getListingTitle(), "your listing");
    }

    public String buildListingClosedMessage(ListingSoldEvent event) {
        return "Listing " + defaultValue(event.getListingTitle(), "your listing") + " has been marked as sold.";
    }

    public String buildListingClosedMessage(ListingRentedEvent event) {
        return "Listing " + defaultValue(event.getListingTitle(), "your listing") + " has been marked as rented.";
    }

    public String buildMessageSentSubject(MessageSentEvent event) {
        return "New message about " + defaultValue(event.getListingTitle(), "your listing");
    }

    public String buildMessageSentMessage(MessageSentEvent event) {
        return defaultValue(event.getSenderName(), "Someone")
                + " sent a message about "
                + defaultValue(event.getListingTitle(), "your listing")
                + ": "
                + defaultValue(event.getMessagePreview(), "Open the conversation to view the latest message.");
    }

    public String buildSignupVerificationSubject(SignupVerificationEvent event) {
        return "Verify your University Marketplace account";
    }

    public String buildSignupVerificationMessage(SignupVerificationEvent event) {
        return "<html><body style='font-family:Arial,sans-serif;background:#f6f9fc;padding:24px;'>"
                + "<div style='max-width:620px;margin:0 auto;background:#ffffff;border:1px solid #d2dce5;border-radius:12px;padding:24px;'>"
                + "<h2 style='margin-top:0;color:#12283a;'>University Marketplace</h2>"
                + "<p style='color:#42576a;'>Click the button below to verify your email and create your account.</p>"
                + "<p style='margin:24px 0;'>"
                + "<a href='" + defaultValue(event.getVerificationLink(), "#") + "' "
                + "style='display:inline-block;background:#1f6f8b;color:#ffffff;text-decoration:none;padding:12px 18px;border-radius:8px;font-weight:700;'>"
                + "Verify Account</a></p>"
                + "<p style='color:#607586;font-size:13px;'>This verification link expires in 24 hours.</p>"
                + "</div></body></html>";
    }

    private String defaultValue(String value, String fallback) {
        return value == null || value.isBlank() ? fallback : value;
    }
}
