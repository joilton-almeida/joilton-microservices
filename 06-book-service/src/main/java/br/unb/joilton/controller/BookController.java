package br.unb.joilton.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.unb.joilton.model.Book;
import br.unb.joilton.proxy.CambioProxy;
import br.unb.joilton.repository.BookRepository;
import br.unb.joilton.response.Cambio;

@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CambioProxy proxy;
	
	@GetMapping("/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		
		var book = repository.getReferenceById(id);
		
		if(book == null) {
			
			throw new RuntimeException("Book not Found");
			
		}
		
		var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
		
		var port = environment.getProperty("local.server.port");
		
		book.setEnvironment(port + " Feign");
		book.setPrice(cambio.getConvertedValue());
		
		return book;
	}
	
//	@GetMapping("/{id}/{currency}")
//	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
//		
//		var book = repository.getReferenceById(id);
//		
//		if(book == null) {
//			
//			throw new RuntimeException("Book not Found");
//			
//		}
//		
//		HashMap<String, String> params = new HashMap();
//		
//		params.put("amount", book.getPrice().toString());
//		params.put("from", "USD");
//		params.put("to", currency);
//		
//		var response = new RestTemplate().getForEntity("http://localhost:8001/cambio-service/{amount}/{from}/{to}", Cambio.class, params);
//		
//		var cambio = response.getBody();
//		
//		var port = environment.getProperty("local.server.port");
//		
//		book.setEnvironment(port);
//		book.setPrice(cambio.getConvertedValue());
//		
//		return book;
//	}

}
