class Solution {
    public int solution(int a, int b) {
        return Integer.parseInt(String.valueOf(a).concat(String.valueOf(b))) 
            >= 2*a*b
            ? Integer.parseInt(String.valueOf(a).concat(String.valueOf(b)))
            : 2*a*b;
    }
}