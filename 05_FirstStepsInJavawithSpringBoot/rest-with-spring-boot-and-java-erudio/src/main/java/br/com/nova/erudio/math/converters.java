package br.com.nova.erudio.math;

public class converters {
	
	public static Double convertToDouble(String Strnumber) {
		if (Strnumber == null)
			return 0D;
		String number = Strnumber.replace(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return null;
	}

	public static boolean isNumeric(String Strnumber) {
		if (Strnumber == null)
			return false;
		String numberString = Strnumber.replace(",", ".");
		return numberString.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
