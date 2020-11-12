import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int count = 1;
    static int[] order;
    static ArrayList<Node> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.valueOf(st.nextToken()); // 정점의 개수
        int E = Integer.valueOf(st.nextToken()); // 간선의 개수

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            a.add(new ArrayList<>());
        }

        // 양방향 인접 리스트 구현.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            a.get(A).add(B);
            a.get(B).add(A);
        }

        order = new int[V + 1];
        ans = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            if (order[i] == 0) {
                dfs(i, 0, a);
            }
        }

        // 단절선 목록을 x를 기준으로 오름차순 정렬하되,
        // x 값이 같다면 y 값을 기준으로 오름차순 정렬한다.
        Collections.sort(ans, (a1, a2) -> (a1.x == a2.x) ? a1.y - a2.y : a1.x - a2.x);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size() + "\n"); // 단절선의 개수

        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i).x + " " + ans.get(i).y + "\n"); // 단절선의 목록
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int vertax, int parent, ArrayList<ArrayList<Integer>> a) {
        order[vertax] = count++;
        int ret = order[vertax];

        // 자식 검사
        for (int now : a.get(vertax)) {
            // 내가 온 길은 제외한다.
            if (now == parent) {
                continue;
            }

            if (order[now] == 0) { // 자식 정점이 방문되지 않았을 경우
                // 자식 정점 중 방문 순서가 가장 빠른 값.
                // 이때, 특정 자식 정점이 여러 개의 정점을 타고 타고 올라가서 1번 정점까지
                // 갈 수도 있다는 점에 유의해야 함.
                int low = dfs(now, vertax, a);

                // 가장 작은 방문 순서가 vertax의 방문 순서보다 크거나 같을 경우
                // 해당 edge는 단절선임.
                // 다만 시작점은 더 작은 값이 오게 하기 위하여
                // now와 vertax중 더 작은 값을 시작점으로 설정함.
                if (low > order[vertax]) {
                    if (now > vertax) {
                        ans.add(new Node(vertax, now));
                    } else {
                        ans.add(new Node(now, vertax));
                    }
                }
                ret = Math.min(ret, low);
            } else { // 자식 정점이 방문되었을 경우
                ret = Math.min(ret, order[now]);
            }
        }

        return ret;
    }
}