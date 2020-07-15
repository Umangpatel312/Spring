package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.service.DigitToWordConvert;

@RestController
public class DigitToWordController {
	@GetMapping(value="/digitToWorld/{digit}")
	public String digitToWord(@PathVariable String digit) {
		int num=Integer.parseInt(digit);
		String word=DigitToWordConvert.digitToWordCount(num);
		return word;
	}
}
