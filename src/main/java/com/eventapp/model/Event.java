package com.eventapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;
	private String name;
	private String local;
	private String date;
	private String hour;

	@OneToMany
	private List<Invited> inviteds;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public List<Invited> getInviteds() {
		return inviteds;
	}

	public void setInviteds(List<Invited> inviteds) {
		this.inviteds = inviteds;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", local=" + local + ", date=" + date + ", hour=" + hour + "]";
	}

}
