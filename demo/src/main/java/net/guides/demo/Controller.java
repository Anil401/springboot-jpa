package net.guides.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/testing")
	public String getName() {
		return "ganagapatnamanil";
	}

}
