import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		int insMin = 0;
		int insMax = 0;
		Scanner ins = new Scanner (System.in);

			try {
				System.out.print("Inserisci limite minimo: ");
				insMin = ins.nextInt();
				do {
				System.out.print("Inserisci limite massimo: ");
				insMax = ins.nextInt();
					if (insMax < insMin) {
						System.out.println("Devi inserire un numero maggiore del limite minimo!");
					}
				}
				
			    while (insMax < insMin); 
				
				}
			
			catch (Exception e) {
				
				System.out.println("DEVI INSERIRE UN NUMERO! ");
		
			}
		
			ins.close();
			parametri valore = new parametri (insMin,insMax);
			System.out.println("\t\nNUMERO GENERATO A CASO TRA " + insMin + " e "
								+ insMax + ": " + valore.randomNum());

	}

}
