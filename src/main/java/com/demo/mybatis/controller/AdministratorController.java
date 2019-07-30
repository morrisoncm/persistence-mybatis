package com.demo.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mybatis.domain.Administrator;
import com.demo.mybatis.service.AdministratorService;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@GetMapping("/{username}")
	public Administrator getAdministrator(@PathVariable String username) {
		return administratorService.getAdministrator(username);
	}

	@PostMapping
	public void registerAdministrator(@RequestBody Administrator administrator) {
		administratorService.registerAdministrator(administrator);
	}

	@PutMapping(path = "/{username}")
	public void updateAdministrator(@RequestBody Administrator administrator, @PathVariable String username) {
		administrator.setUsername(username);
		administratorService.updateAdministrator(administrator);
	}

	@DeleteMapping(path = "/{username}")
	public void deleteAdministrator(@PathVariable String username) {
		administratorService.deleteAdministrator(username);
	}
}