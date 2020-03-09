import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
		int M = Integer.parseInt(st.nextToken()); // 배열 B의 크기

		long[] A = new long[N];
		long[] B = new long[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Long.parseLong(st.nextToken());
		}

		long[] C = new long[N + M];

		int i = 0, j = 0, k = 0;

		while (i < N && j < M) {
			if (A[i] < B[j]) {
				C[k++] = A[i++];
			} else {
				C[k++] = B[j++];
			}
		}

		while (i < N) {
			C[k++] = A[i++];
		}

		while (j < M) {
			C[k++] = B[j++];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(C[0]);

		for (int a = 1; a < C.length; a++) {
			sb.append(" " + C[a]);
		}
		
		bw.write(sb + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
