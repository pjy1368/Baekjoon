import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int order = 1; // 방문 순서
    static int[] discover;
    static boolean[] isCutVertax; // 단절점

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

        discover = new int[V + 1];
        isCutVertax = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (discover[i] == 0) {
                dfs(i, true, a);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= V; i++) {
            if (isCutVertax[i]) {
                cnt++;
            }
        }
        sb.append(cnt + "\n"); // 단절점의 개수

        for (int i = 1; i <= V; i++) {
            if (isCutVertax[i]) {
                sb.append(i + " "); // 단절점의 번호 목록
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int vertax, boolean isRoot, ArrayList<ArrayList<Integer>> a) {
        discover[vertax] = order++; // 방문 순서 저장
        int ret = discover[vertax];
        int child = 0;

        // 자식 검사
        for (int now : a.get(vertax)) {
            if (discover[now] == 0) { // 자식 정점이 방문되지 않았을 경우
                child++;

                // 자식 정점 중 방문 순서가 가장 빠른 값.
                // 이때, 특정 자식 정점이 여러 개의 정점을 타고 타고 올라가서 1번 정점까지
                // 갈 수도 있다는 점에 유의해야 함.
                int low = dfs(now, false, a); 

                // 루트 정점이 아니고,
                // 가장 작은 방문 순서가 vertax의 방문 순서보다 크거나 같을 경우
                // 해당 vertax는 단절점임.
                if (!isRoot && low >= discover[vertax]) {
                    isCutVertax[vertax] = true;
                }
                ret = Math.min(ret, low);
            } else { // 자식 정점이 방문되었을 경우
                ret = Math.min(ret, discover[now]);
            }
        }

        // 루트 정점이고,
        // 자식의 개수가 2개 이상이면 단절점임.
        if (isRoot && child >= 2) {
            isCutVertax[vertax] = true;
        }

        return ret;
    }
}