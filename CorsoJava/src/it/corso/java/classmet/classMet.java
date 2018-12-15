package it.corso.java.classmet;
import java.util.Random;
import java.util.Scanner;

public class classMet {
	
	private String s1 = "ROCCO BELLI ABITA A SETTIMO DI MONTALTO UFFUGO";
	private String s2 = " E LAVORA A COSENZA IN VIA F. E G. FALCONE";
	private String s3;
	private int i;
	

	public void esegui () {	
		
		s3 = s1.concat(s2);
		s3 = s3.replaceAll("A", "");
		s3 = s3.replaceAll("E", "");
		s3 = s3.replaceAll("I", "");
		s3 = s3.replaceAll("O", "");
		s3 = s3.replaceAll("U", "");
		
		for (i=0; i < s3.length(); i++) {
			System.out.print(s3.charAt(i));
		}
	}	
	
	
	public void numParDir () {
		
		int in;
		int fin;
		int con;
		
		Scanner ins = new Scanner (System.in);
		System.out.print("inserisci numero iniziale ");
		in = ins.nextInt();
		
		do {
			System.out.print("inserisci numero finale ");
			 	fin = ins.nextInt();
			 		System.out.println("NUMERO FINALE DEVE ESSERE MAGGIORE DI NUMERO INIZIALE!");
		}
		while (fin<in);
		
			for (con = in; con <= fin; con++) {
				if (con %2== 0) {
					System.out.println("Il numero " + con + " è PARI.");
				}
				else System.out.println("Il numero " + con + " è DISPARI.");
		ins.close();
		
		}
	}
	
	public void randParDis () {
		
		int numGen;
		Random r = new Random();
		numGen = r.nextInt(100);
	
		if (numGen %2== 0)
		System.out.println("Numero generato a caso (tra 0 e 100): " + "**" + numGen + "**" + " ed è PARI.");
		else
		System.out.println("Numero generato a caso (tra 0 e 100): " + "**" + numGen + "**" + " ed è DISPARI.");
			
	}
	
	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getS3() {
		return s3;
	}


	public void setS3(String s3) {
		this.s3 = s3;
	}

	
	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}



}
