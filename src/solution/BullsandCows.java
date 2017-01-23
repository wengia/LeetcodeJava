package solution;

/* Bulls and Cows - Easy */
public class BullsandCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] sMap = new int[10];
        int[] gMap = new int[10];
        
        for(int i = 0; i < secret.length(); i++) {
        	if (secret.charAt(i) == guess.charAt(i)) {
        		bulls++;
        		continue;
        	}
        	
        	sMap[secret.charAt(i) - '0']++;
        	gMap[guess.charAt(i) - '0']++;
        }
        
        for(int i = 0; i < 10; i++) {
        	cows += Math.min(sMap[i], gMap[i]);
        }
        
        return bulls + "A" + cows + "B";
    }
}
