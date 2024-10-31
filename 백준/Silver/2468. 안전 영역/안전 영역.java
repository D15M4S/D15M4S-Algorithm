
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /**
     * [BOJ] 안전 영역 / 실버 1
     * 
     * @see https://www.acmicpc.net/problem/2468
     * @author D15
     */
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];
        int maxMatrixHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                maxMatrixHeight = Math.max(maxMatrixHeight, matrix[i][j]);
            }
        }

        int maxSafeAreas = 1; // 최소 하나의 안전 영역이 존재할 수 있음
        for (int height = 1; height <= maxMatrixHeight; height++) {
            boolean[][] seen = new boolean[N][N];
            int safeAreaCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] > height && !seen[i][j]) {
                        safeAreaCount++;
                        dfs(matrix, seen, i, j, height);
                    }
                }
            }

            maxSafeAreas = Math.max(maxSafeAreas, safeAreaCount);
        }
        System.out.println(maxSafeAreas);
    }

    // DFS 탐색을 위한 함수
    private static void dfs(int[][] matrix, boolean[][] seen, int x, int y, int height) {
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { x, y });
        seen[x][y] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length 
                        && matrix[nx][ny] > height && !seen[nx][ny]) {
                    seen[nx][ny] = true;
                    stack.push(new int[] { nx, ny });
                }
            }
        }
    }
}
