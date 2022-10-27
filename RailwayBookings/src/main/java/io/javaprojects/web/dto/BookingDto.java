package io.javaprojects.web.dto;

public class BookingDto {
	private String fromStation;
	private String toStation;
	private String timing;

	public BookingDto() {

	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public BookingDto(String fromStation, String toStation, String timing) {
		super();
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.timing = timing;
	}

}
