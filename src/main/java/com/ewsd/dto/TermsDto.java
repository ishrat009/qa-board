package com.ewsd.dto;

import java.io.Serializable;

public class TermsDto implements Serializable {

    private Long id;
    private String textMessage;

    public TermsDto() {
    }

    public TermsDto(Long id, String textMessage) {
        this.id = id;
        this.textMessage = textMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}