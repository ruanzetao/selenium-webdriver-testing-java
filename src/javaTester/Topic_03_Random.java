package javaTester;
import java.util.Random;
public class Topic_03_Random {
	public static void main(String[] args) {
		Random rand=new Random();
		rand.nextInt(99);
	}
	
	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

}
