package org.csulb.md.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.csulb.md.service.MemcachedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/memcached-cache-manager")
public class MemcachedController {
	
	private static final Logger LOG = LogManager.getLogger(MemcachedController.class);

    @Autowired
    private MemcachedService service;
    
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
