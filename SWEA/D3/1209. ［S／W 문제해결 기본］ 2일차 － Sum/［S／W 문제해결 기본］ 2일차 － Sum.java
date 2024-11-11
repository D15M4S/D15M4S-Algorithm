import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[][] matrix = new int[100][100];
	
    public static void main(String args[]) throws Exception {
    	
    	
    	for(int test_case = 1; test_case <= 10; test_case++) {
        	//input
    		br.readLine();
    		
    		for(int i = 0; i < 100; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for(int j = 0; j < 100; j++) {
    				matrix[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		//algorithm
    		int max = 0;
    		int row_sum = 0;
    		int col_sum = 0;
    		for(int i = 0; i < 100; i++) {	// row
    			for(int j = 0; j < 100; j++) {
    				row_sum += matrix[i][j];
    				col_sum += matrix[j][i];
    			}
    			int sum = Math.max(row_sum, col_sum);
    			if(max < sum) {
    				int swap = max;
    				max = sum;
    				sum = swap;
    			}
    			row_sum = 0;
    			col_sum = 0;
    		}
    		
    		int plus_diagonal_sum = 0;
    		int minus_diagonal_sum = 0;
    		
    		for(int i = 0; i < 100; i++) {
    			
    			plus_diagonal_sum += matrix[i][i];
    			minus_diagonal_sum += matrix[99-i][99-i];
    			
    		}
    		
    		int diagonal_sum = Math.max(plus_diagonal_sum, minus_diagonal_sum);
    		
			if(max < diagonal_sum) {
				int swap = max;
				max = diagonal_sum;
				diagonal_sum = swap;
			}
    		
        	
        	// output
        	System.out.println("#" + test_case + " " + max);
    	}
    }
}