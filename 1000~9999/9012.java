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
		int N = Integer.parseInt(bf.readLine());
		outer: for(int i = 0; i < N; i++) {
			String input = bf.readLine();
			int open = 0;
			
			for(int j = 0; j < input.length(); j++) {
				char blank = input.charAt(j);
				if(blank == '(') {
					open++;
				} else if(blank == ')') {
					open--;
					
					if(open < 0) {
						bw.write("NO\n");
						continue outer;
					}
				}
			}
			
			if(open != 0) {
				bw.write("NO\n");
			}else {
				bw.write("YES\n");
			}
		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
