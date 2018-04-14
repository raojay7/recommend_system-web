package com.recommend_system.hotsearch.entity;

import java.io.Serializable;

public class HotSearch implements Serializable {
    private Integer hotsearchId;

    private String content;

    private Integer frequency;

    private static final long serialVersionUID = 1L;

    public Integer getHotsearchId() {
        return hotsearchId;
    }

    public void setHotsearchId(Integer hotsearchId) {
        this.hotsearchId = hotsearchId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}