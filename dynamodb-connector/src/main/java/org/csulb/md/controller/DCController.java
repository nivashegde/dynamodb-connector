package org.csulb.md.controller;

import java.util.Optional;

import org.csulb.md.pojo.UserInfo;
import org.csulb.md.service.CacheService;
import org.csulb.md.service.DBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DCController {
	
	Logger logger = LoggerFactory.getLogger(DCController.class);
	
	@Value("${use.cache}")
    private String useCacheFlag;
	
	@Autowired
	private DBService dbService;
	
	@Autowired
	private CacheService cacheService;
	
	@GetMapping("/getdata")
	public UserInfo greeting(@RequestParam(value = "id") String id) {
		
		if(useCacheFlag.equalsIgnoreCase("true")) {
			Optional<UserInfo> userInfo = cacheService.getUserIdFromCache(id);	
			if(userInfo.isPresent()) {
				logger.info("UserInfo found - Cache Hit: "+id);
				return userInfo.get();
			}
		}
		
		Optional<UserInfo> userInfoOptional = dbService.getUserById(id);
		UserInfo userInfo = new UserInfo();
		
		if(userInfoOptional.isPresent()) {
			BeanUtils.copyProperties(userInfoOptional.get(), userInfo);
			if(useCacheFlag.equalsIgnoreCase("true")) {
				cacheService.putUserId(id, userInfoOptional.get());
			}
		}
		
        return userInfo;
	}
}
