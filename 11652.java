import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Map<Long, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			long input = Long.parseLong(bf.readLine()); 
			int count = map.containsKey(input) ? map.get(input) : 0;
			map.put(input, count + 1);
		}
		Vector<Long> v = new Vector<>();
		v.addAll(map.keySet());
		Collections.sort(v);
		
		Iterator<Long> it = v.iterator();
		Long end = it.next();
		
		while(it.hasNext()) {
			long temp = it.next();
			if(map.get(end) < map.get(temp)) {
				end = temp;
			}
		}
		bw.write(end + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
