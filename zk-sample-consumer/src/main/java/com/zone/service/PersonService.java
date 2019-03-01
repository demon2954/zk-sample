package com.zone.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zone.dto.PersonDto;

@FeignClient(value = "sample-provider", path = "/api/demo")
public interface PersonService {

//	@GetMapping(value = "/getPerson")
//	public PersonDto getPerson(long startTime);

	@RequestMapping(value = "/getPerson", method = RequestMethod.POST)
	public PersonDto getPerson(@RequestParam(required = true, defaultValue = "0", value = "startTime") long startTime);
}