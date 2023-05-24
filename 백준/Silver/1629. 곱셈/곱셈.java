import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);
        
        long result = power(A,B,C);
        System.out.println(result);
        br.close();
    }
    private static long power(long A, long B, long C){
        if(B == 0) return 1;
        
        long temp = power(A,B/2,C) % C;
        long result = (temp * temp) % C;
        
        if(B % 2 == 1)
            result = (result * A) % C;
        
        return result;
    }
}

