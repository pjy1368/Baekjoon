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

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		String total = String.valueOf(A * B * C);
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			map.put(i, 0);
		}

		for (int i = 0; i < total.length(); i++) {
			int temp = Integer.parseInt(String.valueOf(total.charAt(i)));
			map.put(temp, map.get(temp) + 1);
		}
		
		for(int i = 0; i < 10; i++) {
			bw.write((map.get(i)) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
