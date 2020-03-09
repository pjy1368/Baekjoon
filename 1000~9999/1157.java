import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		input = input.toUpperCase();

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		Iterator<Character> it = map.keySet().iterator();

		int max = 0;
		char result = ' ';
		
		Integer[] cnt = new Integer[map.size()];
		int index = 0;
		while (it.hasNext()) {
			char c = it.next();
			
			cnt[index++] = map.get(c);
			if (max < map.get(c)) {
				max = map.get(c);
				result = c;
			}
		}
		
		Arrays.sort(cnt, Comparator.reverseOrder());
		
		int x = cnt[0];
		for(int i = 1; i < cnt.length; i++) {
			if(x == cnt[i]) {
				bw.write("?\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
		}
		
		
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
