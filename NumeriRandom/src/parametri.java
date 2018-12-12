import java.util.Random;


public class parametri {
	
	private Random n = new Random();
	
	private int min;
	private int max;
	
	
	
	public parametri (int valMin, int valMax) {
		
		min = valMin;
		max = valMax;
		
	}
	
	public int randomNum () {
		
		int num = ((max-min)+1);
		int gener = n.nextInt(num)+min;
		return gener;
		
	}
	
}
