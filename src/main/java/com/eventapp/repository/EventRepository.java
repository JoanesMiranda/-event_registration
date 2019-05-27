package com.eventapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
		
	Event findByCode(Long code);
}