package com.zone.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zone.dto.PersonDto;

@RestController
@RequestMapping(value = "/api/demo")
public class ProviderController {

	private static final UUID INSTANCE_UUID = UUID.randomUUID();

	@GetMapping(value = "/instance")
	public Object instance() {
		return INSTANCE_UUID.toString();
	}

//	@GetMapping(value = "/getPerson")
	@RequestMapping(value = "/getPerson", method = RequestMethod.POST, produces = "application/json")
	public PersonDto getPerson(@RequestParam(required = true, defaultValue = "0") long startTime) {
		long endTime = System.currentTimeMillis();
		PersonDto person = new PersonDto();
		person.setName("鬼东西");
		person.setAge(111);
		person.setBirthdate(new Date());
		System.out.println("---------------开始时间：" + startTime + " 毫秒");
		System.out.println("---------------结束时间：" + endTime + " 毫秒");
		System.out.println("---------------花费时间：" + (endTime - startTime) + " 毫秒");
		return person;
	}
}
