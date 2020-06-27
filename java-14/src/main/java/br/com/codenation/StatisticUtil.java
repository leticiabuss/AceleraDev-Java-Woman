package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		
		/*Declarando as váriaveis que será usados no durante o proceso de calculo*/
		int soma= 0;
		int media = 0;
		
		/*Percorreu o vetor e fez a soma de todos os valores de dentro do vetor*/
		for(int i=0; i< elements.length; i++)
			soma += elements[i];
		
		/*Calculando a média dos valores iincluidos no vetor*/
		media = soma / elements.length;
		
		/*Retornando a média*/
		return media;
	}

	public static int mode(int[] elements) {
		
		/*Esse comando organiza em ordem os elementos da lista*/
		Arrays.sort(elements);
		
		/*Declarando as váriaveis que será usados no durante o proceso de calculo*/
		int contAnterior = 0;
		int contAtual= 0;
		int valorMaiorNumRepeticoes = 0;
		
		/*Percorrendo toda a lista, e comparando com todos os outros elementos e caso os elementos sejam iguais 
		*ele soma na variaval de contAtual*/
		for(int i =0; i<elements.length; i++) {
			for(int j=1; j<elements.length; j++) {
				if(elements[i] == elements[j]) {
					contAtual += 1;}
			}
			
			/* Após percorrer, se a soma de repetições for maior que a soma de repetições ele salva o numero 
			*que repetiu e numero de repetições */
			if(contAtual > contAnterior) {
				contAnterior = contAtual;
				contAtual = 0;
				valorMaiorNumRepeticoes = elements[i];
			/*Caso não seja maior, ele zera o contador para somar o do próximo numero.*/
			}else 
				contAtual = 0;
		}
		/*retorna o valor com maior numero de repetições que no caso seria a moda*/
		return valorMaiorNumRepeticoes;
	}

	public static int median(int[] elements) {
		
		/*Esse comando organiza em ordem os elementos da lista*/
		Arrays.sort(elements);
		
		/*Declarando as váriaveis que será usados no durante o proceso de calculo*/
		int mediana = 0;
		
		/*Valida se o resto da divisão é igual a zero(lista com quantidade de valores par) 
		*ele soma o valor das duas posições do meio e faz a média delas*/
		if (elements.length % 2 == 0) {
			int valorMedio =  elements.length / 2;
			mediana =(elements[valorMedio -1] + elements[valorMedio]) / 2;
		/*caso a quantidades de valores da list seja impar, ele pega o valor central*/
		}else {
			int valorMedio = elements.length / 2;
			mediana = (elements[valorMedio]);
		}
		
		/*faz o retorno da mediana*/
		return mediana;
	}
}