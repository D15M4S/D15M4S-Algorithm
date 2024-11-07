import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    public static void main(String args[]) throws Exception {
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int test_case = 1; test_case <= T; test_case++) {
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		st.nextToken();	//#N
    		int num = Integer.parseInt(st.nextToken());
    		
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
    		ArrayList<Integer> list = new ArrayList<>();
    		
    		// 값 입력
    		for(int i = 0; i < num; i++) {
    			switch(st2.nextToken()) {
    			case "ZRO":
        			list.add(0);
        			break;
    			case "ONE":
        			list.add(1);
        			break;
    			case "TWO":
        			list.add(2);
        			break;
    			case "THR":
        			list.add(3);
        			break;
    			case "FOR":
        			list.add(4);
        			break;
    			case "FIV":
        			list.add(5);
        			break;
    			case "SIX":
        			list.add(6);
        			break;
    			case "SVN":
        			list.add(7);
        			break;
    			case "EGT":
        			list.add(8);
        			break;
    			case "NIN":
        			list.add(9);
        			break;
    			}
    		}
    		
    		// 값 정렬 후 출력
    		Collections.sort(list);
    		
    		System.out.println("#" + test_case);
    		for(int i = 0; i < num; i++) {
    			
    			switch(list.get(i)) {
    			case 0:
    				System.out.print(" ZRO");
    				break;
    			case 1:
    				System.out.print(" ONE");
    				break;
    			case 2:
    				System.out.print(" TWO");
    				break;
    			case 3:
    				System.out.print(" THR");
    				break;
    			case 4:
    				System.out.print(" FOR");
    				break;
    			case 5:
    				System.out.print(" FIV");
    				break;
    			case 6:
    				System.out.print(" SIX");
    				break;
    			case 7:
    				System.out.print(" SVN");
    				break;
    			case 8:
    				System.out.print(" EGT");
    				break;
    			case 9:
    				System.out.print(" NIN");
    				break;
    			}		
    		}
    		System.out.println();	
    	}
    }
}