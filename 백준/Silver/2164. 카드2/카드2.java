import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }
        while(queue.size() > 1){
            queue.poll();
            int A = queue.poll();
            queue.offer(A);
        }
        System.out.println(queue.poll());
    }
}