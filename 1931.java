import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		int temp = end - o.end;
		if (temp > 0) {
			return 1;
		}

		if (temp == 0) {
			if (start - o.start > 0) {
				return 1;
			}
		}

		return -1;
	}

}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Meeting[] m = new Meeting[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			m[i] = new Meeting(start, end);
		}
		Arrays.sort(m);

		int cnt = 1;
		Meeting meet = m[0];

		for (int i = 1; i < N; i++) {
			if (meet.end <= m[i].start) {
				cnt++;
				meet = m[i];
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
