import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int burger;
		int minBurger = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			burger = Integer.parseInt(br.readLine());
			minBurger = Math.min(minBurger, burger);
		}
		
		int beverage;
		int minBeverage = Integer.MAX_VALUE;
		for(int i = 0; i < 2; i++) {
			beverage = Integer.parseInt(br.readLine());
			minBeverage = Math.min(minBeverage, beverage);
		}
		
		bw.write((minBurger + minBeverage - 50) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
