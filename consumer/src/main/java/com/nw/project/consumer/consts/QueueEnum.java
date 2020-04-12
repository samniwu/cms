package com.nw.project.consumer.consts;

public enum QueueEnum {
    USER("USER"),
    ARTICLE("ARTICLE"),
    AUDIO("AUDIO"),
    VIDEO("VIDEO");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    QueueEnum(String name) {
        this.name = name;
    }

    public QueueEnum findByName(String name) {
        for(QueueEnum queueEnum : QueueEnum.values()) {
            if (queueEnum.name.equalsIgnoreCase(name)) {
                return queueEnum;
            }
        }
        return null;
    }
}
