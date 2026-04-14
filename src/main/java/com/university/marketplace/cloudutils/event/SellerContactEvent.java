package com.university.marketplace.cloudutils.event;

import java.time.LocalDateTime;

public class SellerContactEvent extends MarketplaceEvent {

    private final Long listingId;
    private final String listingTitle;
    private final Double listingPrice;
    private final Long sellerId;
    private final String sellerName;
    private final String sellerEmail;
    private final Long buyerId;
    private final String buyerName;
    private final String buyerEmail;
    private final String messageType;

    public SellerContactEvent(Long listingId,
                              String listingTitle,
                              Double listingPrice,
                              Long sellerId,
                              String sellerName,
                              String sellerEmail,
                              Long buyerId,
                              String buyerName,
                              String buyerEmail,
                              String messageType) {
        super("BUYER_CONTACTED_SELLER", LocalDateTime.now(), "dashboard-marketplace", String.valueOf(listingId));
        this.listingId = listingId;
        this.listingTitle = listingTitle;
        this.listingPrice = listingPrice;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.messageType = messageType;
    }

    public Long getListingId() {
        return listingId;
    }

    public String getListingTitle() {
        return listingTitle;
    }

    public Double getListingPrice() {
        return listingPrice;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public String getMessageType() {
        return messageType;
    }
}
