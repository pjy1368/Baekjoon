import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')) {
				result += ((char) input.charAt(i) <= 'm') ? (char) (input.charAt(i) + 13)
						: (char) (input.charAt(i) + 12 - 'z' + 'a');
			} else if ((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
				result += ((char) input.charAt(i) <= 'M') ? (char) (input.charAt(i) + 13)
						: (char) (input.charAt(i) + 12 - 'Z' + 'A');
			} else {
				result += input.charAt(i);
			}
			
		}

		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
