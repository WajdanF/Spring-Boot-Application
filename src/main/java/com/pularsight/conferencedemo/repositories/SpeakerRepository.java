package com.pularsight.conferencedemo.repositories;
import com.pularsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;


//How to do access for data layering
//JPA Repositories are interfaces that provide access to the data layer for the application

//We have add, find, update, delete methods already setup on speaker JPA class
//Speaker is the datatype and Long refers to the primary key
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
