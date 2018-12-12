import java.util.Random;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//oggetti di sistema
		Scanner in = new Scanner (System.in);
		Random rand = new Random ();
		
		
		//variabili di gioco
		String nemici [] = {"Skeleton", "Zombie", "Warrior", "Assassin"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		//statistiche giocatore
		int health = 100;
		int attackDamage = 50;
		int numHealtPotion = 3;
		int healthPotionHealAmount = 30;
		int healtPotionDropChance = 50; //in percentuale
		
		boolean running = true;
		
		System.out.println("-------------------------------------");
		System.out.println("Benvenuti nel dungeon!");
		
		
		GAME:
		while (running) {
			System.out.println("-------------------------------------");
			
			int enemyHealt = rand.nextInt(maxEnemyHealth);
			String enemy = nemici[rand.nextInt(nemici.length)];
			
			System.out.println("\t\n### NEMICO: " + enemy + " ###\n");
			
			while (enemyHealt > 0) {		
				System.out.println("");
				System.out.println("\tTuoi HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealt);
				System.out.println("\n\tCosa vuoi fare ?");
				System.out.println("\t1. Attacca!");
				System.out.println("\t2. Bevi pozione");
				System.out.println("\t3. Scappa!");
				
				System.out.print("\n\tInserisci la tua scelta: ");
			
				String input = in.nextLine();
				
				if (input.equals("1")) {
					 int damageDealt = rand.nextInt(attackDamage);
					 int damageTaken = rand.nextInt(enemyAttackDamage);
					 enemyHealt -= damageDealt;
					 health -= damageTaken;
					 
					 System.out.println("\t> Hai colpito " + enemy + " per " + damageDealt + " danni!");
					 System.out.println("\t> " + enemy + " ti ha colpito per " + damageTaken + " danni!");
					 
					 if (health <1) {
						 System.out.println("\t > Hai preso troppi danni! Sei troppo debole per il nemico " + enemy );
						 break;
					 }
				}
				
				else if (input.equals("2")) {
					
					if (numHealtPotion > 0) {
						
						health += healthPotionHealAmount;
						numHealtPotion--;
						System.out.println("\t> Hai bevuto una pozione! Sei stato curato per " + healthPotionHealAmount + " danni!" +
										   "\n\t> Ora hai " + health + " HP." + 
										   "\n\t> Pozioni rimanenti: " + numHealtPotion);
					}
					
					else {
						System.out.println("\n\t> Non hai pozioni disponibili! Sconfiggi il nemico per avere una probabilità di trovarne una.");
					}
					
				}
				
				else if (input.equals("3")) {
						System.out.println("\t\nSei scappato da " + enemy + "!");
						continue GAME;
				}
				
				else {
					System.out.println("\t\n Scelta non valida!");
				}
				
			}
			
				if (health < 1) {
					System.out.println("esci dal dungeon ferito...");
					break;
				}
				
				System.out.println("-------------------------------------");
				System.out.println(" ## Hai sconfitto " + enemy + "!  ##");
				System.out.println(" # Hai " + health + " HP rimanenti #");
				
				if (rand.nextInt(100) < healtPotionDropChance) {
					numHealtPotion++;
					System.out.println(" # Nel corpo del  " + enemy + " hai trovato una pozione! #");
					System.out.println(" # Ora hai " + numHealtPotion + " pozioni disponibili! #");
				}
				System.out.println("-------------------------------------");
				System.out.println(" Cosa vuoi fare adesso ? ");
				System.out.println("1. continua a combattere!");
				System.out.println("2. esci dal dungeon.");
				
				String input = in.nextLine();
				
				while (!input.equals("1") && !input.equals("2")) {
					
					System.out.println(" Comando non valido!");
					input = in.nextLine();
					
				}
				
				if (input.equals("1")) {
					System.out.println(" Hai scelto di continuare nel dungeon!!");
					
				}
				
				else if (input.equals("2")) {
					System.out.println("SEI USCITO DAL DUNGEON!");
					break;
				}
				
		}		
		
				System.out.println(" ######################################");
				System.out.println(" ###### GRAZIE PER AVER GIOCATO!! #####");
				System.out.println(" ######################################");
	}	
}
