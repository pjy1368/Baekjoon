import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		String[] suffix = new String[input.length()];
		suffix[0] = input;
		for(int i = 1; i < input.length(); i++) {
			suffix[i] = suffix[i - 1].replaceFirst(String.valueOf(suffix[i - 1].charAt(0)), "");
		}
		
		Arrays.sort(suffix);
		for(int i = 0; i < input.length(); i++) {
			bw.write(suffix[i] + "\n");
		}
		bw.flush();
		bf.close();
		bw.close();
	}

}
