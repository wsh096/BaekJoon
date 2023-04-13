class Solution {
    public int solution(int storey) {
        return elevator(storey);
    }
    private int elevator(int floor){
        if(floor<=1) return floor;
        int remainer = floor % 10;
        int newFloor = floor / 10;
        
        int c1 = remainer + elevator(newFloor);
        int c2 = (10-remainer) + elevator(newFloor+1);
        return Math.min(c1,c2);
    }
}