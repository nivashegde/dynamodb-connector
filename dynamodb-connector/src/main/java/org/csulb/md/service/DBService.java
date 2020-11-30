package org.csulb.md.service;

import java.util.Optional;

import org.csulb.md.pojo.UserInfo;
import org.csulb.md.repo.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBService {
	
	Logger logger = LoggerFactory.getLogger(DBService.class);
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfo getUserById(String id){
		
		Optional<UserInfo> userId = userInfoRepository.findById(id);
		UserInfo userInfo = new UserInfo();
		
		if(userId.isPresent()) {
			logger.info("UserInfo found: "+userId.get().getId());
			BeanUtils.copyProperties(userId.get(), userInfo);
		} else {
			logger.info("UserInfo not found: "+id);
		}
		
		return userInfo;
	}

}
