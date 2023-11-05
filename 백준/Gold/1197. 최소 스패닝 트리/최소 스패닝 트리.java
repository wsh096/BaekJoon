import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	static int V, E, ans;
	static boolean[] visited;
	static ArrayList<Node>[] nodeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		visited = new boolean[V+1];
		nodeList = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nodeList[from].add(new Node(to, cost));
			nodeList[to].add(new Node(from, cost));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()){
			Node n = pq.poll();
			int to = n.to;
			int cost = n.cost;
			
			if(visited[to]) continue;
			visited[to] = true;
			ans += cost;
			
			for(Node next : nodeList[to]) {
				if(!visited[next.to]) pq.add(next);
			}
		}
		
		System.out.println(ans);
	}
}