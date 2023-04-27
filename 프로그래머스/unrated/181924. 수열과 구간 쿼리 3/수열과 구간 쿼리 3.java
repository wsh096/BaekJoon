class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        //swap문제
        for(int[] query : queries){
            int x = query[0], y = query[1];
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return arr;
    }
}