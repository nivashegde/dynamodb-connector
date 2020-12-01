package org.csulb.md.service;

import java.util.Optional;

import org.csulb.md.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CacheService {
	
	public CacheService() {
		restTemplate = new RestTemplate();
	}
	
	private RestTemplate restTemplate = null;
	
	@Value("${cache.port}")
    private String cachePort;
	
	@Value("${cache.service}")
    private String cacheService;
	
	@Value("${cache.host}")
    private String cachehost;

	public Optional<UserInfo> getUserIdFromCache(String id) {
		String cacheServer = "http://" + cachehost + ":"+ cachePort +"/" + cacheService.toLowerCase() +"-cache-manager/get/" + id;
		UserInfo userInfo = restTemplate.getForObject(cacheServer, UserInfo.class);	
		return Optional.ofNullable(userInfo);
	}
	
	public void putUserId(String id, UserInfo userInfo) {
		String cacheServer = "http://" + cachehost + ":"+ cachePort +"/" + cacheService.toLowerCase() +"-cache-manager/put/" + id;
		restTemplate.put(cacheServer, userInfo);
	}

}
