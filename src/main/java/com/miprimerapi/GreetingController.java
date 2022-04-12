package com.miprimerapi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private final static String template = "Hello , %s! ";
	private final AtomicLong counter = new AtomicLong();
	
	//O GetMapping son los que le permiten al controlador saber que esto va a venir en una peticion rest de llamado get valor por default en request
	//En esta funcion greeting lo que haces en request param es traer el valor indicado en la peticion como nombre
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam (value="name", defaultValue="World") String name){
		//El valor de retorno en la peticion se muestra con id indicado para recibir multiples peticiones 
		return new Greeting(counter.incrementAndGet(),
				String.format(template,name));
				
		//Con el String format acoplamos el name al texto de string
	}
}
