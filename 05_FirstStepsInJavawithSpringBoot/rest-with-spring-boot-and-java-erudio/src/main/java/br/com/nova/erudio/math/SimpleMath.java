package br.com.nova.erudio.math;

public class SimpleMath extends converters{

	
 
	public Double sum(String Strnumber1, String Strnumber2) {
		return convertToDouble(Strnumber1) + convertToDouble(Strnumber2);
	}

	public Double div(String Strnumber1, String Strnumber2) {

		return convertToDouble(Strnumber1) / convertToDouble(Strnumber2);

	}
	
	public Double multi(String Strnumber1, String Strnumber2) {
		 
		return convertToDouble(Strnumber1) * convertToDouble(Strnumber2);
	}
	
	public Double sub(String Strnumber1, String Strnumber2) {
		return convertToDouble(Strnumber1) - convertToDouble(Strnumber2);
	}
	
	public Double med(String Strnumber1, String Strnumber2) {
		 
		return (convertToDouble(Strnumber1) + convertToDouble(Strnumber2)) / 2;
	}
}
