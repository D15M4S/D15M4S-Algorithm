import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
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
        	// 1 : N
        	// 2 : S
        	int dead_lock = 0;
        	
        	for(int col = 0; col < 100; col++) {
        		Stack<Integer> stack = new Stack<>();
        		for(int row = 0; row < 100; row++) {
        			
        			int val = matrix[row][col];
        			
        			if (val == 1) {
                        stack.push(1); // N극 추가
                    } else if (val == 2) {
                        if (!stack.isEmpty()) {
                            dead_lock++; // 교착 상태 발생
                            stack.clear(); // 스택 초기화
                        }
                    }	
        		}
        	}
        	
        	// output
        	System.out.println("#" + test_case + " " + dead_lock);
    	}
    }
}
