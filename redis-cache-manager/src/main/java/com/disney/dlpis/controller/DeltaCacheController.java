package com.disney.dlpis.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.dlpis.service.RedisService;

@RestController
@RequestMapping(value = "/redis-cache-manager")
public class DeltaCacheController {
	
	private static final Logger LOG = LogManager.getLogger(DeltaCacheController.class);

    @Autowired
    private RedisService service;
    
    @GetMapping(value = "/get/{key}", produces = {"application/json"})
    public ResponseEntity<?> getValue(@PathVariable("key") String key) {
    	LOG.info("Value received for - "+key);
    	return service.getValue(key);
    }
  
    @PutMapping(value = "/put/{key}", consumes = {"application/json"})
    public ResponseEntity<?> setValue(@PathVariable("key") String key, @RequestBody String payload) {
    	LOG.info("Key & value received for - "+key);
    	return service.setValue(key, payload);
    }
}
