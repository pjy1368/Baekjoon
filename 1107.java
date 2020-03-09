import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Remote {
	int channel;
	int cnt;

	Remote(int channel, int cnt) {
		this.channel = channel;
		this.cnt = cnt;
	}
}

public class Main {
	static final int NOW = 100; // 현재 채널
	static int N;
	static boolean[] button;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 이동하려는 채널.

		if (N == NOW) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수.

		if (M != 0) {
			st = new StringTokenizer(br.readLine());

			button = new boolean[10];
			while (st.hasMoreTokens()) { // 고장난 버튼에만 true로 처리.
				int temp = Integer.parseInt(st.nextToken());
				button[temp] = true;
			}

			// +, -로만 이동.
			ans = Math.abs(N - NOW);

			// 모든 버튼이 고장나 있으면, +, -로만 이동한 것을 정답으로 함.
			boolean isBreak = true;
			for (int i = 0; i < button.length; i++) {
				if (!button[i]) {
					isBreak = false;
				}
			}

			if (isBreak) {
				bw.write(ans + "\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}

			// 고장난 버튼 이외의 버튼을 누르면서 +, -를 섞음.
			String channel = String.valueOf(N);

			// 1. 고장난 버튼 없이 N을 입력할 수 있음.
			if (Check(N)) {
				ans = Math.min(ans, channel.length());
			} else { // 2. N을 입력하는 데 고장난 버튼이 존재함.
				Find();
			}
			bw.write(ans + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		} else {
			bw.write(Math.min(Math.abs(N - NOW), String.valueOf(N).length()) + "\n");
			bw.flush();
			bw.close();
			br.close();
		}
	}

	public static boolean Check(int num) {
		String channel = String.valueOf(num);
		for (int i = 0; i < channel.length(); i++) {
			int temp = Integer.parseInt(String.valueOf(channel.charAt(i)));
			if (button[temp]) {
				return false;
			}
		}
		return true;
	}

	public static void Find() {
		int left = N;
		int right = N;

		while (true) {
			left--;
			right++;

			if (left >= 0 && Check(left)) {
				ans = Math.min(ans, Math.abs(left - N) + String.valueOf(left).length());
				return;
			}

			if (Check(right)) {
				ans = Math.min(ans, Math.abs(right - N) + String.valueOf(right).length());
				return;
			}
		}

	}

}
