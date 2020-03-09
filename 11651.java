import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		int cy = y - o.y;
		return (cy != 0) ? cy : (x - o.x);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y;
	}
	
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Point[] points = new Point[N];
		for(int i = 0; i < N; i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(points);
		for(int i = 0; i < N; i++) {
			bw.write(points[i] + "\n");
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}

}
