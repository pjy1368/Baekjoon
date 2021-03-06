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
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < 26; i++) {
			map.put((char) ('a' + i), 0);
		}
		
		String input = bf.readLine();
		for(int i = 0; i < input.length(); i++) {
			map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
		}
		
		for(int i = 0; i < 26; i++) {
			if(i == 25) {
				bw.write(map.get((char)('a' + i)) + "\n");
				break;
			}
			bw.write(map.get((char)('a' + i)) + " ");
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}

}
