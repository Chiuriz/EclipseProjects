package it.corso.java;

public class CorsoJava {
	
	public String s1 = "ROCCO BELLI ABITA A SETTIMO DI MONTALTO UFFUGO";
	public String s2 = " E LAVORA A COSENZA IN VIA F. E G. FALCONE";
	public String s3;
	public int i;
	
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
	
	public static void main(String[] args) {
		CorsoJava es = new CorsoJava();
		es.esegui();	
	}	
}