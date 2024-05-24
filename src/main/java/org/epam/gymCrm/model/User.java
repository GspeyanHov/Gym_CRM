package org.epam.gymCrm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public abstract class User {

    @JsonProperty(value="id")
    private int id;
    @JsonProperty(value="firstname")
    private String firstname;
    @JsonProperty(value="lastname")
    private String lastname;
    @JsonProperty(value="username")
    private String username;
    @JsonProperty(value="password")
    private String password;
    @JsonProperty(value="isActive")
    private boolean isActive;

    @Override
    public String toString() {
        return
                "id= " + id +
                ", firstname= " + firstname + '\'' +
                ", lastname= " + lastname + '\'' +
                ", username= " + username + '\'' +
                ", password= " + password + '\'' +
                ", isActive= " + isActive;
    }
}
