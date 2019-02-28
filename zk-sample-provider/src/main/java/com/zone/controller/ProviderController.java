package com.zone.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/demo")
public class ProviderController {

	private static final UUID INSTANCE_UUID = UUID.randomUUID();

	@GetMapping(value = "/instance")
	public Object instance() {
		return INSTANCE_UUID.toString();
	}
}
