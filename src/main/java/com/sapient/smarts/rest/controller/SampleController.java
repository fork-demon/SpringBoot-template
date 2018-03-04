package com.sapient.smarts.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * Default controller for transform micro service.
 * 
 * @author vbha12
 *
 */
@RestController
public class SampleController {

	
	@RequestMapping(path = "/sample", method = RequestMethod.GET)
	public String sample() throws Exception {
		
		return "Sample Controller Returns";
	}

}
