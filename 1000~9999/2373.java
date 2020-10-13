import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] fibo = new int[30];
		fibo[1] = 1;
		fibo[2] = 2;

		Set<Integer> fiboSet = new HashSet<>();
		fiboSet.add(1);
		fiboSet.add(2);

		// 29번째 피보나치 수가 100만보다 작은 가장 큰 수임.
		for (int i = 3; i < 30; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
			fiboSet.add(fibo[i]);
		}

		int N = Integer.parseInt(br.readLine());

		if (fiboSet.contains(N)) { // N이 피보나치 수면 선공 필패.
			bw.write("-1\n");
		} else {
			int[] beads = new int[N + 1];
			int idx = 0;
			int maxFibo = 0;

			// 피보나치 수 a와 피보나치 수 b 사이는 모두 선공이 이김.
			// 그 사이에서는 다음과 같은 규칙이 성립함.
			// a와 b 사이의 인덱스를 idx(1부터 시작.)이라고 하자.
			// 그렇다면, idx가 피보나치 수라면, 선공은 idx만큼 구슬을 빼는 것이 최소의 수임.
			// idx가 피보나치 수가 아니라면, 선공은 idx보다 작은 가장 큰 피보나치 수 x를 구한 뒤,
			// beads[i - x]만큼의 구슬을 빼는 것이 최소의 수임.
			// 참고로, a와 b 사이에는 "1, 2, 3, 1, 5, 1, 2, 3, ... "과 같은 수열이 반복됨.
			for (int i = 2; i <= N; i++) {
				if (fiboSet.contains(i)) {
					idx = 0;
					maxFibo = 0;
				} else {
					idx++;

					if (fiboSet.contains(idx)) {
						beads[i] = idx;
						maxFibo = idx;
					} else {
						beads[i] = beads[i - maxFibo];
					}
				}
			}
			bw.write(beads[N] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}