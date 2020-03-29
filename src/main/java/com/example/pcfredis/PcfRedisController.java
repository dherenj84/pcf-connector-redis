package com.example.pcfredis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PcfRedisController {

	@Autowired
	PcfRedisService pcfRedisService;

	@GetMapping("/get/{key}")
	public String getValue(@PathVariable String key) {
		return pcfRedisService.getValue(key);
	}

	@PostMapping("/set")
	public boolean setValues(@RequestBody Map<String, String> keyValue) {
		return pcfRedisService.setValue(keyValue);
	}
}
