import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static int[][] data = new int[100][100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            br.readLine();  // 테스트 케이스 번호 읽기, 사용하지 않음

            // 100x100 배열 입력받기
            data = br.lines()
                    .limit(100)
                    .map(line -> Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);

            // 마지막 행에서 도착점(값이 2인 위치) 찾기
            int row = 99;
            int col = 0;
            for (int i = 0; i < 100; i++) {
                if (data[99][i] == 2) {
                    col = i;
                    break;
                }
            }

            // 사다리를 역방향으로 타고 올라가기
            while (row > 0) {
                // 왼쪽으로 갈 수 있으면 왼쪽으로 계속 이동
                if (col > 0 && data[row][col - 1] == 1) {
                    while (col > 0 && data[row][col - 1] == 1) {
                        col--;
                    }
                }
                // 오른쪽으로 갈 수 있으면 오른쪽으로 계속 이동
                else if (col < 99 && data[row][col + 1] == 1) {
                    while (col < 99 && data[row][col + 1] == 1) {
                        col++;
                    }
                }
                // 위로 한 칸 이동
                row--;
            }

            // 최종적으로 맨 위에서 찾은 col 값이 시작 지점이 됩니다.
            System.out.println("#" + test_case + " " + col);
        }
    }
}