package com.xantrix.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class SalutiRestController {
	
	@GetMapping(value = "/test")
	public String getGreetings()
	{
		return "Saluti, sono il tuo primo web services";
	}

	@GetMapping(value = "/saluti/{nome}")
	public String getSaluti(@PathVariable("nome") String nome)
	{
		if(nome.equals("test")) {
			throw new RuntimeException("Utente disabilitato");
		}
		String message = String.format("\"Saluti, %s hai usato il tuo primo web service\"", nome);
		return message;
	}
	
}
