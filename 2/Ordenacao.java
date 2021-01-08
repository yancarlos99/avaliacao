
public class Ordenacao {
	
	public static void main(String args[]){
		int[] vetor = {8, 9, 3, 5, 1};
		int aux = 0;
		int i = 0;

		System.out.println("Nesse console seria o vetor que esta desordenado: ");
		for(i = 0; i<5; i++){
			System.out.println(" "+vetor[i]);
		}
		System.out.println(" ");

		for(i = 0; i<5; i++){
			for(int j = 0; j<4; j++){
				if(vetor[j] > vetor[j + 1]){
					aux = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = aux;
				}
			}
		}
		System.out.println("Nesse console seria o vetor que esta ordenado:");
		for(i = 0; i<5; i++){
			System.out.println(" "+vetor[i]);
		}
	}
}
