import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String args[]) throws Exception {
    	
    	//Test_case
    	for(int test_case = 1; test_case <= 10; test_case++) {
    		
    		int N, M;
    		
    		N = Integer.parseInt(br.readLine());
    		
    		List<Integer> list = new LinkedList<>();
    		
    		// 원본 암호문 입력
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int n = 0; n < N; n++) {
    			list.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		// 명령어의 개수
    		M = Integer.parseInt(br.readLine());
    		
    		// 명령어
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
    		for(int m = 0; m < M; m++) {
    			String inst = st2.nextToken();
    			int idx, num;
    			switch(inst){
    				case "I":
    	    			idx = Integer.parseInt(st2.nextToken());
    	    			num = Integer.parseInt(st2.nextToken());
    	    			for(int i = 0; i < num; i++) {
    	    				list.add(idx + i, Integer.parseInt(st2.nextToken()));
    	    			}
    	    			break;
    				case "D":
    	    			idx = Integer.parseInt(st2.nextToken());
    	    			num = Integer.parseInt(st2.nextToken());
    	    			for(int i = 0; i < num; i++) {
    	    				list.remove(idx);
    	    			}
    	    			break;
    				case "A":
    	    			num = Integer.parseInt(st2.nextToken());
    	    			for(int i = 0; i < num; i++) {
    	    				list.add(Integer.parseInt(st2.nextToken()));
    	    			}
    					
    			}
    		}
    		// 출력
    		System.out.print("#" + test_case);
    		for(int i = 0; i < 10; i++) {
    			System.out.print(" " + list.get(i));
    		}
    		System.out.println();
    	}
    }
}