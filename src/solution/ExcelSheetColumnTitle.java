package solution;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
        	int remainder = (n - 1) % 26;
        	
        	char ch = (char) ('A' + remainder);
        	sb.insert(0, ch);
        	
        	n = (n - 1) / 26;
        }
        
        return sb.toString();
    }

}
