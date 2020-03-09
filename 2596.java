import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] ps = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };
		Map<String, Character> map = new HashMap<>();
		for (int i = 0; i < 8; i++) {
			map.put(ps[i], (char) ('A' + i));
			for (int j = 0; j < 6; j++) {
				StringBuilder sb = new StringBuilder(ps[i]);
				sb.setCharAt(j, (sb.charAt(j) == '0' ? '1' : '0'));
				map.put(sb.toString(), (char) ('A' + i));
			}
		}

		int N = Integer.parseInt(br.readLine());

		String input = br.readLine();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String str = "";
			boolean isCorrect = false;
			for (int j = 0; j < 6; j++) {
				str += input.charAt(6 * i + j);
			}

			if (map.containsKey(str)) {
				ans.append(map.get(str));
				isCorrect = true;
			}

			if (!isCorrect) {
				bw.write((i + 1) + "\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
		}

		bw.write(ans.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
