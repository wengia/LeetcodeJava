package solution;


/**
 * Turn the question to combinatorics.
 * 
 * The total steps for the robot going from start to end is (m - 1 + n - 1).
 * Within the route there is (m - 1) Down and (n - 1) Right.
 * Take the short one as perspective (for example to go Down). We need to randomly choose (m - 1)th
 * steps to go down. Thus the questions turns to be counting C(m - 1 + n - 1, m - 1);
 * 
 * @author wenjia ma
 *
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
    	if (m == 1 || n == 1) return 1;
        long numerator = 1, denominator = 1; 
        int path = m - 1 + n - 1;
        int choice = (m < n) ? (m - 1) : (n - 1);
        
        while (choice > 0) {
            numerator *= path--;
            denominator *= choice--;
        }
        
        return (int) (numerator/denominator);
    }
}
