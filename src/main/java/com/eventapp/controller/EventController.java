package com.eventapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventapp.model.Event;
import com.eventapp.model.Invited;
import com.eventapp.repository.EventRepository;
import com.eventapp.repository.InvitedRepository;

@Controller
public class EventController {

	@Autowired
	EventRepository er;

	@Autowired
	InvitedRepository ir;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String registerEvent() {
		return "event/registerEvent";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String registerEvent(@Valid Event event, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		er.save(event);
		attributes.addFlashAttribute("mensagem", "Cadastrado com sucesso");
		return "redirect:/cadastrarEvento";
	}

	@RequestMapping("/eventos")
	public ModelAndView listEvents() {
		Iterable<Event> events = er.findAll();
		ModelAndView md = new ModelAndView("event/listEvents");
		md.addObject("events", events);
		return md;
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ModelAndView eventDetails(@PathVariable("code") Long code) {
		Event event = er.findByCode(code);
		ModelAndView mdEvent = new ModelAndView("event/eventDetails");
		mdEvent.addObject("event", event);

		Iterable<Invited> inviteds = ir.findByEvent(event);
		mdEvent.addObject("inviteds", inviteds);

		return mdEvent;
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.POST)
	public String eventDetails(@PathVariable("code") Long code, @Valid Invited invited, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Event event = er.findByCode(code);
		invited.setEvent(event);
		ir.save(invited);
		attributes.addFlashAttribute("mensagem", "Convidado Adicionado com sucesso!");
		return "redirect:/{code}";
	}

	@RequestMapping("/deletarEvento")
	public String deleteEvent(Long code) {
		Event event = er.findByCode(code);
		er.delete(event);
		return "redirect:/eventos";
	}

	@RequestMapping("/deletarConvidado")
	public String deleteInvited(String rg) {
		Invited invited = ir.findByRg(rg);
		ir.delete(invited);

		Event event = invited.getEvent();
		return "redirect:/" + event.getCode();
	}

}
