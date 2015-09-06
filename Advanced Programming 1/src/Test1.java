import java.util.*;

public class Test1 {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	for(int i=1; i<=n; i++) {
    		double h = (double) sc.nextInt();
    		h = h % 180;
    		h = h/10;
    		h = Math.round(h);
    		if(h == 0) {
    			h = 18;
    		}
    		
    		int h2 = (int) h;
    		
    		if(h2>9) {
    			System.out.printf("%d%n",h2);
    		} else {
    			System.out.printf("0%d%n",h2);
    		}
    	}
    }
}