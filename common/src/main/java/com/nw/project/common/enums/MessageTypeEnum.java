package com.nw.project.common.enums;

public enum MessageTypeEnum {
    USER("USER");

    private String type;

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    MessageTypeEnum(String type) {
        this.type = type;
    }
}
