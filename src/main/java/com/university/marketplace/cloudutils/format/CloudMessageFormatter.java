package com.university.marketplace.cloudutils.format;

import com.university.marketplace.cloudutils.event.ListingCreatedEvent;
import com.university.marketplace.cloudutils.event.ListingRentedEvent;
import com.university.marketplace.cloudutils.event.ListingSoldEvent;
import com.university.marketplace.cloudutils.event.MarketplaceEvent;
import com.university.marketplace.cloudutils.event.MessageSentEvent;
import com.university.marketplace.cloudutils.event.SellerContactEvent;
import com.university.marketplace.cloudutils.event.SignupVerificationEvent;
import com.university.marketplace.cloudutils.notification.NotificationPayloadBuilder;

public class CloudMessageFormatter {

    private final NotificationPayloadBuilder notificationPayloadBuilder = new NotificationPayloadBuilder();

    public String formatForQueue(MarketplaceEvent event) {
        if (event instanceof SellerContactEvent sellerContactEvent) {
            return "{"
                    + "\"eventType\":\"" + escape(event.getEventType()) + "\","
                    + "\"requestedAt\":\"" + escape(event.getTimestamp().toString()) + "\","
                    + "\"source\":\"" + escape(event.getSource()) + "\","
                    + "\"referenceId\":\"" + escape(event.getReferenceId()) + "\","
                    + "\"listingId\":" + sellerContactEvent.getListingId() + ","
                    + "\"listingTitle\":\"" + escape(sellerContactEvent.getListingTitle()) + "\","
                    + "\"listingPrice\":" + (sellerContactEvent.getListingPrice() == null ? "null" : sellerContactEvent.getListingPrice()) + ","
                    + "\"sellerId\":" + sellerContactEvent.getSellerId() + ","
                    + "\"sellerName\":\"" + escape(sellerContactEvent.getSellerName()) + "\","
                    + "\"sellerEmail\":\"" + escape(sellerContactEvent.getSellerEmail()) + "\","
                    + "\"buyerId\":" + sellerContactEvent.getBuyerId() + ","
                    + "\"buyerName\":\"" + escape(sellerContactEvent.getBuyerName()) + "\","
                    + "\"buyerEmail\":\"" + escape(sellerContactEvent.getBuyerEmail()) + "\","
                    + "\"messageType\":\"" + escape(sellerContactEvent.getMessageType()) + "\""
                    + "}";
        }
        if (event instanceof ListingCreatedEvent listingCreatedEvent) {
            return "{"
                    + "\"eventType\":\"" + escape(event.getEventType()) + "\","
                    + "\"timestamp\":\"" + escape(event.getTimestamp().toString()) + "\","
                    + "\"source\":\"" + escape(event.getSource()) + "\","
                    + "\"referenceId\":\"" + escape(event.getReferenceId()) + "\","
                    + "\"listingId\":" + listingCreatedEvent.getListingId() + ","
                    + "\"ownerId\":" + listingCreatedEvent.getOwnerId() + ","
                    + "\"category\":\"" + escape(listingCreatedEvent.getCategory()) + "\","
                    + "\"price\":" + (listingCreatedEvent.getPrice() == null ? "null" : listingCreatedEvent.getPrice()) + ","
                    + "\"status\":\"" + escape(listingCreatedEvent.getStatus()) + "\""
                    + "}";
        }
        if (event instanceof ListingSoldEvent listingSoldEvent) {
            return "{"
                    + "\"eventType\":\"" + escape(event.getEventType()) + "\","
                    + "\"timestamp\":\"" + escape(event.getTimestamp().toString()) + "\","
                    + "\"source\":\"" + escape(event.getSource()) + "\","
                    + "\"referenceId\":\"" + escape(event.getReferenceId()) + "\","
                    + "\"listingId\":" + listingSoldEvent.getListingId() + ","
                    + "\"ownerId\":" + listingSoldEvent.getOwnerId() + ","
                    + "\"listingTitle\":\"" + escape(listingSoldEvent.getListingTitle()) + "\""
                    + "}";
        }
        if (event instanceof ListingRentedEvent listingRentedEvent) {
            return "{"
                    + "\"eventType\":\"" + escape(event.getEventType()) + "\","
                    + "\"timestamp\":\"" + escape(event.getTimestamp().toString()) + "\","
                    + "\"source\":\"" + escape(event.getSource()) + "\","
                    + "\"referenceId\":\"" + escape(event.getReferenceId()) + "\","
                    + "\"listingId\":" + listingRentedEvent.getListingId() + ","
                    + "\"ownerId\":" + listingRentedEvent.getOwnerId() + ","
                    + "\"listingTitle\":\"" + escape(listingRentedEvent.getListingTitle()) + "\""
                    + "}";
        }
        if (event instanceof MessageSentEvent messageSentEvent) {
            return "{"
                    + "\"eventType\":\"" + escape(event.getEventType()) + "\","
                    + "\"timestamp\":\"" + escape(event.getTimestamp().toString()) + "\","
                    + "\"source\":\"" + escape(event.getSource()) + "\","
                    + "\"referenceId\":\"" + escape(event.getReferenceId()) + "\","
                    + "\"listingId\":" + messageSentEvent.getListingId() + ","
                    + "\"listingTitle\":\"" + escape(messageSentEvent.getListingTitle()) + "\","
                    + "\"senderId\":" + messageSentEvent.getSenderId() + ","
                    + "\"senderName\":\"" + escape(messageSentEvent.getSenderName()) + "\","
                    + "\"recipientId\":" + messageSentEvent.getRecipientId() + ","
                    + "\"recipientName\":\"" + escape(messageSentEvent.getRecipientName()) + "\","
                    + "\"messagePreview\":\"" + escape(messageSentEvent.getMessagePreview()) + "\""
                    + "}";
        }

        return "{"
                + "\"eventType\":\"" + escape(event.getEventType()) + "\","
                + "\"timestamp\":\"" + escape(event.getTimestamp().toString()) + "\","
                + "\"source\":\"" + escape(event.getSource()) + "\","
                + "\"referenceId\":\"" + escape(event.getReferenceId()) + "\""
                + "}";
    }

