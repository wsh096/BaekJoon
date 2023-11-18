import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] weight;
    static int[][] DP;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<ArrayList<Integer>> tree = new ArrayList<>();
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        weight = new int[n + 1];
        DP = new int[n + 1][2];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++)
            weight[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        buildTree(1, 0);

        int result = 0;
        int rootInclude = search(1, 1);
        int rootNonInclude = search(1, 0);
        if (rootInclude > rootNonInclude) {
            result += rootInclude;
            trace(1, 1);
        } else {
            result += rootNonInclude;
            trace(1, 0);
        }
        bw.write(result + "\n");
        while (!queue.isEmpty())
            bw.write(queue.poll() + " ");

        bw.flush();
        bw.close();
        br.close();
    }

    static void trace(int cur, int check) {
        if (check == 1) {
            queue.add(cur);
            for (Integer next : tree.get(cur)) {
                trace(next, 0);
            }
        } else {
            for (Integer next : tree.get(cur)) {
                if (DP[next][1] > DP[next][0]) {
                    trace(next, 1);
                } else
                    trace(next, 0);
            }
        }
    }

    static int search(int cur, int check) {
        int result = 0;
        if (DP[cur][check] != 0) {
            return DP[cur][check];
        }

        if (check == 1) {
            result += weight[cur];
            for (Integer next : tree.get(cur))
                result += search(next, 0);
        } else {
            for (Integer next : tree.get(cur)) {
                int include = search(next, 1);
                int nonInclude = search(next, 0);
                if (include > nonInclude) {
                    result += include;
                } else
                    result += nonInclude;
            }
        }
        return DP[cur][check] = result;
    }

    static void buildTree(int cur, int root) {
        for (Integer next : graph.get(cur)) {
            if (next != root) {
                tree.get(cur).add(next);
                buildTree(next, cur);
            }
        }
    }
}
