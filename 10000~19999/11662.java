import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Person {
	Point start;
	Point end;

	Person(Point start, Point end) {
		this.start = new Point(start.x, start.y);
		this.end = new Point(end.x, end.y);
	}

	Point moveK(double p) {
		return new Point((int) (start.x + (end.x - start.x) * (p / 100)),
				(int) (start.y + (end.y - start.y) * (p / 100)));
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Person minho = new Person(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
				new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		Person kangho = new Person(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
				new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

		double fp = 0, lp = 100, ans = 2e9;
		while (lp - fp >= 1e-10) {
			double k1 = (fp * 2 + lp) / 3, k2 = (fp + 2 * lp) / 3;

			double m_k1_x = minho.start.x + (minho.end.x - minho.start.x) * (k1 / 100);
			double m_k1_y = minho.start.y + (minho.end.y - minho.start.y) * (k1 / 100);
			double m_k2_x = minho.start.x + (minho.end.x - minho.start.x) * (k2 / 100);
			double m_k2_y = minho.start.y + (minho.end.y - minho.start.y) * (k2 / 100);

			double k_k1_x = kangho.start.x + (kangho.end.x - kangho.start.x) * (k1 / 100);
			double k_k1_y = kangho.start.y + (kangho.end.y - kangho.start.y) * (k1 / 100);
			double k_k2_x = kangho.start.x + (kangho.end.x - kangho.start.x) * (k2 / 100);
			double k_k2_y = kangho.start.y + (kangho.end.y - kangho.start.y) * (k2 / 100);

			double dist_k1 = Math.pow(m_k1_x - k_k1_x, 2) + Math.pow(m_k1_y - k_k1_y, 2);
			double dist_k2 = Math.pow(m_k2_x - k_k2_x, 2) + Math.pow(m_k2_y - k_k2_y, 2);

			ans = Math.min(ans, Math.min(dist_k1, dist_k2));

			if (dist_k1 >= dist_k2) {
				fp = k1;
			} else {
				lp = k2;
			}
		}

		ans = Math.sqrt(ans);

		bw.write(String.format("%.10f", ans) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
