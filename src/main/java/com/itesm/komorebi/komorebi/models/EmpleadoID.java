package com.itesm.komorebi.komorebi.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.io.Serializable;

public class EmpleadoID implements Serializable {
    private String role;
    private String timestamp;

    public EmpleadoID(){}

    public EmpleadoID(String role, String timestamp) {
        this.role = role;
        this.timestamp = timestamp;
    }

    @DynamoDBHashKey(attributeName = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
