package com.zone.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "sample-provider", path = "/api/demo")
//@RequestMapping(value = "/api/demo")
public interface DemoService {

	@GetMapping(value = "/instance")
	String instance();

}