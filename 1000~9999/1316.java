import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			String word = String.valueOf(input.charAt(0));
			for (int j = 1; j < input.length(); j++) {
				char c = input.charAt(j);

				if (input.charAt(j - 1) == c) {
					continue;
				}

				word += c;
			}

			Set<Character> set = new HashSet<>();

			String str = "";
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (!set.contains(c)) {
					set.add(word.charAt(j));
					str += c;
				}
			}

			if (word.equals(str)) {
				ans++;
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
