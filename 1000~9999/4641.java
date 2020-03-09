import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			String input = br.readLine();
			if (input.equals("-1")) {
				break;
			}

			st = new StringTokenizer(input);

			Vector<Integer> v = new Vector<>();
			while (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 0) {
					break;
				}
				v.add(temp);
			}

			int ans = 0;
			for (int i = 0; i < v.size(); i++) {
				if (v.get(i) % 2 == 0 && v.contains(v.get(i) / 2)) {
					ans++;
				}
			}
			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
