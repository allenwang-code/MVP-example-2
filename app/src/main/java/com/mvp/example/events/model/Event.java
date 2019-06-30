package com.mvp.example.events.model;


public class Event {

    private TextHtml name;
    private TextHtml description;
    private EventDate start;
    private String url;
    private Logo logo;

    public TextHtml getName() {
        return name;
    }

    public TextHtml getDescription() {
        return description;
    }

    public EventDate getStart() {
        return start;
    }

    public String getUrl() {
        return url;
    }

    public Logo getLogo() {
        return logo;
    }

    public Event(String url) {
        this.url = url;
    }

}
