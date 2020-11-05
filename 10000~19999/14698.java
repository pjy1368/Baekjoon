import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final long MOD = 1000000007;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];
            PriorityQueue<Long> pq = new PriorityQueue<>(); // 오름차순 기준으로 정렬.

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Long.parseLong(st.nextToken());
                pq.offer(arr[i]);
            }

            long ans = 1;

            // 오버플로우 발생하지 않도록 MOD 연산을 잘 해주어야 함.
            while(pq.size() > 1) {
                long p1 = pq.poll();
                long p2 = pq.poll();
                long temp = p1 * p2;

                ans *= temp % MOD;
                ans %= MOD;

                pq.offer(temp);
            }

            sb.append(ans + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}