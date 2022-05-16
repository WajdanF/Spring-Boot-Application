package com.pularsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions") //The @Entity annotation specifies that the class is an entity and is mapped to a database table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) //The @JsonIgnoreProperties annotation specifies that the specified properties should be ignored when converting the object to JSON.
public class Session {
    @Id //The @Id annotation specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //The @GeneratedValue annotation specifies the generation strategy for the primary key of the entity (IDENTITY) - the primary key is auto-incremented by the database

    //The variable names are the column names in the database table
    private Long session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;
    @ManyToMany()//Setting up a many to many relationship and you have a mapping JoinTable in your database table to link the two tables(sessions and speakers)
    @JoinTable( //Defines the JoinTable nad the foreign key columns. This is the table that connects the two entities (sessions and speakers) together in a many to many relationship (session_speakers) and the foreign key columns are session_id and speaker_id respectively
            name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers; //The Many to Many relationship between session and speakers

    public Session() {

    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }


}
