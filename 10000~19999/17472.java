import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
class Path {
    Point start; // 출발 좌표
    Point end; // 도착 좌표
    int startNum; // 시작하는 섬
    int endNum; // 도착하는 섬
 
    Path(Point start, Point end, int startNum, int endNum) {
        this.start = start;
        this.end = end;
        this.startNum = startNum;
        this.endNum = endNum;
    }
 
    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Path) {
            if (start.x == ((Path) object).start.x && start.y == ((Path) object).start.y) {
                if (end.x == ((Path) object).end.x && end.y == ((Path) object).end.y) {
                    return true;
                }
            }
        }
        return false;
    }
}
 
public class Main {
    static int N, M;
    static int[][] map;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };
    static int islandNum = 0; // 섬의 개수
    static ArrayList<Path> pathList = new ArrayList<>(); // 전체 다리
    static ArrayList<Integer> select = new ArrayList<>(); // 일부 선택된 다리
    static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
 
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        // 섬에 번호를 붙이는 과정.
        boolean[][] visited = new boolean[N][M];
        int cnt = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    numbering(i, j, visited, cnt);
                    cnt++;
                    islandNum++;
                }
            }
        }
 
        // 가능한 모든 경로 찾기.
        findPath();
 
        // 조합 구하기.
        for (int i = 1; i <= pathList.size(); i++) {
            comb(0, pathList.size(), i);
        }
 
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
    // 섬에 번호를 붙임. (DFS)
    public static void numbering(int x, int y, boolean[][] visited, int num) {
        map[x][y] = num;
        visited[x][y] = true;
 
        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + rangeX[i];
            dy = y + rangeY[i];
 
            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }
 
            if (map[dx][dy] == 1 && !visited[dx][dy]) {
                visited[dx][dy] = true;
                numbering(dx, dy, visited, num);
            }
        }
    }
 
    // 조합
    public static void comb(int start, int pathNum, int r) {
        if (r == 0) {
            shortestPath();
            return;
        }
 
        for (int i = start; i < pathNum; i++) {
            select.add(i);
            comb(i + 1, pathNum, r - 1);
            select.remove(select.size() - 1);
        }
    }
 
    // 모든 경로를 찾는 함수.
    public static void findPath() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    connect(i, j, map[i][j]);
                }
            }
        }
    }
 
    // 한 점에서 갈 수 있는 다리를 구하는 함수.
    public static void connect(int x, int y, int num) {
        Point start = new Point(x, y); // 시작점
 
        // 북쪽
        if (x - 1 >= 0 && map[x - 1][y] == 0) {
            int cnt = 0;
            int dx = x - 1, dy = y;
 
            // 갈 수 있는만큼 쭉 가봄.
            while (map[dx][dy] == 0) {
                cnt++;
                dx--;
 
                if (dx < 0) {
                    cnt = 0;
                    break;
                }
            }
 
            // 다리의 길이가 2 이상이면 경로에 추가.
            if (cnt >= 2) {
                Path path = new Path(start, new Point(dx, dy), num, map[dx][dy]);
                Path conversion = new Path(new Point(dx, dy), start, map[dx][dy], num);
 
                // 1 - 6과 6 - 1은 서로 같은 경로이므로 중복 케이스는 제외.
                if (!pathList.contains(conversion)) {
                    pathList.add(path);
                }
            }
 
        }
 
        // 아래는 위 북쪽 과정과 동일한 과정을 거침.
 
        // 동쪽
        if (y + 1 < M && map[x][y + 1] == 0) {
            int cnt = 0;
            int dx = x, dy = y + 1;
            while (map[dx][dy] == 0) {
                cnt++;
                dy++;
 
                if (dy >= M) {
                    cnt = 0;
                    break;
                }
            }
 
            if (cnt >= 2) {
                Path path = new Path(start, new Point(dx, dy), num, map[dx][dy]);
                Path conversion = new Path(new Point(dx, dy), start, map[dx][dy], num);
 
                if (!pathList.contains(conversion)) {
                    pathList.add(path);
                }
            }
        }
 
        // 남쪽
        if (x + 1 < N && map[x + 1][y] == 0) {
            int cnt = 0;
            int dx = x + 1, dy = y;
            while (map[dx][dy] == 0) {
                cnt++;
                dx++;
 
                if (dx >= N) {
                    cnt = 0;
                    break;
                }
            }
 
            if (cnt >= 2) {
                Path path = new Path(start, new Point(dx, dy), num, map[dx][dy]);
                Path conversion = new Path(new Point(dx, dy), start, map[dx][dy], num);
 
                if (!pathList.contains(conversion)) {
                    pathList.add(path);
                }
            }
        }
 
        // 서쪽
        if (y - 1 >= 0 && map[x][y - 1] == 0) {
            int cnt = 0;
            int dx = x, dy = y - 1;
            while (map[dx][dy] == 0) {
                cnt++;
                dy--;
 
                if (dy < 0) {
                    cnt = 0;
                    break;
                }
            }
 
            if (cnt >= 2) {
                Path path = new Path(start, new Point(dx, dy), num, map[dx][dy]);
                Path conversion = new Path(new Point(dx, dy), start, map[dx][dy], num);
 
                if (!pathList.contains(conversion)) {
                    pathList.add(path);
                }
            }
        }
    }
 
    // 인접리스트의 연결 요소의 개수를 구하는 함수.
    public static void DFS(ArrayList<ArrayList<Integer>> a, int start, boolean[] visited) {
        visited[start] = true;
 
        for (int i : a.get(start)) {
            if (!visited[i]) {
                DFS(a, i, visited);
            }
        }
    }
 
    public static void shortestPath() {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= islandNum + 1; i++) {
            a.add(new ArrayList<>());
        }
 
        // 양방향 인접리스트 구현.
        for (int i = 0; i < select.size(); i++) {
            int start = pathList.get(select.get(i)).startNum;
            int end = pathList.get(select.get(i)).endNum;
 
            a.get(start).add(end);
            a.get(end).add(start);
        }
 
        boolean[] visited = new boolean[islandNum + 2];
        DFS(a, 2, visited);
 
        // 섬이 모두 연결되어있다면, 1번의 DFS 수행만으로도 모든 점이 방문되었을 것임.
        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {
                return;
            }
        }
 
        int total = 0;
        // 모든 다리의 길이를 구함.
        for (int i = 0; i < select.size(); i++) {
            int startX = pathList.get(select.get(i)).start.x;
            int startY = pathList.get(select.get(i)).start.y;
            int endX = pathList.get(select.get(i)).end.x;
            int endY = pathList.get(select.get(i)).end.y;
 
            if (startX == endX) {
                total += (endY - startY - 1);
            } else if (startY == endY) {
                total += (endX - startX - 1);
            }
        }
 
        ans = Math.min(ans, total);
    }
 
}
