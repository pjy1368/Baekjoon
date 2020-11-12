import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }  
        // ���� �ð��� �������� �������� �����ϵ�,
        // ���� �ð��� ���ٸ�, ���� �ð��� �������� �������� �����Ѵ�.
        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        // �켱���� ť���� ���� �ð��� ����, ������������ �ڵ� ���ĵȴ�.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for (int i = 1; i < N; i++) {
            // �켱���� ť���� ���� ���� ���� �ð���
            // ���� lectures[i]�� ���� �ð��� ���Ѵ�.
            if (pq.peek() <= lectures[i].start) {
                pq.poll();
            }
            pq.offer(lectures[i].end);
        }

        // ���� �켱���� ť�� �����ִ� ����� ������ �ʿ��� �ּ����� ���ǽ� �����̴�.
        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}