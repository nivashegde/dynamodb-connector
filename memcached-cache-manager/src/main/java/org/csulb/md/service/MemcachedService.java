package org.csulb.md.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.spy.memcached.MemcachedClient;

@Service
public class MemcachedService {
	
	public static String SERVER_ERROR = "Server Error";

	@Autowired
	private MemcachedClient memcachedClient;

	private static final Logger LOG = LogManager.getLogger(MemcachedService.class);

	public ResponseEntity<?> getValue(final String key) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		try {
			return new ResponseEntity<>(memcachedClient.get(key),responseHeaders, HttpStatus.OK);
		}catch (Exception e) {
			LOG.error("Exception " + e.getMessage(), e);
			return new ResponseEntity<>(SERVER_ERROR, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> setValue(final String key, final Object value) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		try {
			memcachedClient.set(key, 10000, value);
			return new ResponseEntity<>("SUCCESS", responseHeaders, HttpStatus.OK);
		}catch (Exception e) {
			LOG.error("Exception " + e.getMessage(), e);
			return new ResponseEntity<>(SERVER_ERROR, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}