import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static int[][] data = new int[100][100];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            br.readLine();  // 테스트 케이스 번호 읽기

            // 100x100 배열 입력받기
            data = br.lines()
                    .limit(100)
                    .map(line -> Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);

            int minDistance = Integer.MAX_VALUE;  // 최단 경로 거리
            int bestStart = 0;                    // 최단 경로 시작 위치

            // 첫 행의 모든 시작점(1)에서 탐색
            for (int startCol = 0; startCol < 100; startCol++) {
                if (data[0][startCol] == 1) {  // 시작점이 1인 경우만 탐색
                    int distance = getDistance(startCol);
                    if (distance < minDistance) {
                        minDistance = distance;
                        bestStart = startCol;
                    }
                }
            }

            System.out.println("#" + test_case + " " + bestStart);
        }
    }

    // 각 출발점에서 도착점까지의 경로 이동 거리를 계산하는 함수
    public static int getDistance(int col) {
        int row = 0;
        int distance = 0;

        while (row < 99) {
            distance++;
            // 왼쪽으로 가능한 만큼 이동
            if (col > 0 && data[row][col - 1] == 1) {
                while (col > 0 && data[row][col - 1] == 1) {
                    col--;
                    distance++;
                }
            }
            // 오른쪽으로 가능한 만큼 이동
            else if (col < 99 && data[row][col + 1] == 1) {
                while (col < 99 && data[row][col + 1] == 1) {
                    col++;
                    distance++;
                }
            }
            // 아래로 이동
            row++;
        }
        
        return distance;  // 최종 도착까지의 거리 반환
    }
}
  