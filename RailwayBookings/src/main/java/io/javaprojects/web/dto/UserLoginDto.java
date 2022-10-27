package io.javaprojects.web.dto;

public class UserLoginDto {
	private String emailOrPhone;
	private String password;

	public UserLoginDto(String emailOrPhone, String password) {
		super();
		this.emailOrPhone = emailOrPhone;
		this.password = password;
	}

	public UserLoginDto() {

	}

	public String getEmailOrPhone() {
		return emailOrPhone;
	}

	public void setEmailOrPhone(String emailOrPhone) {
		this.emailOrPhone = emailOrPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
