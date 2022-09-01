package br.unb.joilton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unb.joilton.calculos.CalculosMatematicos;
import br.unb.joilton.exception.UnsuportedMathOperationException;
import br.unb.joilton.util.Util;

@RestController
public class CalculadoraController {
	
	@Autowired
	CalculosMatematicos calculos;
	
	@RequestMapping(value = "/soma/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) throws Exception {
		
		if(!Util.isNumeric(numero1) || !Util.isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Defina um valor numérico"); 
		}
		
		return calculos.soma(Util.converterParaDouble(numero1), Util.converterParaDouble(numero2));
	
	}
	
	@RequestMapping(value = "/subtracao/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) throws Exception {
		
		if(!Util.isNumeric(numero1) || !Util.isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Defina um valor numérico"); 
		}
		
		return calculos.subtracao(Util.converterParaDouble(numero1), Util.converterParaDouble(numero2));
	
	}
	
	@RequestMapping(value = "/multiplicacao/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) throws Exception {
		
		if(!Util.isNumeric(numero1) || !Util.isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Defina um valor numérico"); 
		}
		
		return calculos.multiplicacao(Util.converterParaDouble(numero1), Util.converterParaDouble(numero2));
	
	}
	
	@RequestMapping(value = "/divisao/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) throws Exception {
		
		if(!Util.isNumeric(numero1) || !Util.isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Defina um valor numérico"); 
		}
		
		return calculos.divisao(Util.converterParaDouble(numero1), Util.converterParaDouble(numero2));
	
	}
	
	@RequestMapping(value = "/media/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double media(@PathVariable("numero1") String numero1, @PathVariable("numero2") String numero2) throws Exception {
		
		if(!Util.isNumeric(numero1) || !Util.isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Defina um valor numérico"); 
		}
		
		return calculos.media(Util.converterParaDouble(numero1), Util.converterParaDouble(numero2));
	
	}
	
	@RequestMapping(value = "/raiz/{numero}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("numero") String numero) throws Exception {
		
		if(!Util.isNumeric(numero)) {
			throw new UnsuportedMathOperationException("Defina um valor numérico"); 
		}
		
		return calculos.raiz(Util.converterParaDouble(numero));
	
	}

}