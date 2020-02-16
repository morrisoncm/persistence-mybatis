package com.demo.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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