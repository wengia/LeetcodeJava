package solution;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int result = 0;
		int i = 0, j = height.length - 1;
		
		if (height.length <= 1)
			return 0;
        
		while (i < j) {
			int current;
			
			if (height[i] > height[j]) {
				current = (j - i) * height[j];
				j--;
			} else {
				current = (j - i) * height[i];
				i++;
			}
			
			if (current > result)
				result = current;
		}
		
		return result;
    }

}
