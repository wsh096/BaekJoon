import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int end = targets[0][1];
        int answer = 1;//최초 요격
    
        for(int[] target : targets)
            if(end <= target[0]){
                end = target[1];
                answer++;
            }

        return answer;
    }
}