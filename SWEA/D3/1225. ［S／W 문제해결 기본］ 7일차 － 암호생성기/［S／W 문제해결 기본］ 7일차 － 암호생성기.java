import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String args[]) throws Exception {
    	
    	//Test_case
    	for(int test_case = 1; test_case <= 10; test_case++) {
    		
    		Queue<Integer> queue = new LinkedList<>();
    		
    		br.readLine();
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		for(int i = 0; i < 8; i++) {
    			queue.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		
    		boolean flag = true;
    		
    		while(flag) {
    			for(int idx = 1; idx <= 5; idx++) {
    				int value = queue.poll() - idx;
    				if(value <= 0) {
    					queue.add(0);
    					flag = false;
    					break;
    				}
    				queue.add(value);
    			}
    		}
    		
    		
    		System.out.print("#" + test_case);
    		for(int i = 0; i < 8; i++) 
    			System.out.print(" " + queue.poll());
    		System.out.println();
    	}
    }
}