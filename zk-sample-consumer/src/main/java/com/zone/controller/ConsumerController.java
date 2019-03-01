package com.zone.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zone.dto.PersonDto;
import com.zone.service.DemoService;
import com.zone.service.PersonService;

@RestController
@RequestMapping(value = "/api/demo")
public class ConsumerController {

	private static final UUID INSTANCE_UUID = UUID.randomUUID();
	private final DemoService remoteService;
	private final PersonService personService;

	public ConsumerController(final DemoService remoteService, final PersonService personService) {
		this.remoteService = remoteService;
		this.personService = personService;
	}

	@GetMapping(value = "/remote-instance")
	public Object remoteInstance() {
		return this.remoteService.instance();
	}

	@GetMapping(value = "/instance")
	public Object instance() {
		return INSTANCE_UUID.toString();
	}

	@GetMapping(value = "/getPerson")
	public PersonDto getPerson() {
		long startTime = System.currentTimeMillis();
		System.out.println("消费者 getperson");
		System.out.println("开始时间" + startTime);
		return personService.getPerson(startTime);
	}
}
