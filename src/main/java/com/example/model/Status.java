package com.example.model;

/**
 * Enumeration representing the possible statuses of the Card.
 *
 * @author <a href='mailto:dw5005@rit.edu'>Devon Welcheck</a>
 */
public enum Status {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private String description;
    Status(String description){
        this.description = description;
    }

    /**
     * Gets a pretty-printed string representation of the enum value.
     * May be linted as unused, but is used in Freemarker template.
     * @return String of pretty-printed enum value
     */
    public String getDescription(){
        return this.description;
    }
}
