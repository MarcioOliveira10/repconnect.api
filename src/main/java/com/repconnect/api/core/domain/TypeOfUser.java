package com.repconnect.api.core.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.repconnect.api.core.exception.IllegalArgumentExceptions;

public enum TypeOfUser {
    SELLER("Seller"),
    ADMIN("Admin"),
    SUPER_ADMIN("Super_admin"),
    CHARGE("Charge");

    private String value;

     TypeOfUser(String value){
        this.value = value;
    }
    @JsonValue
    public String getValue() {
        return this.name().toLowerCase();
    }
    @JsonCreator
    public static TypeOfUser fromJsonNode(JsonNode jsonNode) {
        if (jsonNode.isTextual()) {
            String value = jsonNode.textValue();
            for (TypeOfUser type : TypeOfUser.values()) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
        }
        throw new IllegalArgumentExceptions("Invalid TypeOfUser value: " + jsonNode);
    }

    @Override
    public String toString() {
        return "TypeOfUser{" +
                "value='" + value + '\'' +
                '}';
    }
}
