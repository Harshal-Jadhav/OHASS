package com.masai.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ohsms/authenticate")
public class AuthController {

	@GetMapping("/harshal")
	public String getall() {
		return "Harshal Sanjay Jadhav";
	}
}
