import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

class ListGraph {
	private ArrayList<ArrayList<Integer>> listGraph;

	// 그래프 초기화
	public ListGraph(int initSize) {
		this.listGraph = new ArrayList<ArrayList<Integer>>(); // 그래프 생성

		// 그래프 초기화
		// put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
		// ArrayList의 index는 0 부터 시작이므로
		// ArrayIndexOutOfBoundsException 방지를 위해
		// 정점을 담는 인접리스트의 size는 1을 더하여 초기화해줌
		// ex) initSize = 3
		// graph[0]
		// graph[1] -> 2 -> 3
		// graph[2] -> 1 -> 3 -> 4
		// graph[3] -> 1 -> 2 -> 4 -> 5
		for (int i = 0; i < initSize + 1; i++) {
			listGraph.add(new ArrayList<Integer>());
		}
	}

	// 그래프 return
	public ArrayList<ArrayList<Integer>> getGraph() {
		return this.listGraph;
	}

	// 그래프의 특정 노드 return
	public ArrayList<Integer> getNode(int i) {
		if(this.listGraph.size() <= i) {
			return null;
		}
		return this.listGraph.get(i);
	}

	// 그래프 추가 (단방향)
	public void putSingle(int x, int y) {
		listGraph.get(x).add(y);
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 순서쌍 수

		Vector<Integer> student = new Vector<>(); // 초기 배열 1, 2, 3, ... , N
		for (int i = 0; i < N; i++) {
			student.add(i + 1);
		}

		Vector<Integer> total = new Vector<>(); // 학생이 가진 카드의 배열
		ListGraph adjList = new ListGraph(N);
		for (int i = 0; i < M; i++) { // 순서쌍 입력
			String str = bf.readLine();
			StringTokenizer st2 = new StringTokenizer(str, " ");

			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			adjList.putSingle(x, y);
		}

		int[] backNum = new int[N]; // 한 학생이 가진 카드 수보다 작은 학생이 몇명인지 저장
		for (int i = 0; i < backNum.length; i++) {
			backNum[i] = adjList.getNode(i + 1).size();
		}

		for (int i = 0; i < backNum.length; i++) { // 위상정렬 응용
			total.add(student.get(backNum[i]));
			student.remove(backNum[i]);
		}

		for (int i = 0; i < N; i++) { // 잘못된 조건일 때, 출력
			for (int j = 0; j < adjList.getNode(i + 1).size(); j++) {
				if (total.get(i) < total.get(adjList.getNode(i + 1).get(j) - 1)) {
					System.out.println("-1");
					scan.close();
					return;
				}
			}
		}

		for (int i = 0; i < total.size(); i++) { // 정상적인 조건일 때, 출력
			System.out.print(total.get(i) + " ");
		}

		scan.close();
	}

}
