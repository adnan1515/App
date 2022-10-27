package io.javaprojects.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fromStation;
	private String toStation;
	private String time;

	public Bookings() {

	}

	public Bookings(String fromStation, String toStation, String time) {
		super();
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return fromStation;
	}

	public void setFrom(String from) {
		this.fromStation = from;
	}

	public String getTo() {
		return toStation;
	}

	public void setTo(String to) {
		this.toStation = to;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
