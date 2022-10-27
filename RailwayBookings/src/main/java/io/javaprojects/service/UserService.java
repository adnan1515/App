package io.javaprojects.service;

import io.javaprojects.model.User;
import io.javaprojects.web.dto.UserRegistrationDTO;

public interface UserService {
	User save(UserRegistrationDTO dto);
}
