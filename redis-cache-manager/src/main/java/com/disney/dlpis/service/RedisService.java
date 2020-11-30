package com.disney.dlpis.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	
	public static String SERVER_ERROR = "Server Error";

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static final Logger LOG = LogManager.getLogger(RedisService.class);

	public ResponseEntity<?> getValue(final String key) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		try {
			return new ResponseEntity<>(redisTemplate.opsForValue().get(key),responseHeaders, HttpStatus.OK);
		}catch (Exception e) {
			LOG.error("Exception " + e.getMessage(), e);
			return new ResponseEntity<>(SERVER_ERROR, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> setValue(final String key, final Object value) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		try {
			redisTemplate.opsForValue().set(key, value);
			return new ResponseEntity<>("SUCCESS", responseHeaders, HttpStatus.OK);
		}catch (Exception e) {
			LOG.error("Exception " + e.getMessage(), e);
			return new ResponseEntity<>(SERVER_ERROR, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}