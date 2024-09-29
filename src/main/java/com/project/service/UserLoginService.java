package com.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.exception.UserAlreadyExists;
import com.project.model.UserDTO;

public interface UserLoginService {
	public String userLogin(UserDTO userDto) throws JsonProcessingException;
}
