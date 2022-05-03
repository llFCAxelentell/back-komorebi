package com.itesm.komorebi.komorebi.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.springframework.data.annotation.Id;

import java.util.Set;

@DynamoDBTable(tableName="Staff")
public class Empleado {

    @Id
    private EmpleadoID empleadoID;

    private String name_staff;
    private Boolean active;
    private String email;
    private String phone;
    private Set<String> agents_name;
    private String last_session;
    private String password;

    @DynamoDBHashKey(attributeName = "role")
    public String getRole() {

        return empleadoID != null ? empleadoID.getRole(): null;
    }

    public void setRole(String role) {

        if(empleadoID == null){
            empleadoID = new EmpleadoID();
        }
        empleadoID.setRole(role);
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp() {

        return empleadoID != null ? empleadoID.getTimestamp(): null;
    }

    public void setTimestamp(String timestamp) {

        if(empleadoID == null){
            empleadoID = new EmpleadoID();
        }
        empleadoID.setTimestamp(timestamp);
    }

    @DynamoDBAttribute
    public String getName_staff() {
        return name_staff;
    }

    public void setName_staff(String name_staff) {
        this.name_staff = name_staff;
    }

    @DynamoDBAttribute
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @DynamoDBAttribute
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @DynamoDBAttribute
    public Set<String> getAgents_name() {
        return agents_name;
    }

    public void setAgents_name(Set<String> agents_name) {
        this.agents_name = agents_name;
    }

    @DynamoDBAttribute
    public String getLast_session() {
        return last_session;
    }

    public void setLast_session(String last_session) {
        this.last_session = last_session;
    }

    @DynamoDBAttribute
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
