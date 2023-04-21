import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int n, int k) {
        return IntStream.rangeClosed(1,n).filter(num->num%k ==0).toArray();
    }
}