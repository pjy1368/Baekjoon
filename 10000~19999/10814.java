import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person>{
	int age;
	String name;
	
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		int c = age - o.age;
		if(c == 0) {
			return 0;
		}
		return c;
	}
	
	
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Person[] people = new Person[N];
		for(int i = 0; i < N; i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people[i] = new Person(age, name);
		}
		
		Arrays.sort(people);
		for(int i = 0; i < N; i++) {
			bw.write(people[i].age + " " + people[i].name + "\n");
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}

}
