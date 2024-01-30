package com.syncgym.api.permission.enums;

public enum Permissions {

    ADMIN("ADMIN"),
    COMMON_USER("COMMON_USER");

    private final String description;

    Permissions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
