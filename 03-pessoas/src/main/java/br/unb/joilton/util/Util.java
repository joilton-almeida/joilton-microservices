package br.unb.joilton.util;

public class Util {
	
	@SuppressWarnings("unused")
	public static Double converterParaDouble(String pStrNumero) {

		if(pStrNumero == null) return 0D;
		
		String numero = pStrNumero.replaceAll(",", ".");
		
		if(isNumeric(numero)) return Double.parseDouble(numero);
		
		return 0D;
		
	}

	public static boolean isNumeric(String pStrNumero) {
		
		if(pStrNumero == null) return false;
		
		String numero = pStrNumero.replaceAll(",", ".");
		
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}

}