package com.pularsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers") // name of the table in the database (speakers)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) //The @JsonIgnoreProperties annotation specifies that the specified properties should be ignored when converting the object to JSON.

public class Speaker {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment

    private Long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob // large object as binary data can get very large so we use this annotation to help JPA handle it
    @Type(type = "org.hibernate.type.BinaryType")//Needed for hibernate deal with binary data (hibernate is the JPA implementation under the cover)
    private byte[] speaker_photo;
    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore // this is to avoid infinite loop when serializing the object to JSON because of the many to many relationship between speakers and sessions
    private List<Session> sessions;

    public Speaker(){

    }

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}

