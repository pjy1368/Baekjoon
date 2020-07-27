import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
 
        long[] arr = new long[K];
        PriorityQueue<Long> pq = new PriorityQueue<>();
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            pq.offer(arr[i]);
        }
 
        long ans = 0;
 
        // 우선순위 큐에서 꺼낸 값을
        // 처음에 입력받는 소수 배열의 값들과 각각
        // 곱해서 다시 우선순위 큐에 넣어 줌.
        while (N-- > 0) {
            ans = pq.poll();
 
            for (int i = 0; i < K; i++) {
                // 문제의 정답은 2^31보다 작음.
                if ((ans * arr[i]) >= ((long) 2 << 30)) {
                    break;
                }
 
                pq.offer(ans * arr[i]);
 
                // 중복된 값을 배제하기 위하여 조건 추가.
                if (ans % arr[i] == 0) {
                    break;
                }
            }
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
