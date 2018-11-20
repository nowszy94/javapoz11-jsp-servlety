package com.sda.servlets.links;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {
    private Integer id;
    private String url;
    private String text;

    @JsonCreator
    public Link(
            @JsonProperty("id") Integer id,
            @JsonProperty("url") String url,
            @JsonProperty("text") String text) {
        this.id = id;
        this.url = url;
        this.text = text;
    }

    public Link(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
