import java.util.Scanner;
//github test comment
public class LiftProblems {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	for(int i=1; i<=n; i++) {
    		int nFloors = sc.nextInt();
    		int[] s = new int[nFloors+1];
    		s[0] = 0;
    		for (int j=1; j<=nFloors; j++) {
    			s[j] = sc.nextInt();
    		}
    		
    		int[] sums = new int[nFloors+1];
    		sums[nFloors] = 0;
    		sums[nFloors-1] = s[nFloors];
    		for (int j=nFloors-1; j>0; j--) {
    			sums[j-1] = sums[j] + s[j];
    		}
    		
    		int[] res = new int[nFloors+1];
    		res[0] = 0;
    		
    		for (int j=1; j<=nFloors; j++) {
    			int min = Integer.MAX_VALUE;
    			for (int k=j-1; k>=0; k--) {
    				int dummy = 1;
    				int ann = res[k] + sums[j];
    				for (int l=j-1; l>k; l--) {
    					ann += s[l]*dummy;
    					dummy++;    					
    				}
    				min = Math.min(min, ann);
    			}
    			res[j] = min;
    		}
    		
    		int endres = Integer.MAX_VALUE;
    		res[0] = Integer.MAX_VALUE;
    		for (int j=0; j<res.length; j++) {
    			endres = Math.min(endres, res[j]);
    		}
    		System.out.printf("%d%n",endres);
    	}
    }
}
