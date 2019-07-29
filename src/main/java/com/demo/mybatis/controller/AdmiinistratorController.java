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

import com.demo.mybatis.domain.Admiinistrator;
import com.demo.mybatis.service.AdmiinistratorService;

@RestController
@RequestMapping("/users")
public class AdmiinistratorController {

	@Autowired
	private AdmiinistratorService admiinistratorService;

	@GetMapping("/{username}")
	public Admiinistrator getAdmiinistrator(@PathVariable String username) {
		return admiinistratorService.getAdmiinistrator(username);
	}

	@PostMapping
	public void registerAdmiinistrator(@RequestBody Admiinistrator admiinistrator) {
		admiinistratorService.registerAdmiinistrator(admiinistrator);
	}

	@PutMapping(path = "/{username}")
	public void updateAdmiinistrator(@RequestBody Admiinistrator admiinistrator, @PathVariable String username) {
		admiinistrator.setUsername(username);
		admiinistratorService.updateAdmiinistrator(admiinistrator);
	}

	@DeleteMapping(path = "/{username}")
	public void deleteAdmiinistrator(@PathVariable String username) {
		admiinistratorService.deleteAdmiinistrator(username);
	}
}