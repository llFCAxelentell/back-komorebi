package com.itesm.komorebi.komorebi.dto;

import java.util.List;
import java.util.Set;

public class VideoDTO {
    private String agent_name;
    private String timestamp;
    private Integer staff_id;
    private String video_id;
    private Float duration;
    private Set<String> category;
    private Set<String> tags;
    private List notes;
    private String customer;
    private List configuration;
    private Boolean successful_outcome;
    private List chat;

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Set<String> getCategory() {
        return category;
    }

    public void setCategory(Set<String> category) {
        this.category = category;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public List getNotes() {
        return notes;
    }

    public void setNotes(List notes) {
        this.notes = notes;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List getConfiguration() {
        return configuration;
    }

    public void setConfiguration(List configuration) {
        this.configuration = configuration;
    }

    public Boolean getSuccessful_outcome() {
        return successful_outcome;
    }

    public void setSuccessful_outcome(Boolean successful_outcome) {
        this.successful_outcome = successful_outcome;
    }

    public List getChat() {
        return chat;
    }

    public void setChat(List chat) {
        this.chat = chat;
    }
}
