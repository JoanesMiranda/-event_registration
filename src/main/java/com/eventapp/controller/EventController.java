package com.eventapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventapp.model.Event;
import com.eventapp.repository.EventRepository;

@Controller
public class EventController {
	
	@Autowired
	EventRepository er;

	@RequestMapping(value = "/registerEvent", method = RequestMethod.GET)
	public String registerEvent() {
		return "event/registerEvent";
	}
	
	@RequestMapping(value = "/registerEvent", method = RequestMethod.POST)
	public String registerEvent(Event event) {
		er.save(event);
		return "redirect:/registerEvent";
	}

	@RequestMapping("/events")
	public ModelAndView listEvents() {
		Iterable<Event> events = er.findAll();
		ModelAndView md = new ModelAndView("event/listEvents");
		md.addObject("events", events);
		return md;
	}
	
	@RequestMapping("/{code}")
	public ModelAndView eventDetails(@PathVariable("code") Long code) {
		Event event = er.findByCode(code);
		ModelAndView mdEvent = new ModelAndView("event/eventDetails");
		mdEvent.addObject("event", event);
		return mdEvent;
	}
		
	
}
