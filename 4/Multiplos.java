package br.com.gerenciamento.model;

import java.util.Scanner;

public class Multiplos {
	
	    public static void main(String[] args) {

	        int n, soma = 0;
	        Scanner entrada = new Scanner(System.in);

	        System.out.print("Digite um número (qualquer um, pode ser 1000): ");
	        n = entrada.nextInt();


	        for(int i = n-1; i >= 0; i--) {
	            if(i % 5 == 0 | i % 3 == 0) {
	                soma = soma + i;
	            }
	        }

	        System.out.println("Soma: " + soma);

	        entrada.close();
	    }


}
