package com.university.marketplace.cloudutils.event;

import java.time.LocalDateTime;

public class MessageSentEvent extends MarketplaceEvent {

    private final Long listingId;
    private final String listingTitle;
    private final Long senderId;
    private final String senderName;
    private final Long recipientId;
    private final String recipientName;
    private final String messagePreview;

    public MessageSentEvent(Long listingId,
                            String listingTitle,
                            Long senderId,
                            String senderName,
                            Long recipientId,
                            String recipientName,
                            String messagePreview) {
        super("MESSAGE_SENT", LocalDateTime.now(), "marketplace-chat", String.valueOf(listingId));
        this.listingId = listingId;
        this.listingTitle = listingTitle;
        this.senderId = senderId;
        this.senderName = senderName;
        this.recipientId = recipientId;
        this.recipientName = recipientName;
        this.messagePreview = messagePreview;
    }

    public Long getListingId() {
        return listingId;
    }

    public String getListingTitle() {
        return listingTitle;
    }

    public Long getSenderId() {
        return senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getMessagePreview() {
        return messagePreview;
    }
}
