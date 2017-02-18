package solution;

/* Water and Jug Problem - Medium */
public class WaterandJugProblem {
	// Bézout's identity
	// if m * x + n * y = gcd has solution
	// then m * x + n * y = gcd * anyInteger has solution
    public boolean canMeasureWater(int x, int y, int z) {
    	if (x + y < z) return false;
    	if (z == 0) return true; // case 0
    	
        return z % gcd(x, y) == 0;
    }
    
    // Greatest Common Ancestor
    private int gcd(int a, int b) {
    	while(b != 0) {
    		int tmp = b;
    		b = a % b;
    		a = tmp;
    	}
    	return a;
    }
}
