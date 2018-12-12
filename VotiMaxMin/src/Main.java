import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner lettore = new Scanner (System.in);
		int voti[], i, minimo, massimo;	
		voti = new int[10];
		float media;
		

			for (i=0; i<10; i++) {	
				do {
				 System.out.print("Inserisci il " + (i+1) +" voto: ");
				voti[i] = lettore.nextInt();
				}
				while (voti[i] <0 || voti[i] >10);	
			}
				
		
		//calcolo del voto medio
		media=0;
		for (i=0; i<10; i++)
			
		{
			media = media/10;
		}
		
		media = media + media;
		System.out.println("Il voto medio è: " + media);
		
		//calcolo del voto minimo e massimo
		minimo = voti[0];
		massimo = voti[0];
		for (i=0; i<10; i++) 
		
		{
			if(minimo > voti[i]) 
			{
				minimo = voti[i];	
			}
			if(massimo < voti[i]) 
			{
				massimo= voti[i];
			}
			
		}
		System.out.println("Il voto massimo è: " +massimo);
		System.out.println("Il voto minimo è: " +minimo);
		
	}
}
			