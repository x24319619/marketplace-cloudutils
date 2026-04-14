package com.university.marketplace.cloudutils.event;

import java.time.LocalDateTime;

public class ListingCreatedEvent extends MarketplaceEvent {

    private final Long listingId;
    private final Long ownerId;
    private final String category;
    private final Double price;
    private final String status;

    public ListingCreatedEvent(Long listingId, Long ownerId, String category, Double price, String status) {
        super("LISTING_CREATED", LocalDateTime.now(), "listing-service", String.valueOf(listingId));
        this.listingId = listingId;
        this.ownerId = ownerId;
        this.category = category;
        this.price = price;
        this.status = status;
    }

    public Long getListingId() {
        return listingId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}
