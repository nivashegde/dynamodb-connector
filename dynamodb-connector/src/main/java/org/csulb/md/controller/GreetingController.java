package org.csulb.md.controller;

import org.csulb.md.pojo.UserInfo;
import org.csulb.md.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Autowired
	private DBService dbService;

	@GetMapping("/getdata")
	public UserInfo greeting(@RequestParam(value = "id") String id) {
		
		UserInfo userInfo = dbService.getUserById(id);
        return userInfo;
	}
}
