package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		salarioBase = calcularInss(salarioBase);
		salarioBase = calcularIRF(salarioBase);

		return Math.round(salarioBase);
	}

	private static double calcularInss(double salarioBase) {
		if (salarioBase < 1039) {
			return 0;
		}
		
		double salarioINSS = 0;
		if (salarioBase >= 1039 && salarioBase <= 1500) {
			salarioINSS = salarioBase - (salarioBase * 0.08);
		} 
		else if (salarioBase > 1500 && salarioBase <= 4000) {
			salarioINSS = salarioBase - (salarioBase * 0.09);
		} 
		else {
			salarioINSS = salarioBase - (salarioBase * 0.11);
		}
		return salarioINSS;
	}

	private static double calcularIRF(double salarioINSS) {

		if (salarioINSS < 3000.00)
			return salarioINSS;

		double salarioIRRF = 0;
		if (salarioINSS > 3000.00 && salarioINSS <= 6000.00) {
			salarioIRRF = salarioINSS - (salarioINSS * 0.075);
		} 
		else {
			salarioIRRF = salarioINSS - (salarioINSS * 0.15);
		}

		return salarioIRRF;
	}

}
