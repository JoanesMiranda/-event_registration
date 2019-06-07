package com.eventapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Invited implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty
	private String rg;
	@NotEmpty
	private String name;

	@ManyToOne
	private Event event;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Invited [rg=" + rg + ", name=" + name + "]";
	}

}
