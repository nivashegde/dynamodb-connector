package org.csulb.md.service;

import java.util.Optional;

import org.csulb.md.pojo.UserInfo;
import org.csulb.md.repo.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBService {
	
	Logger logger = LoggerFactory.getLogger(DBService.class);
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public Optional<UserInfo> getUserById(String id){
		
		Optional<UserInfo> userId = userInfoRepository.findById(id);
		
		if(userId.isPresent()) {
			logger.info("UserInfo found: "+userId.get().getId());
		} else {
			logger.info("UserInfo not found: "+id);
		}
		
		return userId;
	}
	
	

}
