package com.university.marketplace.cloudutils.event;

import java.time.LocalDateTime;

public abstract class MarketplaceEvent {

    private final String eventType;
    private final LocalDateTime timestamp;
    private final String source;
    private final String referenceId;

    protected MarketplaceEvent(String eventType, LocalDateTime timestamp, String source, String referenceId) {
        this.eventType = eventType;
        this.timestamp = timestamp;
        this.source = source;
        this.referenceId = referenceId;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public String getReferenceId() {
        return referenceId;
    }
}