    public String formatForEmail(MarketplaceEvent event) {
        if (event instanceof SellerContactEvent sellerContactEvent) {
            return notificationPayloadBuilder.buildSellerContactMessage(sellerContactEvent);
        }
        if (event instanceof ListingCreatedEvent listingCreatedEvent) {
            return notificationPayloadBuilder.buildListingCreatedMessage(listingCreatedEvent);
        }
        if (event instanceof ListingSoldEvent listingSoldEvent) {
            return notificationPayloadBuilder.buildListingClosedMessage(listingSoldEvent);
        }
        if (event instanceof ListingRentedEvent listingRentedEvent) {
            return notificationPayloadBuilder.buildListingClosedMessage(listingRentedEvent);
        }
        if (event instanceof MessageSentEvent messageSentEvent) {
            return notificationPayloadBuilder.buildMessageSentMessage(messageSentEvent);
        }
        if (event instanceof SignupVerificationEvent signupVerificationEvent) {
            return notificationPayloadBuilder.buildSignupVerificationMessage(signupVerificationEvent);
        }
        return event.getEventType() + " triggered at " + event.getTimestamp();
    }

    public String formatForNotification(MarketplaceEvent event) {
        if (event instanceof SellerContactEvent sellerContactEvent) {
            return notificationPayloadBuilder.buildSellerContactSubject(sellerContactEvent);
        }
        if (event instanceof ListingCreatedEvent listingCreatedEvent) {
            return notificationPayloadBuilder.buildListingCreatedSubject(listingCreatedEvent);
        }
        if (event instanceof ListingSoldEvent listingSoldEvent) {
            return notificationPayloadBuilder.buildListingClosedSubject(listingSoldEvent);
        }
        if (event instanceof ListingRentedEvent listingRentedEvent) {
            return notificationPayloadBuilder.buildListingClosedSubject(listingRentedEvent);
        }
        if (event instanceof MessageSentEvent messageSentEvent) {
            return notificationPayloadBuilder.buildMessageSentSubject(messageSentEvent);
        }
        if (event instanceof SignupVerificationEvent signupVerificationEvent) {
            return notificationPayloadBuilder.buildSignupVerificationSubject(signupVerificationEvent);
        }
        return event.getEventType();
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}
