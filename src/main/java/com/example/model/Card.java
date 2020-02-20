package com.example.model;

import java.util.UUID;

/**
 * Represents a To-Do "card".
 *
 * @author <a href='mailto:dw5005@rit.edu'>Devon Welcheck</a>
 */
public class Card {
    private String uuid;
    private String title;
    private String description;
    private Status status;
    private String owner;

    /**
     * Constructor for Card that converts a status value string to its enum constant.
     * @param title String value of Card's title
     * @param description String value of Card's description
     * @param statusStr String value of Card's status
     * @param owner String value of Card's owner
     */
    public Card(String title, String description, String statusStr, String owner) {
        this.uuid = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.status = Status.valueOf(statusStr);
        this.owner = owner;
    }

    /**
     * Updates card's values based on provided values.
     * @param title String value of Card's title
     * @param description String value of Card's description
     * @param statusStr String value of Card's status
     * @param owner String value of Card's owner
     */
    public void updateCard(String title, String description, String statusStr, String owner){
        this.title = title;
        this.description = description;
        this.status = Status.valueOf(statusStr);
        this.owner = owner;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public String getOwner() {
        return owner;
    }
}
