package com.itesm.komorebi.komorebi.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Set;

@DynamoDBTable(tableName="Recording")
public class Video {
    @Id
    private VideoID videoID;

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

    @DynamoDBHashKey(attributeName = "agent_name")
    public String getAgent_name() {

        return videoID != null ? videoID.getAgent_name(): null;
    }

    public void setAgent_name(String agent_name) {

        if(videoID == null){
            videoID = new VideoID();
        }
        videoID.setAgent_name(agent_name);
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp() {

        return videoID != null ? videoID.getTimestamp(): null;
    }

    public void setTimestamp(String timestamp) {

        if(videoID == null){
            videoID = new VideoID();
        }
        videoID.setTimestamp(timestamp);
    }

    @DynamoDBAttribute
    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    @DynamoDBAttribute
    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    @DynamoDBAttribute
    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    @DynamoDBAttribute
    public Set<String> getCategory() {
        return category;
    }

    public void setCategory(Set<String> category) {
        this.category = category;
    }

    @DynamoDBAttribute
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @DynamoDBAttribute
    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    @DynamoDBAttribute
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @DynamoDBAttribute
    public List<Integer> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(List<Integer> configuration) {
        this.configuration = configuration;
    }

    @DynamoDBAttribute
    public Boolean getSuccessful_outcome() {
        return successful_outcome;
    }

    public void setSuccessful_outcome(Boolean successful_outcome) {
        this.successful_outcome = successful_outcome;
    }

    @DynamoDBAttribute
    public List<String> getChat() {
        return chat;
    }

    public void setChat(List<String> chat) {
        this.chat = chat;
    }

}
