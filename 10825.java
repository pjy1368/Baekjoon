import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
	String name;
	int kor;
	int eng;
	int math;

	Person(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		int ck = o.kor - kor;
		int ce = eng - o.eng;
		int cm = o.math - math;
		int cn = name.compareTo(o.name);
		return (ck != 0) ? ck : ((ce != 0) ? ce : ((cm != 0) ? cm : cn));
	}

}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Person[] people = new Person[N];
		for (int i = 0; i < N; i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			people[i] = new Person(name, kor, eng, math);
		}

		Arrays.sort(people);
		for (int i = 0; i < N; i++) {
			bw.write(people[i].name + "\n");
		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
