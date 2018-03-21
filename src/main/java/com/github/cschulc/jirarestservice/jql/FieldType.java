package com.github.cschulc.jirarestservice.jql;

import java.util.Arrays;
import java.util.List;

import static com.github.cschulc.jirarestservice.jql.Operator.*;

public enum FieldType {

    /**
     * The version.
     */
    VERSION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The user.
     */
    USER(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The category.
     */
    CATEGORY(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The text.
     */
    TEXT(CONTAINS, DOES_NOT_CONTAIN, IS, IS_NOT),

    /**
     * The component.
     */
    COMPONENT(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The date.
     */
    DATE(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The filter.
     */
    FILTER(EQUALS, NOT_EQUALS, IN, NOT_IN),

    /**
     * The issue.
     */
    ISSUE(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The security level.
     */
    SECURITY_LEVEL(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The duration.
     */
    DURATION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The priority.
     */
    PRIORITY(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The project.
     */
    PROJECT(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The resolution.
     */
    RESOLUTION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The number.
     */
    NUMBER(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The status.
     */
    STATUS(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The text master.
     */
    TEXT_MASTER(CONTAINS),

    /**
     * The issue type.
     */
    ISSUE_TYPE(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The custom type.
     */
    CUSTOM_TYPE;



    /**
     * List of supported operators for a type of field.
     */
    private final List<Operator> supportedOperators;

    /**
     * Instantiates a new field type.
     *
     * @param supportedOperators = the supported operators for a type
     */
    FieldType(Operator... supportedOperators) {
        this.supportedOperators = Arrays.asList(supportedOperators);
    }

    /**
     * Gets the list of supported opperators.
     *
     * @return the supported opperators
     */
    public List<Operator> getSupportedOperators() {
        return supportedOperators;
    }
}
