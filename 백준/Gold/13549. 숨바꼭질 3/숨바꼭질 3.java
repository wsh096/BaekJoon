import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];

        bfs(N);

        System.out.println(min);
    }

    static void bfs(int val) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(val, 0));
        visited[val] = true;

        while (!q.isEmpty()) {
            Node a = q.poll();

            if (a.x == K)
                min = Math.min(min, a.time);

            if (a.x * 2 <= 100_000 && !visited[a.x * 2]) {
                q.offer(new Node(a.x * 2, a.time));
                visited[a.x * 2] = true;
            }

            if (a.x - 1 >= 0 && !visited[a.x - 1]) {
                q.offer(new Node(a.x - 1, a.time + 1));
                visited[a.x - 1] = true;
            }

            if (a.x + 1 <= 100_000 && !visited[a.x + 1]) {
                q.offer(new Node(a.x + 1, a.time + 1));
                visited[a.x + 1] = true;
            }
        }
    }
}

class Node {
    int x, time;

    Node(int x, int time) {
        this.x = x;
        this.time = time;
    }
}
