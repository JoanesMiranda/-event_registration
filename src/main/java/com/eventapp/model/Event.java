package com.eventapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;
	@NotEmpty(message = "O campo nome é obrigatorio")
	private String name;
	@NotEmpty(message = "O campo local é obrigatorio")
	private String local;
	@NotEmpty(message = "O campo data é obrigatorio")
	private String date;
	@NotEmpty(message = "O campo hora é obrigatorio")
	private String hour;

	@OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
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
