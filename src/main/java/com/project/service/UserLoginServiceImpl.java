package com.project.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.exception.MobileNumberNotFound;
import com.project.exception.UserAlreadyExists;
import com.project.model.CurrentUserSession;
import com.project.model.User;
import com.project.model.UserDTO;
import com.project.repository.CurrentUserSessionDao;
import com.project.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	private CurrentUserSessionDao currentusersessionDao;
	
	@Autowired
	private UserDao uDao;

	@Override
	public String userLogin(UserDTO userDto) throws JsonProcessingException {

		User u = uDao.findByMobile(userDto.getMobileNo());

		if(u==null) {
			throw new MobileNumberNotFound("Mobile number is not found");
		}
		Integer Id = Integer.valueOf((currentusersessionDao.findByUserId(u.getUserId()))==null? "0" : (currentusersessionDao.findByUserId(u.getUserId())));
		/* Optional<CurrentUserSession> opt1 = currentusersessionDao.findById(Id); */
		if(Id !=0) {
			throw new UserAlreadyExists("User Already loged in");
		}
		
		if(u.getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(u.getUserId(), key,LocalDateTime.now());
			currentusersessionDao.save(currentUserSession);
			return "User Logged in successfully - Unique ID: " + currentUserSession.getUniqueId().toString();
			
		}else return "Password does not match";
	
	}

}
