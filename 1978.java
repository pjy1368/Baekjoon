import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		if (N == 0) {
			bw.write("0");
			bw.flush();
			bw.close();
			bf.close();
			return;
		}

		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int[] nums = new int[101];

		int result = 0;
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			result += Eratos(nums[i]);
		}
		
		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

	public static int Eratos(int num) {
		ArrayList<Boolean> primeList;

		if (num <= 1) {
			return 0;
		}
		
		primeList = new ArrayList<Boolean>(num + 1);
		primeList.add(false);
		primeList.add(false);
		
		for (int i = 2; i <= num; i++)
			primeList.add(i, true);

		for (int i = 2; (i * i) <= num; i++) {
			if (primeList.get(i)) {
				for (int j = i * i; j <= num; j += i)
					primeList.set(j, false);
			}
		}
		
		if(primeList.get(num)) {
			return 1;
		}

		return 0;
	}

}
