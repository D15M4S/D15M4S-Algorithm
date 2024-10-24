#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M;
int lab[8][8];
int tempLab[8][8];

// 바이러스 퍼트리기
void spreadVirus() {
    int dx[4] = {0, 0, 1, -1};
    int dy[4] = {1, -1, 0, 0};

    queue<pair<int, int>> q;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            tempLab[i][j] = lab[i][j];
            if (tempLab[i][j] == 2) {
                q.push({i, j});
            }
        }
    }

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    q.push({nx, ny});
                }
            }
        }
    }
}

// 안전 영역 크기 계산
int getSafeArea() {
    int safeArea = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (tempLab[i][j] == 0) {
                safeArea++;
            }
        }
    }
    return safeArea;
}

// 벽 세우기 및 최대 안전 영역 계산
int buildWalls() {
    int maxSafeArea = 0;
    for (int i = 0; i < N * M; i++) {
        if (lab[i / M][i % M] != 0) continue;
        for (int j = i + 1; j < N * M; j++) {
            if (lab[j / M][j % M] != 0) continue;
            for (int k = j + 1; k < N * M; k++) {
                if (lab[k / M][k % M] != 0) continue;

                lab[i / M][i % M] = 1;
                lab[j / M][j % M] = 1;
                lab[k / M][k % M] = 1;

                spreadVirus();
                maxSafeArea = max(maxSafeArea, getSafeArea());

                lab[i / M][i % M] = 0;
                lab[j / M][j % M] = 0;
                lab[k / M][k % M] = 0;
            }
        }
    }
    return maxSafeArea;
}

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> lab[i][j];
        }
    }

    cout << buildWalls() << endl;

    return 0;
}