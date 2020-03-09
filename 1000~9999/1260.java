import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int v, e, start;
	static ArrayList<ArrayList<Integer>> a;
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[v + 1];
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			for(int t : a.get(node)) {
				if(visit[t]) {
					continue;
				}
				
				visit[t] = true;
				q.offer(t);
			}
		}
		
	}
	
	public static void DFS(int start) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visit = new boolean[v + 1];
		
		stack.push(start);
		visit[start] = true;
		System.out.print(start + " ");
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			
			if(!visit[node]) {
				System.out.print(node + " ");
				visit[node] = true;
			}
			
			for(int i = a.get(node).size() - 1; i >= 0; i--) {
				if(!visit[a.get(node).get(i)]) {
					stack.push(a.get(node).get(i));
				}
			}
			
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		a = new ArrayList<>();
		for(int i = 0; i <= v; i++) {
			a.add(new ArrayList<>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			
			a.get(t).add(f);
			a.get(f).add(t);
		}
		
		for(int i = 1; i <= v; i++) {
			Collections.sort(a.get(i));
		}
		
		DFS(start);
		BFS(start);
		
		br.close();
	}

}
