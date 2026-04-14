package com.university.marketplace.cloudutils.event;

import java.time.LocalDateTime;

public class ListingSoldEvent extends MarketplaceEvent {

    private final Long listingId;
    private final Long ownerId;
    private final String listingTitle;

    public ListingSoldEvent(Long listingId, Long ownerId, String listingTitle) {
        super("LISTING_SOLD", LocalDateTime.now(), "listing-service", String.valueOf(listingId));
        this.listingId = listingId;
        this.ownerId = ownerId;
        this.listingTitle = listingTitle;
    }

    public Long getListingId() {
        return listingId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getListingTitle() {
        return listingTitle;
    }
}
