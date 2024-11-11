import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] matrix = new int[100];

    public static void main(String args[]) throws Exception {

        for (int test_case = 1; test_case <= 10; test_case++) {
            // input
            int dump_num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                matrix[i] = Integer.parseInt(st.nextToken());
            }

            // algorithm
            for (int i = 0; i < dump_num; i++) {
                int min_idx = 0;
                int max_idx = 0;

                for (int j = 1; j < 100; j++) {
                    if (matrix[j] < matrix[min_idx]) {
                        min_idx = j;
                    }
                    if (matrix[j] > matrix[max_idx]) {
                        max_idx = j;
                    }
                }

                // 높이 차이가 1 이하일 때 중지
                if (matrix[max_idx] - matrix[min_idx] <= 1) {
                    break;
                }

                matrix[max_idx]--;
                matrix[min_idx]++;
            }

            int min_val = Integer.MAX_VALUE;
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < 100; j++) {
                min_val = Math.min(min_val, matrix[j]);
                max_val = Math.max(max_val, matrix[j]);
            }

            int result = max_val - min_val;

            // output
            System.out.println("#" + test_case + " " + result);
        }
    }
}