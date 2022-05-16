package com.pularsight.conferencedemo.repositories;

import com.pularsight.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

//How to do access for data layering
//JPA Repositories are interfaces that provide access to the data layer for the application

//We have add, find, update, delete methods already setup on session JPA class
//Session entity is the datatype and Long refers to the primary key
public interface SessionRepository extends JpaRepository<Session, Long> {
}
