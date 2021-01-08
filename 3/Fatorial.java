package br.com.gerenciamento.model;
import java.util.Scanner;

public class Fatorial {

    public static void main(String[] args){
    
        Scanner scanner = new Scanner(System.in);
        int numero, f = 1;
        int count = 1;

        do{
            System.out.println("Digite um nº");
            numero = scanner.nextInt();
            
            for(int i = 1;i <= numero; i++){
                f = f * i;
            }
            
            System.out.println("!" + numero + " = " + f);
            count++;
            
       }while(count < 2);
    }
}