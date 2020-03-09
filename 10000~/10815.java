import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 카드의 개수
		long[] cards = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(cards);
		int M = Integer.parseInt(br.readLine()); // 구별할 수의 개수
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(cards, N, temp) + " ");
		}

		sb.append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int binarySearch(long[] cards, int N, int search) {
		int first = 0;
		int last = N - 1;
		int mid = 0;

		while (first <= last) {
			mid = (first + last) / 2;

			if (cards[mid] == search) {
				return 1;
			}

			if (cards[mid] < search) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}

		return 0;
	}

}
