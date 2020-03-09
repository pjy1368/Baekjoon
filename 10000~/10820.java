import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		while ((input = bf.readLine()) != null) {
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < 26; i++) {
				map.put((char) ('a' + i), 0);
				map.put((char) ('A' + i), 0);
			}

			for (int i = 0; i < 10; i++) {
				map.put((char) ('0' + i), 0);
			}

			map.put(' ', 0);

			for (int i = 0; i < input.length(); i++) {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			}

			int smallResult = 0;
			int bigResult = 0;
			int blank = map.get(' ');
			int numResult = 0;
			for (int i = 0; i < 26; i++) {
				smallResult += map.get((char) ('a' + i));
				bigResult += map.get((char) ('A' + i));
				if (i < 10) {
					numResult += map.get((char) ('0' + i));
				}
			}
			bw.write(smallResult + " " + bigResult + " " + numResult + " " + blank + "\n");
			bw.flush();
		}
		bf.close();
		bw.close();
	}

}
