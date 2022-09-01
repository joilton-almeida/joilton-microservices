package br.unb.joilton.calculos;

import org.springframework.stereotype.Service;

//@Service
public class CalculosMatematicos {
	
	public Double soma(Double pNumero1, Double pNumero2) {
		
		return pNumero1 + pNumero2;
		
	}
	
	public Double subtracao(Double pNumero1, Double pNumero2) {
		
		return pNumero1 - pNumero2;
		
	}
	
	public Double multiplicacao(Double pNumero1, Double pNumero2) {
		
		return pNumero1 * pNumero2;
		
	}
	
	public Double divisao(Double pNumero1, Double pNumero2) {
		
		return pNumero1 / pNumero2;
		
	}
	
	public Double media(Double pNumero1, Double pNumero2) {
		
		return (pNumero1 + pNumero2) / 2;
		
	}
	
	public Double raiz(Double pNumero) {
		
		return Math.sqrt(pNumero);
		
	}

}
