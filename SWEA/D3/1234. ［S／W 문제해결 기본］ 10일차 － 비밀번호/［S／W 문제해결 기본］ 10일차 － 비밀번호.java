import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws Exception {
        // 10번의 테스트 케이스 반복
        for (int test_case = 1; test_case <= 10; test_case++) {

            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String src = st.nextToken();
            List<Integer> list = new LinkedList<>();
            
            // src 문자열을 list에 숫자 형태로 넣기
            for (int n = 0; n < num; n++) {
                list.add(Character.getNumericValue(src.charAt(n)));
            }

            // 계산: 연속된 숫자 두 개를 삭제하는 작업
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = 0; i < list.size() - 1; i++) {
                    // 두 개의 연속된 숫자가 같으면 삭제
                    if (list.get(i).equals(list.get(i + 1))) {
                        list.remove(i);
                        list.remove(i);  // i+1을 삭제한 후 i를 유지하므로 다시 i를 검사
                        flag = true;
                        break;  // 더 이상 한 번에 여러 번 삭제되지 않게 break
                    }
                }
            }

            // 예외처리: 맨 앞의 0을 제거
            if (!list.isEmpty() && list.get(0) == 0) {
                list.remove(0);
            }

            // 출력: 결과 출력
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}