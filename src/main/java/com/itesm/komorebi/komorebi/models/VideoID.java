package com.itesm.komorebi.komorebi.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.io.Serializable;

public class VideoID implements Serializable {
    private String agent_name;
    private String timestamp;

    public VideoID(){}

    public VideoID(String agent_name, String timestamp){
        this.agent_name = agent_name;
        this.timestamp = timestamp;
    }

    @DynamoDBHashKey(attributeName = "agent_name")
    public String getAgent_name(){ return agent_name; }

    public void setAgent_name(String agent_name){ this.agent_name = agent_name; }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp(){ return timestamp; }

    public void setTimestamp(String timestamp){ this.timestamp = timestamp; }
}
