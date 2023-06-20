import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes); 

        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            int weight = ropes[i] * (N - i); 
            maxWeight = Math.max(maxWeight, weight);
        }

        System.out.println(maxWeight);
        br.close();
    }
}