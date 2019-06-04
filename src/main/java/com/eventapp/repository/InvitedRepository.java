package com.eventapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventapp.model.Event;
import com.eventapp.model.Invited;

public interface InvitedRepository extends CrudRepository<Invited, String>{
	Iterable<Invited> findByEvent(Event event);
	

}
